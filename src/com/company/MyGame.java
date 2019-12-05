package com.company;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Timer;

public class MyGame extends Game {
    public static final String TITLE = "Group Game";
    public static final int SCREEN_WIDTH = 500;
    public static final int SCREEN_HEIGHT = 500;
    Weapon axe = new Weapon(20,20,50,20,20);
    public MyGame() {

    }

    public void update() {

    }

    public void draw(Graphics pen) {
    axe.draw(pen);

    }


    @Override

    public void keyTyped(KeyEvent ke) {}



    @Override

    public void keyPressed(KeyEvent ke) {

    }

    @Override

    public void keyReleased(KeyEvent ke) {

    }



    @Override

    public void mouseClicked(MouseEvent me) {

    }



    @Override

    public void mousePressed(MouseEvent me) {

    }

    @Override

    public void mouseReleased(MouseEvent me) {

    }



    @Override

    public void mouseEntered(MouseEvent me) {

    }



    @Override

    public void mouseExited(MouseEvent me) {

    }




    public static void main(String[] args) { new MyGame().start(TITLE, SCREEN_WIDTH,SCREEN_HEIGHT); }

}
