package com.company;
import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Timer;

public class MyGame extends Game {
    public static final String TITLE = "Group Game";
    public static final int SCREEN_WIDTH = 500;
    public static final int SCREEN_HEIGHT = 500;
    public ArrayList<Enemy> EnemyList = new ArrayList<>();
    public BufferedImage enemyImage;
    Weapon axe;
    Player player1;
    Item hpotion = new Item(0,0,0,0,0,0);
    public MyGame() {
        makeEnemies();
        try {
            BufferedImage playerImage = ImageIO.read(new File("Player1.png"));
            enemyImage = ImageIO.read(new File("Enemy.png"));
            BufferedImage weaponImage = ImageIO.read(new File("Weapon.png"));
            player1 = new Player(50,50,50,50,50,50, playerImage);
            axe = new Weapon(20,20,50,20,20, weaponImage);
        } catch (
                IOException ex) {

        }

    }

    public void update() {

        player1.playerUpdate();

        for (int i = 0; i < EnemyList.size(); i++) {
            EnemyList.get(i).enemyUpdate();
            System.out.println(EnemyList.get(i).getHealth());
        }

        //Checks to see if player collides with an item
        for (int row = 0; row < hpotion.getWidth() + 1; row++) {
            for (int col = 0; col < hpotion.getHeight() + 1; col++) {
                if (player1.contains(hpotion.getX() + row, hpotion.getX() + col)) {
                    player1.pickUpItem(hpotion);
                }
            }
        }

        if (player1.intersection(axe)){
            player1.pickUpWeapon(axe);
        }

        for (int i = 0; i < EnemyList.size(); i++) {
            if(EnemyList.get(i).getHealth() < 1){
                EnemyList.remove(EnemyList.get(i));
            }
        }

        for (int i = 0; i < EnemyList.size(); i++) {
            if(player1.getWeaponEquipped()[0] != null) {
                if(EnemyList.get(i).intersection((player1).getWeaponEquipped()[0])){
                    EnemyList.get(i).loseHealth(player1);
                }
            }
        }

        //player1.gravity();

        for (int i = 0; i < EnemyList.size(); i++) {
            EnemyList.get(i).follow(player1);
        }
    }

    public void makeEnemies(){
        for (int i = 0; i < 1; i++) {
            EnemyList.add(new Enemy(50,50,50,200,50, enemyImage));
        }
    }

    public void draw(Graphics pen) {
        axe.draw(pen);
        player1.draw(pen);
        if(player1.isAttackCheck()){
            player1.attackDraw(pen);
        }

        for (int i = 0; i < EnemyList.size(); i++) {
            EnemyList.get(i).draw(pen);
        }

        for (int i = 0; i < EnemyList.size(); i++) {
            if (EnemyList.get(i).getHealth() < 1) {
                EnemyList.get(i).setWidth(0);
                EnemyList.get(i).setHeight(0);
            }
        }
    }


    @Override

    public void keyTyped(KeyEvent ke) {}



    @Override

    public void keyPressed(KeyEvent ke) {
        if(ke.getKeyCode() == KeyEvent.VK_W){
            player1.changeY( -15);
        }
        if(ke.getKeyCode() == KeyEvent.VK_A){
            (player1).changeX( -15);
            player1.setFacing("a");
        }
        if(ke.getKeyCode() == KeyEvent.VK_D){
            player1.changeX( 15);
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
                player1.attackLands(EnemyList);
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

