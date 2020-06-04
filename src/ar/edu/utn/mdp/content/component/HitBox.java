package ar.edu.utn.mdp.content.component;

public class HitBox extends Component {
    private boolean collision;

    public HitBox(String name, int x, int y, int rotation, int width, int height) {
        super(name, x, y, rotation, width, height);
        this.collision = false;
    }

    public void setCollision(boolean collision) {
        this.collision = collision;
    }

    public boolean isCollision() {
        return collision;
    }

    public static void hitboxCollision(HitBox hitBox1, HitBox hitBox2){
        if(hitBox1.x < hitBox2.x + hitBox2.width
                && hitBox1.x + hitBox1.width > hitBox2.x
                && hitBox1.y < hitBox2.y + hitBox2.height
                && hitBox1.y + hitBox1.height > hitBox2.y){
            hitBox1.collision = true;
            hitBox2.collision = true;
        }
    }
}
