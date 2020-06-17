package ar.edu.utn.mdp.scene;

import ar.edu.utn.mdp.content.component.drawable.Text;
import ar.edu.utn.mdp.content.persistent.Score;
import ar.edu.utn.mdp.utils.Persistency;

import java.util.HashSet;
import java.util.Iterator;

public class Scoreboard extends Scene {

    private HashSet<Score> scores;

    public Scoreboard() {
        super();
        this.scores = new HashSet<>();
    }

    public Scoreboard(boolean visible) {
        super(visible);
        this.scores = new HashSet<>();
    }

    @Override
    public void setupScene() {
        Persistency<Score> p = new Persistency<>("data/scores.bin");

        scores = p.getData();

        components.set(new Text("Title", 10, 20, 0, 0, 0, "SCORES"));
    }

    @Override
    public void drawScene() {
        showScores();
    }

    private void showScores() {
        Iterator<Score> iterator = scores.iterator();
        int i = 0;

        while (iterator.hasNext()) {
            Score score = iterator.next();

            components.set(new Text("Score" + i, 10, 20 * i + 40, 0, 0, 0, score.getName() + " " + score.getScore()));

            i++;
        }
    }
}
