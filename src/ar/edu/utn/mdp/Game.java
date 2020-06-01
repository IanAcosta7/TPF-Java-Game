package ar.edu.utn.mdp;

import javax.swing.*;
import java.awt.*;

public class Game extends JPanel {

    private int width;
    private int height;
    private int maxFrameRate = 60;
    private Loader loader;
    private boolean running;

    public Game (int width, int height) {
        this.width = width;
        this.height = height;
        this.loader = new Loader();
        init();
    }

    public void init() {
        setSize(width, height);
    }

    private void draw()
    {
        //newImage("player", 10, 2, 2)
    }

    public void paintComponent(Graphics g)
    {
        //g.fillRect(100, 100, 30, 30);
    }

    public void setWidth(int width)
    {
        this.width = width;
    }

    public void setHeight(int height)
    {
        this.height = height;
    }

    public int getWidth()
    {
        return width;
    }

    public int getHeight()
    {
        return height;
    }
}