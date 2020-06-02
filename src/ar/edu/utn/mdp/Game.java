package ar.edu.utn.mdp;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class Game extends JPanel {

    private int width;
    private int height;
    private int maxFrameRate = 60;
    private Loader loader;
    private boolean running;
    private HashMap<String, Component> components;

    public Game (int width, int height) {
        this.width = width;
        this.height = height;
        this.loader = new Loader();
        this.components = new HashMap<>();
        init();
    }

    public void init() {
        setSize(width, height);
        setBackground(Color.BLACK);
        setup();
    }

    private void setup() {
        components.put("Player", new Sprite(width/2 - 50/2, height/2 - 50/2, 0, 50, 50, "autoN1"));
    }

    private void draw() {
        components.get("Player").setDrawn(true);
        if(Input.getKey(37))
            components.get("Player").setX(components.get("Player").getX() - 1);
        if(Input.getKey(39))
            components.get("Player").setX(components.get("Player").getX() + 1);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        Set<Map.Entry<String, Component>> entry = components.entrySet();
        Iterator<Map.Entry<String, Component>> iterator = entry.iterator();

        while (iterator.hasNext()) {
            Component component = iterator.next().getValue();

            if (component.isDrawn()){
                if (component instanceof Sprite) {
                    Sprite sprite = (Sprite) component;

                    g.drawImage(sprite.getImage(), sprite.getX(), sprite.getY(), sprite.getWidth(), sprite.getHeight(), null);
                }
            }
        }
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
