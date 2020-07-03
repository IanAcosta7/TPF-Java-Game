package ar.edu.utn.mdp.utils;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Input implements KeyListener {

    private static boolean[] keys= new boolean[1024];

    public Input() {
    }

    public static boolean getKey(int keyCode)
    {
        return keys[keyCode];
    }


    @Override
    public void keyPressed(KeyEvent e)
    {
        keys[e.getKeyCode()] = true;
    }

    @Override
    public void keyReleased(KeyEvent e)
    {
        keys[e.getKeyCode()] = false;
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }
}
