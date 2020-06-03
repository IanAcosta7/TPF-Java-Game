package ar.edu.utn.mdp;

import javax.swing.*;
import java.awt.*;
import java.util.*;

public class Game extends JPanel {

    private int width;
    private int height;
    private int maxFrameRate = 60;
    private Loader loader;
    private boolean running;
    private ArrayList<Component> components;

    public Game (int width, int height) {
        this.width = width;
        this.height = height;
        this.loader = new Loader();
        this.components = new ArrayList<>();
        init();
    }

    public void init() {
        setSize(width, height);
        setBackground(Color.BLACK);
        setup();
    }

    private void setup() {
        Grid grid = new Grid(0, 0, 50, 10, 10);

        for (ArrayList<Sprite> tiles : grid.getTiles())
            tiles.forEach((Sprite tile)-> tile.setImage(Loader.getSprites().get("pastoFinal")));

        for (int i = 0; i < grid.getTiles().size(); i++) {
            ArrayList<Sprite> tiles = grid.getTiles().get(i);

            for (int j = 0; j < tiles.size(); j++) {
                Sprite tile = tiles.get(j);

                String key = Integer.toString(i) + Integer.toString(j);

                components.add(tile);
            }
        }

        components.add(new Sprite("Player", width/2 - 50/2, height/2 - 50/2, 0, 50, 50, "autoN1"));
    }

    private void draw() {
        if(Input.getKey(37))
            components.get(components.size() - 1).setX(components.get(components.size() - 1).getX() - 1);
        if(Input.getKey(39))
            components.get(components.size() - 1).setX(components.get(components.size() - 1).getX() + 1);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        Iterator iterator = components.iterator();

        while (iterator.hasNext()) {
            Component component = (Component) iterator.next();

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
