package ar.edu.utn.mdp.content.component;

import ar.edu.utn.mdp.content.component.drawable.Drawable;

import java.awt.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.stream.Collectors;

/**
 * Arreglo de componentes personalizado para trabajar como un <b>HashMap</b> y un <b>ArrayList</b> a la vez.
 * @param <T> Un tipo de dato que extienda de la clase <b>Component</b>.
 */
public class ComponentCollection <T extends Component> {

    /**
     * La lista de Componentes.
     */
    private ArrayList<T> components;

    /**
     * Incializa al lista de componentes.
     */
    public ComponentCollection() {
        components = new ArrayList<>();
    }

    /**
     * Retorna el primer componente cuyo atributo <b>name</b> sea igual al recibido por parametro.
     *
     * @param name nombre del elemento a retornar.
     * @return el componente con ese nombre.
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

    /**
     * Retorna el componente que se encuentre en la posición i.
     *
     * @param i posicion del arreglo a retornar.
     * @return el componente que se encuentra en la posición i.
     */
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
     * Guarda el componente en el arreglo. Si en el arreglo ya existe un componente con ese nombre, es reemplazado por el recibido por parámetro.
     *
     * @param component componente a guardar en el arreglo.
     */
    public synchronized void set(T component) {
        if (indexOf(component.getName()) >= 0) {
            components.set(indexOf(component.getName()), component);
        } else {
            components.add(component);
        }
    }

    /**
     * Retorna el índice del primer elemento encontrado con el nombre <b>name</b>.
     *
     * @param name nombre a buscar en el arreglo.
     * @return el índice del componente en la colección, o -1 si el componente no se encuentra en ella.
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
     * Recorre toda la colección y dibuja todos sus componentes haciendo uso de la instancia de <b>Graphics</b> recibida.
     *
     * @param g un objeto de tipo <b>Graphics</b> que será utilizado para dibujar los componentes.
     */
    public synchronized void drawAll(Graphics g) {
        Iterator iterator = components.iterator();

        while (iterator.hasNext()) {
            Component component = (Component) iterator.next();

            if (component instanceof Drawable && component.isDrawn())
                ((Drawable) component).draw(g);
        }
    }

    /**
     * Retorna el número de componentes en la colección
     *
     * @return el número de componentes en la colección.
     */
    public int size(){
        return components.size();
    }

    public void clear() {
        Iterator iterator = components.iterator();

        while (iterator.hasNext()) {
            Component component = (Component) iterator.next();

            remove(component.getName());
        }
    }

    /**
     * Remueve todos los componentes cuyo atributo <b>name</b> sea igual al recibido por parámetro.
     *
     * @param name el nombre a remover.
     */
    public void remove(String name) {
        components = new ArrayList(components
                .stream()
                .filter(component -> !component.getName().equals(name))
                .collect(Collectors.toList()));
    }

}
