package com.company;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class Enemy {
    private int health;
    private int height;
    private int width;
    private int x;
    private int y;
    private String facing = "d";
    private Weapon[] weaponEquipped = new Weapon[1];
//    private BufferedImage characterSprite;
    private boolean attackCheck;

    public Enemy(int health, int height, int width, int x, int y){
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.health = health;
        this.attackCheck = false;
    }

    public void draw(Graphics pen) {
        pen.setColor(Color.GREEN);
        pen.fillRect(x, y, width, height);
    }

    public void update(){

    }

    public boolean contains(int _x, int _y){
        if(_x >= this.x && _x <= this.x + this.width && _y >= this.y && _y <= this.y + this.height){
            return true;
        }
        return false;
    }

    public void loseHealth(){
        health -= 1;
    }

    public void jump(){
        y-=10;
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

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public String getFacing() {
        return facing;
    }
    public void attackDraw(Graphics pen){
        if(facing.equals("a")){
            pen.fillRect(x, y+height/2, weaponEquipped[0].getWidth(), weaponEquipped[0].getHeight());
        }
        if(facing.equals("d")){
            pen.fillRect(x+width, y+height/2, weaponEquipped[0].getWidth(), weaponEquipped[0].getHeight());
        }
    }
}
