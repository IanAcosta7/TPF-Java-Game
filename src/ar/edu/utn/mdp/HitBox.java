package ar.edu.utn.mdp;

public class HitBox extends Component {
    private boolean collision;

    public HitBox(String name, int x, int y, int rotation, int width, int height) {
        super(name, x, y, rotation, width, height);
        this.collision = true;
    }

}
