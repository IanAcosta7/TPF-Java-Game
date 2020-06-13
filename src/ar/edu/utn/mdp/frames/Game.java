package ar.edu.utn.mdp.frames;

import ar.edu.utn.mdp.content.tileset.side.Grass;
import ar.edu.utn.mdp.content.tileset.Street;
import ar.edu.utn.mdp.content.component.Grid;
import ar.edu.utn.mdp.content.component.drawable.*;
import ar.edu.utn.mdp.scene.GameScene;
import ar.edu.utn.mdp.scene.Scene;
import ar.edu.utn.mdp.utils.Loader;
import ar.edu.utn.mdp.content.component.*;
import ar.edu.utn.mdp.content.component.Component;

import javax.swing.*;
import javax.swing.Timer;
import java.awt.*;
import java.io.File;
import java.util.*;

public class Game extends JPanel {

    private static int width;
    private static int height;
    private boolean running;
    private HashMap<String, Scene> scenes;

    public Game (int width, int height) {
        Game.width = width;
        Game.height = height;
        this.running = true;
        this.scenes = new HashMap<>();
        init();
    }

    public void init() {
        setSize(width, height);
        Scene.setSize(width, height);
        setBackground(Color.BLACK);
        Loader.loadAll(); // Carga todas las imagenes

        setup();
    }

    private void setup() {
        GameScene gameScene = new GameScene(true);
        gameScene.setupScene();

        scenes.put("Game", gameScene);

        // INICIALIZA TODAS LAS ESCENAS ACTIVAS
        Iterator<Map.Entry<String, Scene>> iterator = scenes.entrySet().iterator();

        while (iterator.hasNext()) {
            Scene scene = iterator.next().getValue();

            if (scene.isActive())
                scene.setupScene();
        }
    }

    private void draw() {
        // LOGICA POR CUADRO

        // DIBUJA TODAS LAS ESCENAS ACTIVAS
        Iterator<Map.Entry<String, Scene>> iterator = scenes.entrySet().iterator();

        while (iterator.hasNext()) {
            Scene scene = iterator.next().getValue();

            if (scene.isActive())
                scene.drawScene();
        }
    }

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

    @Override
    public int getWidth() {
        return width;
    }

    @Override
    public int getHeight() {
        return height;
    }
}
