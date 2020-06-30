package ar.edu.utn.mdp.scene;

import ar.edu.utn.mdp.content.component.Component;
import ar.edu.utn.mdp.content.component.ComponentCollection;
import ar.edu.utn.mdp.frames.Game;

import java.awt.*;

public abstract class Scene {

    protected static Game game;
    protected ComponentCollection<Component> components;
    private boolean changingScene;
    private boolean active;

    public Scene() {
        this.components = new ComponentCollection<>();
        this.active = false;
        this.changingScene = false;
    }

    public Scene(boolean active) {
        this.components = new ComponentCollection<>();
        this.active = active;
        this.changingScene = false;
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

    public boolean isChangingScene() {
        return changingScene;
    }

    public void setChangingScene(boolean changingScene) {
        this.changingScene = changingScene;
    }

    public abstract void setupScene();

    public abstract void drawScene();

    public void paintScene(Graphics g) {
        components.drawAll(g);
    }
}
