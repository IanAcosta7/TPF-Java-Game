package ar.edu.utn.mdp.frames;

import ar.edu.utn.mdp.scene.Scene;
import ar.edu.utn.mdp.utils.Input;

import javax.swing.*;
import java.awt.*;

public class Application {

    private int width = 800;
    private int height = 600;

    private Game game;
    private JFrame frame;
    private Input input;

    public Application () {
        frame = new JFrame();
    }

    /**
     * En este metodo se setea lo que se va a ver al inicio de la pantalla principal
     */
    public void init() {
        //Thread game = new Thread(new Game(height, width));
        input = new Input();

        game = new Game();
        game.setSize(width, height);
        game.setBackground(Color.BLACK);
        game.setup();

        frame.setTitle("Game");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(width, height);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.getContentPane().add(game);
        frame.addKeyListener(input);
        frame.addMouseListener(input);
        frame.setVisible(true);

        game.start();
    }

    /**
     *
     * @return Retorna el ancho de la pantalla principal
     */
    public int getWidth() {
        return width;
    }

    /**
     *
     * @return Retorna la altura de la pantalla principal
     */
    public int getHeight() {
        return height;
    }

    /**
     *
     * @param width Setea el ancho de la pantalla principal
     */
    public void setWidth(int width) {
        this.width = width;
    }

    /**
     * Setea el alto de la pantalla principal
     */
    public void setHeight() {
        this.setHeight();
    }
}
