package ar.edu.utn.mdp.content;

import ar.edu.utn.mdp.utils.Loader;

import java.awt.image.BufferedImage;

public class Street {
    private int start;
    private int end;
    private boolean hasLine;
    private int lineEach;
    private int lineLength;
    private int counter;

    public Street(int start, int end, int lineEach, int lineLength) {
        this.start = start;
        this.end = end;
        this.hasLine = false;
        this.lineEach = lineEach;
        this.lineLength = lineLength;
        this.counter = 0;
    }

    public void count() {
        if (counter > lineEach + lineLength)
            counter = 0;

        hasLine = counter >= lineEach && counter < lineEach + lineLength;

        counter++;
    }

    public BufferedImage getStreetImage(int pos) {
        BufferedImage street = Loader.getSprites().get("Calle/asfaltoLiso");

        // BORDERS
        if (pos == start)
            street = Loader.getSprites().get("Calle/asfaltoLadoIzq");
        if (pos == end - 1)
            street = Loader.getSprites().get("Calle/asfaltoLadoDer");

        //LINES
        int streetLength = end - start;
        if ((pos == (int)(start + streetLength / 3) || pos == (int)((end - 1) - streetLength / 3)) && hasLine)
            street = Loader.getSprites().get("Calle/asfaltoConLinea");

        return street;
    }

    public int getStart() {
        return start;
    }

    public int getEnd() {
        return end;
    }
}
