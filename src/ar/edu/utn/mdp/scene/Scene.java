package ar.edu.utn.mdp.scene;

import ar.edu.utn.mdp.content.component.Component;
import ar.edu.utn.mdp.content.component.ComponentCollection;

import java.awt.*;

public abstract class Scene {

    protected static int width;
    protected static int height;
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

    public void setSize(int width, int height) {
        Scene.width = width;
        Scene.height = height;
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
