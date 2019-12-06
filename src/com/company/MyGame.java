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
    Weapon axe = new Weapon(20,20,50,20,20, Color.CYAN);
    Player player1 = new Player(50,50,50,50,50,50);
    Item hpotion = new Item(0,0,0,0,0,0);
    public MyGame() {

    }

    public void update() {

        player1.playerUpdate();

        //Checks to see if player collides with an item
        for (int row = 0; row < hpotion.getWidth() + 1; row++) {
            for (int col = 0; col < hpotion.getHeight() + 1; col++) {
                if (player1.contains(hpotion.getX() + row, hpotion.getX() + col)) {
                }
            }
        }

//        for (int row = 0; row < enemy.getWidth()+1; row++) {
//            for (int col = 0; col < enemy.getHeight() + 1; col++) {
//                if (player1.contains(enemy.getX() + row, enemy.getX() + col)) {
//                }
//            }
//        }

        for (int row = 0; row < axe.getWidth()+1; row++) {
            for (int col = 0; col < axe.getHeight() + 1; col++) {
                if (player1.contains(axe.getX() + row, axe.getX() + col)) {
                    player1.pickUpWeapon(axe);
                }
            }
        }
    }

    public void draw(Graphics pen) {
        axe.draw(pen);
        player1.draw(pen);
        if(player1.isAttackCheck()){
            player1.attackDraw(pen);
        }
    }


    @Override

    public void keyTyped(KeyEvent ke) {}



    @Override

    public void keyPressed(KeyEvent ke) {
        if(ke.getKeyCode() == KeyEvent.VK_W){
            player1.jump();
        }
        if(ke.getKeyCode() == KeyEvent.VK_A){
            player1.setX(player1.getX() - 15);
            player1.setFacing("a");
        }
        if(ke.getKeyCode() == KeyEvent.VK_D){
            player1.setX(player1.getX() + 15);
            player1.setFacing("d");
        }
        if(ke.getKeyCode() == KeyEvent.VK_SPACE){
            if(player1.getItems().size() > 0) {
                for (int i = 0; i < player1.getItems().size(); i++) {
                    player1.getItems().get(i).useItem();
                }
            }
        }
        if(ke.getKeyCode() == KeyEvent.VK_ENTER){
            if(player1.getWeaponEquipped().length > 0) {
                player1.setAttackCheck(true);
                player1.setStartAttTimer(true);
            }
        }
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
