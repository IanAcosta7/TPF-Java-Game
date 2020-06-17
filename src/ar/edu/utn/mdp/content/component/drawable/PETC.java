package ar.edu.utn.mdp.content.component.drawable;

import ar.edu.utn.mdp.utils.Input;

public class PETC extends Text {

    private int counter;
    private boolean flag;

    public PETC(String name, int x, int y, int rotation, int width, int height) {
        super(name, x, y, rotation, width, height, "PRESS ENTER TO CONTINUE");
        this.counter = 0;
        this.flag = false;
    }

    public boolean update() {
        boolean enterPressed = false;

        if (counter > 60) {
            flag = true;
            setDrawn(!isDrawn());
            counter = 0;
        }

        if (flag) {
            if (Input.getKey(10)) {
                enterPressed = true;
            }
        }

        counter++;

        return enterPressed;
    }
}
