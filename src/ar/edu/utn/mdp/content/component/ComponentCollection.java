package ar.edu.utn.mdp.content.component;

import java.util.ArrayList;
import java.util.Iterator;

public class ComponentCollection <T extends Component> {

    private ArrayList<T> components;

    public ComponentCollection() {

    }

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

    public void set(String name, T component) {
        if (indexOf(name) >= 0) {
            components.set(indexOf(name), component);
        }
    }

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

}
