package ar.edu.utn.mdp.content.component.drawable;

import ar.edu.utn.mdp.content.component.Component;

import java.awt.*;

public class Text extends Component implements Drawable
{
    private String texto;


    public Text(String name, int x, int y, int rotation, int width, int height, String texto)
    {
        super(name, x, y, rotation, width, height);
        this.texto = texto;

    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto)
    {
        this.texto = texto;
    }

    @Override
    public void draw(Graphics g) {
        g.drawString(texto, x, y);
    }
}
