package ar.edu.utn.mdp.content.component;

import ar.edu.utn.mdp.content.component.drawable.Drawable;

import java.awt.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.stream.Collectors;

public class ComponentCollection <T extends Component> {

    private ArrayList<T> components;

    public ComponentCollection() {
        components = new ArrayList<>();
    }

    /**
     *
     * @param name Se pasa un nombre por parametro
     * @return Retorna un nombre si lo encuentra, sino NULL
     */
    public Component get(String name) {
        Iterator<T> iterator = components.iterator();
        Component found = null;

        while (iterator.hasNext()) {
            Component next = iterator.next();

            if (next.getName().equals(name)) {
                found = next;
            }
        }

        return found;
    }

    public Component get(int i) {
        Component found;

        try {
            found = components.get(i);
        } catch (IndexOutOfBoundsException e) {
            found = null;
        }

        return found;
    }

    /**
     * Recibe un componente y compara el nombre, si existe, es reemplazado por el mismo.
     * @param component
     */
    public void set(T component) {
        if (indexOf(component.getName()) >= 0) {
            components.set(indexOf(component.getName()), component);
        } else {
            components.add(component);
        }
    }

    /**
     *
     * @param name Se le pasa un nombre
     * @return Y retorna la posicion en la coleccion.
     */
    public int indexOf(String name) {
        Iterator<T> iterator = components.iterator();
        int val = -1;
        int i = 0;

        while (iterator.hasNext()) {
            Component next = iterator.next();

            if (next.getName().equals(name)) {
                val = i;
            }
            i++;
        }

        return val;
    }

    /**
     *
     * @param g
     */
    public void drawAll(Graphics g) {
        Iterator iterator = components.iterator();

        while (iterator.hasNext()) {
            Component component = (Component) iterator.next();

            if (component instanceof Drawable && component.isDrawn())
                ((Drawable) component).draw(g);
        }
    }

    /**
     *
     * @return Retorna los validos de la coleccion.
     */
    public int size(){
        return components.size();
    }


    public void remove(String name) {
        components = new ArrayList(components
                .stream()
                .filter(component -> !component.getName().equals(name))
                .collect(Collectors.toList()));
    }

}
