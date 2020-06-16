package ar.edu.utn.mdp.content.component.drawable;

import ar.edu.utn.mdp.content.component.Component;

public class HitBox extends Component {
    private Sprite tag;
    private boolean collision;
    private boolean collidable;

    public HitBox(String name, int x, int y, int rotation, int width, int height) {
        super(name, x, y, rotation, width, height);
        this.collision = false;
        this.collidable = true;
    }

    /**
     *
     * @param collision Setea Collision con un boolean
     */
    public void setCollision(boolean collision) {

        this.collision = collision;
        if(!collision)
            tag=null;
    }

    /**
     * Determina si se esta colisionando
     * @return Retorna un boolean
     */
    public boolean isCollision() {
        return collision;
    }

    /**
     * El metodo compara dos HitBox y Establece true si hay colision.
     * @param hitBox1 Parametro de HitBox a comparar
     * @param hitBox2 Parametro de HitBox a comparar
     */
    public static void hitboxCollision(Sprite sprite1, Sprite sprite2){
        HitBox hitBox1 = sprite1.hitBox;
        HitBox hitBox2 = sprite2.hitBox;
        if(hitBox1.collidable && hitBox2.collidable){
            if (hitBox1.x < hitBox2.x + hitBox2.width
                    && hitBox1.x + hitBox1.width > hitBox2.x
                    && hitBox1.y < hitBox2.y + hitBox2.height
                    && hitBox1.y + hitBox1.height > hitBox2.y) {
                hitBox1.collision = true;
                hitBox2.collision = true;
                hitBox1.tag = sprite2;
                hitBox2.tag = sprite1;
            }
        }
    }

    public boolean isCollidable()
    {
        return collidable;
    }

    public void setCollidable(boolean collidable)
    {
        this.collidable = collidable;
    }

    public Sprite getTag() {
        return tag;
    }
}
