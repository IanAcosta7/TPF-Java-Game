package ar.edu.utn.mdp.scene;

import ar.edu.utn.mdp.content.component.Component;
import ar.edu.utn.mdp.content.component.ComponentCollection;
import ar.edu.utn.mdp.frames.Game;

import java.awt.*;

public abstract class Scene {

    protected static Game game;
    protected ComponentCollection<Component> components;
    private boolean active;

    public Scene() {
        this.components = new ComponentCollection<>();
        this.active = false;
    }

    public Scene(boolean active) {
        this.components = new ComponentCollection<>();
        this.active = active;
    }

    public ComponentCollection<Component> getComponents() {
        return components;
    }

    public static void setGame(Game game) {
        Scene.game = game;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public abstract void setupScene();

    public abstract void drawScene();

    public void paintScene(Graphics g) {
        components.drawAll(g);
    }
}
