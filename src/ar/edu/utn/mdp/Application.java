package ar.edu.utn.mdp;

import javax.swing.*;

public class Application {

    private int width = 800;
    private int height = 600;

    Game game;
    private JFrame frame;
    private Input input;

    public Application () {
        frame = new JFrame();
    }

    public void init() {
        //Thread game = new Thread(new Game(height, width));
        input = new Input();
        game = new Game(width, height);

        frame.setTitle("Game");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(width, height);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.getContentPane().add(game);
        frame.addKeyListener(input);
        frame.addMouseListener(input);

        frame.setVisible(true);


        update();
    }

    public void update() {
        input.update();


        while (true) {
            frame.repaint();
        }
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public void setHeight() {
        this.setHeight();
    }
}
