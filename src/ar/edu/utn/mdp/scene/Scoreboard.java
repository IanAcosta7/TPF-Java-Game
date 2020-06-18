package ar.edu.utn.mdp.scene;

import ar.edu.utn.mdp.content.component.drawable.NameSelector;
import ar.edu.utn.mdp.content.component.drawable.PETC;
import ar.edu.utn.mdp.content.component.drawable.Player;
import ar.edu.utn.mdp.content.component.drawable.Text;
import ar.edu.utn.mdp.content.persistent.Score;
import ar.edu.utn.mdp.utils.Input;
import ar.edu.utn.mdp.utils.Persistency;

import java.util.HashSet;
import java.util.Iterator;

public class Scoreboard extends Scene {

    private HashSet<Score> scores;
    private Persistency<Score> p;

    public Scoreboard() {
        super();
        this.scores = new HashSet<>();
        this.p = new Persistency<>("scores.bin");
    }

    public Scoreboard(boolean active) {
        super(active);
        this.scores = new HashSet<>();
        this.p = new Persistency<>("scores.bin");
    }

    @Override
    public void setupScene() {
        scores = p.getData();

        components.set(new Text("Title", 10, 20, 0, 0, 0, "SCORES"));
        components.set(new NameSelector("NameSelector", 10, 100, 0, 0, 0));
    }

    @Override
    public void drawScene() {
        NameSelector nameSelector = (NameSelector)components.get("NameSelector");
        PETC petc = (PETC)components.get("Advice");

        if (petc == null) {
            if (nameSelector != null) {
                selectName(nameSelector); // Componente de seleccion de nombre
            } else {
                petc = new PETC("Advice", 10, 200, 0, 0, 0);
                petc.setDrawn(false);

                components.set(petc);
            }
        } else {
            if (petc.update())
                setActive(false);
        }

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

    private void selectName(NameSelector nameSelector) {
        nameSelector.updateSelector();

        // Si se presiona ENTER
        if (Input.getKey(10)) {
            Score newScore = new Score(nameSelector.getTexto(), (int)Player.score);

            scores.add(newScore);
            components.remove("NameSelector");

            p.setData(scores);
        }
    }
}
