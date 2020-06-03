package ar.edu.utn.mdp;

public abstract class Component
{
    private String name;
    private int x;
    private int y;
    private int rotation;
    private int width;
    private int height;
    private boolean drawn;

    public Component(String name, int x, int y, int rotation, int width, int height) {
        this.name = name;
        this.x = x;
        this.y = y;
        this.rotation = rotation;
        this.width = width;
        this.height = height;
        this.drawn = true;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setDrawn(boolean drawn) {
        this.drawn = drawn;
    }

    public boolean isDrawn() {
        return drawn;
    }

    public void setRotation(int rotation) {
        this.rotation = rotation;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getRotation() {
        return rotation;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }
}
