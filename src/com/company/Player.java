package com.company;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class Player {
    private int health;
    private int height;
    private int width;
    private int lives;
    private int x;
    private int y;
    private String facing = "d";
    private ArrayList<Item> items = new ArrayList<>();
    private Weapon[] weaponEquipped = new Weapon[1];
    private BufferedImage characterSprite;
    private boolean attackCheck;

    public Player(int health, int lives, int height, int width, int x, int y){
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.health = health;
        this.lives = lives;
    }

    public void draw(Graphics pen) {
        pen.setColor(Color.BLACK);
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

    public void pickUpWeapon(Weapon weapon){
        weaponEquipped[0] = weapon;
    }

    public void pickUpItem(Item item){
        items.add(new Item(item.getX(), item.getY(), item.getWidth(), item.getHeight(), item.getUse(), item.getVal()));
    }

    public void jump(){
        y+=10;
        y-=10;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public boolean isAttackCheck() {
        return attackCheck;
    }

    public void keyPressed(KeyEvent ke) {
        if(ke.getKeyCode() == KeyEvent.VK_W){
            jump();
        }
        if(ke.getKeyCode() == KeyEvent.VK_A){
            this.x += 10;
            facing.equals("a");                //FIX THIS. PUT IN MY GAME AND CHANGE VARIABLES
            attackCheck = true;
        }
        if(ke.getKeyCode() == KeyEvent.VK_D){
            this.y+=10;
            facing.equals("d");
            attackCheck = true;
        }
        if(ke.getKeyCode() == KeyEvent.VK_SPACE){
            for (int i = 0; i < items.size(); i++) {
                items.get(i).useItem();
            }
        }
        if(ke.getKeyCode() == KeyEvent.VK_ENTER){

        }
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

