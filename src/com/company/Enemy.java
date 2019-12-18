package com.company;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

<<<<<<< HEAD
public class Enemy extends GameObjects {
    private int health;
=======
public class Enemy extends GameObjects{
    private int health;
//    private int height;
//    private int width;
//    private int x;
//    private int y;
>>>>>>> 4862c268ad32a68a9159abcdd5866f3dad813914
    private String facing = "d";
    private Weapon[] weaponEquipped = new Weapon[1];
//    private BufferedImage characterSprite;
    private boolean attackCheck;

<<<<<<< HEAD
    public Enemy(int health, int height, int width, int x, int y, BufferedImage img){
        super(height, width, x, y, img);
        this.img = img;
=======
    public Enemy(int health, int height, int width, int x, int y){
        super(x,y,width,height);
>>>>>>> 4862c268ad32a68a9159abcdd5866f3dad813914
        this.health = health;
        this.attackCheck = false;
    }

//    public void draw(Graphics pen) {
//        pen.setColor(Color.GREEN);
//        pen.fillRect(x, y, width, height);
//    }

    public void update(){

    }

    public boolean contains(int _x, int _y){
        if(_x >= this.x && _x <= this.x + this.width && _y >= this.y && _y <= this.y + this.height){
            return true;
        }
        return false;
    }

    public void loseHealth(Player player1){
        health -= player1.getWeaponEquipped()[0].getDmg();
    }


    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }
//
//    public boolean isAttackCheck() {
//        return attackCheck;
//    }
//
//    public void setAttackCheck(boolean attackCheck) {
//        this.attackCheck = attackCheck;
//    }


//    public void setWidth(int width) {
//        this.width = width;
//    }
//
//    public void setHeight(int height) {
//        this.height = height;
//    }
//
//    public int getX() {
//        return x;
//    }
//
//    public int getY() {
//        return y;
//    }
//
//    public void setX(int x) {
//        this.x = x;
//    }
//
//    public void setY(int y) {
//        this.y = y;
//    }

    public String getFacing() {
        return facing;
    }

//    public int getWidth() {
//        return width;
//    }
//
//    public int getHeight() {
//        return height;
//    }

    public void attackDraw(Graphics pen){
        if(facing.equals("a")){
            pen.fillRect(x, y+height/2, weaponEquipped[0].getWidth(), weaponEquipped[0].getHeight());
        }
        if(facing.equals("d")){
            pen.fillRect(x+width, y+height/2, weaponEquipped[0].getWidth(), weaponEquipped[0].getHeight());
        }
    }

    public void follow (Player x){
        if(this.x>x.getX()){
            this.x--;
        }
        else if(this.x<x.getX()){
            this.x++;
        }
    }


}
