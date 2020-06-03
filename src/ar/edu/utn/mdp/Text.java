package ar.edu.utn.mdp;

public class Text extends Component
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

}
