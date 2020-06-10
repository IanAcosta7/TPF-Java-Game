package ar.edu.utn.mdp.content.component.drawable;

import ar.edu.utn.mdp.content.component.Component;

public class HitBox extends Component {
    private boolean collision;
    private boolean collidable;

    public HitBox(String name, int x, int y, int rotation, int width, int height) {
        super(name, x, y, rotation, width, height);
        this.collision = false;
        this.collidable = true;
    }

    public void setCollision(boolean collision) {
        this.collision = collision;
    }

    public boolean isCollision() {
        return collision;
    }

    public static void hitboxCollision(HitBox hitBox1, HitBox hitBox2){

        if(hitBox1.collidable && hitBox2.collidable){
            if (hitBox1.x < hitBox2.x + hitBox2.width
                    && hitBox1.x + hitBox1.width > hitBox2.x
                    && hitBox1.y < hitBox2.y + hitBox2.height
                    && hitBox1.y + hitBox1.height > hitBox2.y) {
                hitBox1.collision = true;
                hitBox2.collision = true;
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
}
