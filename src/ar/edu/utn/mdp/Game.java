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
        // GRID
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
      
        //TEXTOS
        components.add(new Text("PlayerNombre", width-width/5, height/6, 0, 80, 40,"PLAYER ONE" ));
        components.add(new Text("combustible", width-width/5, height/4, 0, 80, 40,"COMBUSTIBLE:" ));
        components.add(new Text("NumCombustible", (width-width/5) + 90, height/4, 0, 80, 40,"1000"));
        components.add(new Text("score", width-width/5,height/2-40, 0, 80, 40,"SCORE:" ));
        components.add(new Text("NumScore", (width-width/5) + 50, height/2 - 40, 0, 80, 40,"500"));
        components.add(new Text("velocidad", width-width/5, height-height/3, 0, 80, 40,"VELOCIDAD:"));
        components.add(new Text("NumVelocidad", (width-width/5) + 75, height-height/3, 0, 80, 40,"500"));

        // PLAYER
        components.add(new Car("Player", width/2 - 50/2, height/2 - 50/2, 0, 50, 50, "autoN1", new HitBox(width/2 - 50/2 + 50/3,height/2 - 50/2, 0, 50/3,50)));
    }

    private void draw() {
        if(Input.getKey(37))
            components.get(components.size() - 1).setX(components.get(components.size() - 1).getX() - 1);
        if(Input.getKey(39))
            components.get(components.size() - 1).setX(components.get(components.size() - 1).getX() + 1);
        
        Text text=(Text)components.get(components.size() - 6);
        //text.setTexto(Integer.toString(sumador));
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.WHITE);

        Iterator iterator = components.iterator();

        while (iterator.hasNext()) {
            Component component = (Component) iterator.next();

            if (component.isDrawn()){
                if (component instanceof Sprite) {
                    Sprite sprite = (Sprite) component;

                    g.drawImage(sprite.getImage(), sprite.getX(), sprite.getY(), sprite.getWidth(), sprite.getHeight(), null);
                }
                if(component  instanceof Text)
                {
                    Text text =(Text)component;
                    g.drawString(text.getTexto(), text.getX(), text.getY());
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
