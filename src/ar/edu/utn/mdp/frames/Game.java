package ar.edu.utn.mdp.frames;

import ar.edu.utn.mdp.content.Street;
import ar.edu.utn.mdp.content.component.Grid;
import ar.edu.utn.mdp.content.component.drawable.*;
import ar.edu.utn.mdp.utils.Loader;
import ar.edu.utn.mdp.content.component.*;
import ar.edu.utn.mdp.content.component.Component;

import javax.swing.*;
import javax.swing.Timer;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.*;

public class Game extends JPanel {

    private int width;
    private int height;
    private final int maxFrameRate = 60;
    private Loader loader;
    private boolean running;
    private ComponentCollection<Component> components;

    public Game (int width, int height) {
        this.width = width;
        this.height = height;
        this.loader = new Loader();
        this.components = new ComponentCollection<>();
        init();
    }

    public void init() {
        setSize(width, height);
        setBackground(Color.BLACK);
        setup();
    }

    private void setup() {
        // GRID
        Grid grid = new Grid("Grid", 100, -64, 16, 30, 50, new Street(10, 20, 12, 3));
        components.set(grid);

        // TODO CAMBIAR LA FORMA EN QUE SE MUESTRA
        for (int i = 0; i < grid.getTiles().size(); i++) {
            ArrayList<Sprite> tiles = grid.getTiles().get(i);

            for (Sprite tile : tiles)
                components.set(tile);
        }

        //TEXTOS
        components.set(new Text("PlayerNombre", width-width/5, height/6, 0, 80, 40,"PLAYER ONE" ));
        components.set(new Text("combustible", width-width/5, height/4, 0, 80, 40,"COMBUSTIBLE:" ));
        components.set(new Text("NumCombustible", (width-width/5) + 40, (height/4)+30, 0, 80, 40,""));
        components.set(new Text("score", width-width/5,height/2-40, 0, 80, 40,"SCORE:" ));
        components.set(new Text("NumScore", (width-width/5) + 70, (height/2)- 40, 0, 80, 40,""));
        components.set(new Text("velocidad", width-width/5, height-height/3, 0, 80, 40,"VELOCIDAD:"));
        components.set(new Text("NumVelocidad", (width-width/5) + 45, (height-height/3) + 30, 0, 80, 40,""));
        components.set(new Text("Km/h ", (width-width/5) + 80, (height-height/3) + 30, 0, 80, 40,"km/h"));

        // PLAYER

        components.set(new Player("Player", width/2 - 85, height/2 + 75, 0, 50, 50, "Autos/autoN1", new HitBox("Player", width/2 - 85 + 50/4,height/2 + 75, 0, 50/2,50), 1, 1000, 0));


        Timer timer = new Timer(2500, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            components.set(new CarEnemy("enemy" + CarEnemy.getNumber(),-100, 0, 50, 50, "Autos/autoN2", new HitBox("Car", width / 3 - 50 / 2 + 50 / 4, -100, 0, 50 / 2, 50), 1));

            }
        });
        timer.start();


    }



    private void draw() {
        Player player = (Player)components.get("Player");
        ComponentCollection<CarEnemy> enemys = new ComponentCollection<>();


        for(int i =0; i< CarEnemy.getNumber(); i++){
            enemys.set((CarEnemy)components.get("enemy" + i));
        }

        for(int i =0; i<enemys.size(); i++){
            CarEnemy carEnemy = (CarEnemy)enemys.get("enemy" + i);
            if(carEnemy != null){
                carEnemy.moveCar(player.getSpeed());
                HitBox.hitboxCollision(player.getHitBox(), carEnemy.getHitBox());
            }
        }
        player.move();

       //player.editSpeedCollision();

        player.fuelConsumed();
        player.scoreCounter();

        //System.out.println(((Car) components.get("Car")).getSpeed());
        Text textFuel = (Text)components.get("NumCombustible");
        Text textScore = (Text)components.get("NumScore");
        Text textSpeed = (Text)components.get("NumVelocidad");

        textFuel.setTexto(Integer.toString((int)player.getFuel()));
        textScore.setTexto(Integer.toString((int)player.getScore()));
        textSpeed.setTexto(Integer.toString((int)player.getSpeed()));

        ((Grid)components.get("Grid")).update(player.getSpeed());
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

        components.drawAll(g);
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

    public void setWidth(int width) {
        this.width = width;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }
}
