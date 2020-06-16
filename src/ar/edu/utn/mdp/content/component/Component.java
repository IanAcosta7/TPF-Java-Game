package ar.edu.utn.mdp.content.component;

/**
 * Es la clase padre para todos los objetos que serán utilizados por el videojuego.
 * No todos ellos son dibujados, muchos solamente procesan la lógica de otros
 * componentes. Sin embargo hasta los que no son dibujados requieren guardar una
 * posición en la pantalla, ya que se utilizan como contenedores para otros
 * componentes que sí serán dibujados.
 */
public abstract class Component {
    /**
     * Nombre del componente. (No es único)
     */
    protected String name;
    /**
     * Posición en el eje X del componente en la pantalla.
     */
    protected int x;
    /**
     * Posición en el eje Y del componente en la pantalla.
     */
    protected int y;
    /**
     * Rotación en grados del componente.
     */
    protected int rotation;
    /**
     * Ancho del componente.
     */
    protected int width;
    /**
     * Alto del componente.
     */
    protected int height;
    /**
     * Booleano que indica si el componente debe ser dibujado en la pantalla.
     */
    protected boolean drawn;

    /**
     * Crea un componente con los atributos específicados y el valor <tt>drawn</tt> en verdadero por defecto.
     *
     * @param name     Nombre del componente.
     * @param x        Posición en el eje X del componente en la pantalla.
     * @param y        Posición en el eje Y del componente en la pantalla.
     * @param rotation Rotación en grados del componente.
     * @param width    Ancho del componente.
     * @param height   Alto del componente.
     */
    public Component(String name, int x, int y, int rotation, int width, int height) {
        this.name = name;
        this.x = x;
        this.y = y;
        this.rotation = rotation;
        this.width = width;
        this.height = height;
        this.drawn = true;
    }

    /**
     * Setea el valor del atributo <tt>x</tt>
     */
    public void setX(int x) {
        this.x = x;
    }

    /**
     * Setea el valor del atributo <tt>y</tt>
     */
    public void setY(int y) {
        this.y = y;
    }

    /**
     * Setea el valor del atributo <tt>rotation</tt>
     */
    public void setRotation(int rotation) {
        this.rotation = rotation;
    }

    /**
     * Setea el valor del atributo <tt>width</tt>
     */
    public void setWidth(int width) {
        this.width = width;
    }

    /**
     * Setea el valor del atributo <tt>height</tt>
     */
    public void setHeight(int height) {
        this.height = height;
    }

    /**
     * Setea el valor del atributo <tt>drawn</tt>
     */
    public void setDrawn(boolean drawn) {
        this.drawn = drawn;
    }

    /**
     * Devuelve el valor del atributo <tt>drawn</tt>
     */
    public boolean isDrawn() {
        return drawn;
    }

    /**
     * Devuelve el valor del atributo <tt>name</tt>
     */
    public String getName() {
        return name;
    }

    /**
     * Devuelve el valor del atributo <tt>x</tt>
     */
    public int getX() {
        return x;
    }

    /**
     * Devuelve el valor del atributo <tt>y</tt>
     */
    public int getY() {
        return y;
    }

    /**
     * Devuelve el valor del atributo <tt>rotation</tt>
     */
    public int getRotation() {
        return rotation;
    }

    /**
     * Devuelve el valor del atributo <tt>width</tt>
     */
    public int getWidth() {
        return width;
    }

    /**
     * Devuelve el valor del atributo <tt>height</tt>
     */
    public int getHeight() {
        return height;
    }
}
