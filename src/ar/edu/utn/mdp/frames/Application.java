package ar.edu.utn.mdp.frames;

import ar.edu.utn.mdp.utils.Input;

import javax.swing.*;
import java.awt.*;

/**
 * Es una clase <b>Singleton</b> y es la clase principal del programa.
 * Mediante el uso del metodo publico <tt>init()</tt> se encarga de
 * inicializar el juego y la ventana con los atributos que incluye
 * por defecto.
 */
public class Application {

    /**
     * Es la unica instancia de la clase, que recibe un ancho de 800 y una altura de 600.
     */
    private static final Application INSTANCE = new Application(800, 600);
    /**
     * Define el ancho de la ventana
     */
    private int width;
    /**
     * Define el alto de la ventana
     */
    private int height;

    /**
     * Crea una instancia de <tt>Application</tt>, es privado para garantizar su unicidad.
     *
     * @param width el ancho de la ventana.
     * @param height el alto de la ventana.
     */
    private Application (int width, int height) {
        this.width = width;
        this.height = height;
    }

    /**
     * Este metodo crea las instancias de <tt>javax.swing.JFrame</tt>
     * y de <tt>Game</tt> y les asigna el tamaño correspondiente, asi
     * como tambien setea muchos otros de sus atributos.
     */
    public static void init() {
        //Thread game = new Thread(new Game(height, width));
        Input input = new Input();

        Game game = new Game();
        game.setSize(INSTANCE.width, INSTANCE.height);
        game.setBackground(Color.BLACK);
        game.setup();

        JFrame frame = new JFrame();
        frame.setTitle("Game");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(INSTANCE.width, INSTANCE.height);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.getContentPane().add(game);
        frame.addKeyListener(input);
        frame.setVisible(true);

        game.start();
    }


    /**
     * Devuelve la unica instancia de esta clase.
     * @return la unica instancia de esta clase.
     */
    public static Application getInstance() {
        return INSTANCE;
    }

    /**
     * Devuelve el ancho de la ventana.
     * @return el ancho de la ventana.
     */
    public int getWidth() {
        return width;
    }

    /**
     * Devuelve el alto de la ventana.
     * @return el alto de la ventana.
     */
    public int getHeight() {
        return height;
    }
}
