package ar.edu.utn.mdp;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Input implements KeyListener, MouseListener {
    private boolean[] keys= new boolean[256];

    public static boolean RIGHT, LEFT;

    public Input() {
        RIGHT = false;
        LEFT = false;
    }

    public void update(){
        RIGHT = keys[KeyEvent.VK_RIGHT];
        LEFT = keys[KeyEvent.VK_LEFT];
    }

    public boolean getKey(int keyCode) {
        return keys[keyCode];
    }


    @Override
    public void keyPressed(KeyEvent e) {
        keys[e.getKeyCode()] = true;
    }

    @Override
    public void keyReleased(KeyEvent e) {
        keys[e.getKeyCode()] = false;

    }

    @Override
    public void keyTyped(KeyEvent e) {

    }


    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

}
