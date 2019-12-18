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
    //GameObjects enemy = new Enemy(50,50,50,200,50);
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

        ((Player)player1).playerUpdate();

        //Checks to see if player collides with an item
        for (int row = 0; row < hpotion.getWidth() + 1; row++) {
            for (int col = 0; col < hpotion.getHeight() + 1; col++) {
                if (player1.contains(hpotion.getX() + row, hpotion.getX() + col)) {
                    ((Player)player1).pickUpItem(hpotion);
                }
            }
        }
        for (int row = 0; row < enemy.getWidth()+1; row++) {
            for (int col = 0; col < enemy.getHeight() + 1; col++) {
                if (player1.contains(enemy.getX() + row, enemy.getX() + col)) {
               }
            }
        }

        if (player1.intersection(axe)){
            player1.pickUpWeapon(axe);
        }
//        for (int row = 0; row < ((Weapon)axe).getWidth() + 1; row++) {
//            for (int col = 0; col < axe.getHeight() + 1; col++) {
//                if (player1.contains(axe.getX() + row, axe.getX() + col)) {
//                    ((Player)player1).pickUpWeapon(axe);
//                }
//            }
//        }

        for (int i = 0; i < EnemyList.size(); i++) {
            if(EnemyList.get(i).getHealth() < 1){
                EnemyList.remove(EnemyList.get(i));
            }
        }
<<<<<<< HEAD

        for (int i = 0; i < EnemyList.size(); i++) {
//            if(EnemyList.get(i).intersection(((Player)player1).getWeaponEquipped()[0]));
//                EnemyList.get(i).loseHealth((Player) player1);
        }
=======
>>>>>>> 4862c268ad32a68a9159abcdd5866f3dad813914
//        for (int i = 0; i < EnemyList.size(); i++) {
//            for (int row = 0; row < EnemyList.get(i).getWidth() + 1; row++) {
//                for (int col = 0; col < EnemyList.get(i).getHeight() + 1; col++) {
//                    if(player1.getWeaponEquipped().length > 0 && player1.isAttackCheck()) {
//                        if (EnemyList.get(i).contains(player1.getWeaponEquipped()[0].getX() + row, player1.getWeaponEquipped()[0].getX() + col)) {
//                            EnemyList.get(i).loseHealth(player1);
//                        }
//                    }
//                }
//            }
//        }

        for (int i = 0; i < EnemyList.size(); i++) {
            System.out.println(EnemyList.get(i).getHealth());
        }

<<<<<<< HEAD
        ((Player)player1).gravity();

=======
>>>>>>> 4862c268ad32a68a9159abcdd5866f3dad813914
//        for (int i = 0; i < EnemyList.size(); i++) {
//            EnemyList.get(i).follow(player1);
//        }
        enemy.follow(player1);
        player1.gravity();
    }

    public void makeEnemies(){
        for (int i = 0; i < 1; i++) {
            EnemyList.add(new Enemy(50,50,50,200,50, enemyImage));
        }

    }

    public void draw(Graphics pen) {
        axe.draw(pen);
        player1.draw(pen);
        if(((Player)player1).isAttackCheck()){
            ((Player)player1).attackDraw(pen);
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
            ((Player)player1).changeY( -15);
        }
        if(ke.getKeyCode() == KeyEvent.VK_A){
            ((Player)player1).changeX( -15);
            ((Player)player1).setFacing("a");
        }
        if(ke.getKeyCode() == KeyEvent.VK_D){
            ((Player)player1).changeX( 15);
            ((Player)player1).setFacing("d");
        }
        if(ke.getKeyCode() == KeyEvent.VK_SPACE){
            if(((Player)player1).getItems().size() > 0) {
                for (int i = 0; i < ((Player)player1).getItems().size(); i++) {
                    ((Player)player1).getItems().get(i).useItem();
                }
            }
        }
        if(ke.getKeyCode() == KeyEvent.VK_ENTER){
            if(((Player)player1).getWeaponEquipped().length > 0) {
                ((Player)player1).setAttackCheck(true);
                ((Player)player1).setStartAttTimer(true);
                ((Player)player1).attackLands(EnemyList);
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
