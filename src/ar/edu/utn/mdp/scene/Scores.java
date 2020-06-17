package ar.edu.utn.mdp.scene;

import ar.edu.utn.mdp.content.component.drawable.Text;

import java.io.File;

public class Scores extends Scene {

    public Scores() {
        super();
    }

    public Scores(boolean visible) {
        super(visible);
    }

    @Override
    public void setupScene() {
        components.set(new Text("Title", 10, 20, 0, 0, 0, "SCORES"));
    }

    @Override
    public void drawScene() {

    }
}
