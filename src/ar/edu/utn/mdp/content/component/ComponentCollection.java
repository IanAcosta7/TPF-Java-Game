package ar.edu.utn.mdp.content.component;

import ar.edu.utn.mdp.content.component.drawable.Drawable;
import ar.edu.utn.mdp.content.component.drawable.Sprite;
import ar.edu.utn.mdp.content.component.drawable.Text;

import java.awt.*;
import java.util.ArrayList;
import java.util.Iterator;

public class ComponentCollection <T extends Component> {

    private ArrayList<T> components;

    public ComponentCollection() {
        components = new ArrayList<>();
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

    public void set(T component) {
        if (indexOf(component.getName()) >= 0) {
            components.set(indexOf(component.getName()), component);
        } else {
            components.add(component);
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

    public void drawAll(Graphics g) {
        Iterator iterator = components.iterator();

        while (iterator.hasNext()) {
            ar.edu.utn.mdp.content.component.Component component = (Component) iterator.next();

            if (component instanceof Drawable && component.isDrawn())
                ((Drawable) component).draw(g);
        }

        // Ver hitbox del player
        //g.drawRect(((Player)components.get(components.size() - 1)).getHitBox().getX(), ((Player)components.get(components.size() - 1)).getHitBox().getY(), ((Player)components.get(components.size() - 1)).getHitBox().getWidth(), ((Player)components.get(components.size() - 1)).getHitBox().getHeight());

    }

}
