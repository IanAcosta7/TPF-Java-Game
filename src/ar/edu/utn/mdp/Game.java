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
    int x=width/2;
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        if(Input.getKey(37))
        {
            x--;
        }
        if(Input.getKey(39))
        {
            x++;
        }


        //g.fillRect(100, 100, 30, 30);
        g.drawImage(loader.getSprites().get("autoN1"),x,height/2-50/2,50,50,null);

    }

    public void start() {
        running = true;

        long actualTime = System.nanoTime(); // Tiempo actual
        long nextTime = actualTime + 1000000000 / maxFrameRate; // 1 Seg dividido en N cuadros

        while (running) {
            if (actualTime >= nextTime) {
                draw();
                repaint();
                nextTime = actualTime + 1000000000 / maxFrameRate;
            }
            actualTime = System.nanoTime();
        }
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
