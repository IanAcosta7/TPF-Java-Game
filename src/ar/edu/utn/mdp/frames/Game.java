package ar.edu.utn.mdp.frames;

import ar.edu.utn.mdp.scene.*;
import ar.edu.utn.mdp.utils.Loader;
import ar.edu.utn.mdp.utils.LoaderMusic;
import org.json.JSONException;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;


/**
 * Es una versión personalizada de <b>javax.swing.JPanel</b>.
 * Tiene tres métodos que son llamados en distintos tiempos
 * de ejecución para permitirnos tener control sobre las
 * distintas etapas de ejecución de nuestro código. Y a su
 * vez tiene una lista de escenas que son llamadas en distintos
 * tiempos, dependiendo que es lo que se deba ver en el juego
 * en cada momento.
 */
public class Game extends JPanel {

    /**
     * Valor que indica si el juego esta corriendo.
     */
    private boolean running;
    /**
     * Mapa de las escenas que estan o no en ejecución.
     */
    private HashMap<String, Scene> scenes;

    /**
     * Crea una instancia de Game con un array de escenas vacío y el atributo running en true.
     */
    public Game () {
        super();
        this.running = true;
        this.scenes = new HashMap<>();
    }

    /**
     * Inicializa las variables y componentes que el juego necesitará.
     * <p>
     *     Se ejecuta una sola vez al comienzo del juego, lo que permite instanciar todas las variables
     *     o arreglos que las escenas necesitaran durante la ejecución del juego. Además permite realizar
     *     llamados a funciones que solo se deben ejecutar una vez, como por ejemplo la carga de Sprites.
     * </p>
     * <i><b>Solamente ejecutará las escenas que se encuentren activas.</b></i>
     */
    public void setup() {
        Scene.setGame(this);
        Loader.loadAll(); // Carga todas las imagenes
        LoaderMusic.loadAllMusic(); // Carga toda la musica

        // Escenas
        GameScene gameScene = new GameScene(true);
        Scoreboard scoreboard = new Scoreboard();

        scenes.put("Game", gameScene);
        scenes.put("Scoreboard", scoreboard);

        // INICIALIZA TODAS LAS ESCENAS ACTIVAS
        Iterator<Map.Entry<String, Scene>> iterator = scenes.entrySet().iterator();

        while (iterator.hasNext()) {
            Scene scene = iterator.next().getValue();

            if (scene.isActive())
                scene.setupScene();
        }
    }

    /**
     * Ejecuta toda la lógica de física o movimiento de los componentes.
     * <p>
     *     Se ejecuta una vez por cuadro, por lo que en este método se realizan todos los cálculos o cambios
     *     que se producirán durante el transcurso del juego.
     * </p>
     * <i><b>Solamente ejecutará las escenas que se encuentren activas.</b></i>
     */
    private void draw() {
        // LOGICA POR CUADRO
        changeScenes();

        // DIBUJA TODAS LAS ESCENAS ACTIVAS
        Iterator<Map.Entry<String, Scene>> iterator = scenes.entrySet().iterator();

        while (iterator.hasNext()) {
            Scene scene = iterator.next().getValue();

            if (scene.isActive())
                scene.drawScene();
        }
    }

    /**
     * Dibuja todos los componentes en pantalla.
     * <p>
     *     Este método se ejecuta justo después del método <b>draw</b> y es el encargado de dibujar en la
     *     pantalla todos los componentes de las escenas.
     * </p>
     * <i><b>Solamente ejecutará las escenas que se encuentren activas.</b></i>
     *
     * @param g El objeto de tipo <b>Graphics</b> que nos permite dibujar en la pantalla.
     */
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.WHITE);
        try
        {
            g.setFont(Font.createFont(Font.TRUETYPE_FONT, new File("assets\\game_over.ttf")).deriveFont(50f));
        }
        catch (Exception exception)
        {
            exception.printStackTrace();
        }

        // PINTA EN PANTALLA TODAS LAS ESCENAS ACTIVAS
        Iterator<Map.Entry<String, Scene>> iterator = scenes.entrySet().iterator();

        while (iterator.hasNext()) {
            Scene scene = iterator.next().getValue();

            if (scene.isActive())
                scene.paintScene(g);
        }
    }

    /**
     * Comienza la ejecución del juego.
     * <p>
     *     Tiene un limitador de cuadros por segundo, lo que evita que el juego corra a distintas
     *     velocidades en distintos dispositivos.
     * </p>
     * <p>
     *     También es el encargado de realizar la llamada a los tres métodos más importantes de esta
     *     clase donde se encuentra la lógica del juego, primero llama una sola vez a <b>setup</b>
     *     y luego se queda en un ciclo llamando a <b>draw</b> y a <b>paintComponent</b> en ese orden
     *     hasta que el atributo <b>running</b> se vuelva falso.
     * </p>
     */
    public void start() {
        final int MAXFRAMERATE = 60;
        running = true;

        long actualTime = System.nanoTime(); // Tiempo actual
        long nextTime = actualTime + 1000000000 / MAXFRAMERATE; // 1 Seg dividido en N cuadros

        while (running) {
            if (actualTime >= nextTime) {
                draw();
                repaint();
                nextTime = actualTime + 1000000000 / MAXFRAMERATE;
            }
            actualTime = System.nanoTime();
        }
    }

    private void changeScenes() {
        GameScene gameScene = (GameScene)scenes.get("Game");
        Scoreboard scoreboard = (Scoreboard) scenes.get("Scoreboard");

        if (gameScene.isChangingScene()) {
            gameScene.setChangingScene(false);
            gameScene.setActive(false);
            scoreboard.setActive(true);
            scoreboard.setupScene();
        }

        if (scoreboard.isChangingScene()) {
            scoreboard.setChangingScene(false);
            scoreboard.setActive(false);
            gameScene.setActive(true);
            gameScene.setupScene();
        }
    }
}
