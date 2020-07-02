package ar.edu.utn.mdp.scene;

import ar.edu.utn.mdp.content.component.ComponentCollection;
import ar.edu.utn.mdp.content.component.Grid;
import ar.edu.utn.mdp.content.component.drawable.*;
import ar.edu.utn.mdp.content.tileset.Street;
import ar.edu.utn.mdp.content.tileset.side.Grass;
import ar.edu.utn.mdp.utils.LoaderMusic;

import javax.sound.sampled.Clip;
import javax.swing.*;
import java.util.ArrayList;

public class GameScene extends Scene {

    public GameScene() {
        super();
    }

    public GameScene(boolean active) {
        super(active);
    }

    @Override
    public void setupScene() {
        components.clear();

        Clip song = LoaderMusic.getClip("pingFighter");
        song.start();

        // GRID
        Street street = new Street(10, 20, 12, 3);
        Grass grass1 = new Grass();
        Grass grass2 = new Grass();

        Grid grid = new Grid("Grid", 100, -64, 16, 30, 50, grass1, grass2, street);
        components.set(grid);

        // TODO CAMBIAR LA FORMA EN QUE SE MUESTRA
        for (int i = 0; i < grid.getTiles().size(); i++) {
            ArrayList<Tile> tiles = grid.getTiles().get(i);

            for (Sprite tile : tiles)
                components.set(tile);
        }

        int width = game.getWidth();
        int height = game.getHeight();

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
        components.set(new Player("Player", width/2 - 85, height/2 + 75, 0, 50, 50, "Autos/autoN1", new HitBox("PlayerHB", width/2 - 85 + 50/4,height/2 + 75, 0, 50/2,50), 1, 20, 0));
    }

    @Override
    public void drawScene() {
        Player player = (Player)components.get("Player");
        ComponentCollection<CarEnemy> enemys = new ComponentCollection<>();

        for(int i = 0; i < 5; i++){
            if(components.indexOf("enemy" + (CarEnemy.getNumber() - 5 + i)) != -1)
                enemys.set((CarEnemy)components.get("enemy" + (CarEnemy.getNumber() - 5 + i)));
        }

        for(int i = 0; i<enemys.size(); i++){
            CarEnemy carEnemy = (CarEnemy)enemys.get(i);
            if(carEnemy != null){
                carEnemy.moveCar(player.getSpeed());
                HitBox.hitboxCollision(player, carEnemy);
            }
        }

        if( CarEnemy.getNumber()< 5)  //CANTIDAD DE AUTOS INSTANCIABLES
        {
            components.set(new CarEnemy("enemy" + CarEnemy.getNumber(), 0, 50, 50, "Autos/autoN2", new HitBox("CarHB", game.getWidth() / 3 - 50 / 2 + 50 / 4, -100, 0, 50 / 2, 50), 1));
        }
        else
        {
            for(int i = 0; i<enemys.size(); i++) {
                if (enemys.get(i).getY()> 1000 || enemys.get(i).getY()<-1500) //
                {
                    CarEnemy.restarCarNumber();
                }
            }
        }

        player.move();
        player.invinsible();

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

        Grid grid = (Grid)components.get("Grid");

        grid.update(player.getSpeed());

        for(ArrayList<Tile> row : grid.getTiles()) {
            for (Tile tile : row) {
                if (tile.getHitBox() != null)
                    HitBox.hitboxCollision(player, tile);
            }
        }

        if (player.getFuel() <= 0.5 && player.getSpeed() <=0.5) {
            if (isActive()) {
                setChangingScene(true);
            }
        }

    }

}
