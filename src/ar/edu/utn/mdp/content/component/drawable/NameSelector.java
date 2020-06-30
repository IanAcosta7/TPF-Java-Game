package ar.edu.utn.mdp.content.component.drawable;

import ar.edu.utn.mdp.content.component.Component;
import ar.edu.utn.mdp.utils.Input;

import java.awt.*;

public class NameSelector extends Text implements Drawable {

    private char[] letters;
    private int selectedKey;
    private int counter;

    public NameSelector(String name, int x, int y, int rotation, int width, int height) {
        super(name, x, y, rotation, width, height, "AAA");
        this.letters = texto.toCharArray();
        this.selectedKey = 0;
        this.counter = 0;
    }

    public void updateSelector() {

        // Cada diez cuadros se lee un input
        if (counter > 10) {
            if (Input.getKey(38) || Input.getKey(40) || Input.getKey(37) || Input.getKey(39)) {
                counter = 0;

                if (Input.getKey(38)) {
                    if (letters[selectedKey] < 90) // 91 Es la Z en la tabla ASCII
                    {
                        letters[selectedKey] = (char) (letters[selectedKey] + 1);
                    }
                }
                else if (Input.getKey(40)) {
                    if (letters[selectedKey] > 65) // 64 Es la A en la tabla ASCII
                    {
                        letters[selectedKey] = (char) (letters[selectedKey] - 1);
                    }
                }
                if (Input.getKey(37)) {
                    if (selectedKey > 0)
                        selectedKey--;
                }
                else if (Input.getKey(39)) {
                    if (selectedKey < 2)
                        selectedKey++;
                }
            }

            StringBuilder sb = new StringBuilder();
            sb.append(letters[0]);
            sb.append(letters[1]);
            sb.append(letters[2]);

            texto = sb.toString();
        } else {
            counter++;
        }
    }

    @Override
    public void draw(Graphics g) {
        super.draw(g);
    }
}
