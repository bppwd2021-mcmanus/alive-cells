package com.company;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class Player {
    int health;
    int height;
    int width;
    int lives;
    int x;
    int y;
    ArrayList<String> items = new ArrayList<>();
    Weapon axe;
    BufferedImage characterSprite;

    public Player(int health, int lives, int height, int width, int x, int y){
        this.x = x;
        this.y = y;
        this.health = health;
        this.lives = lives;
    }

    public void draw(Graphics pen) {
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

    public void loseHealth(Enemy enemy){
        for (int row = 0; row < enemy.getWidth()+1; row++) {
            for (int col = 0; col < enemy.getHeight() + 1; col++) {
                if (this.contains(enemy.getX() + row, enemy.getX() + col)) {
                    health -= 1;
                }
            }
        }
    }

    public void pickUpItem(ArrayList<String> items, Item item){
        for (int row = 0; row < item.getWidth()+1; row++) {
            for (int col = 0; col < item.getHeight() + 1; col++) {
                if (this.contains(item.getX() + row, item.getX() + col)) {
                    items.add(new Item(item));
                }
            }
        }
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public void keyPressed(KeyEvent ke) {
        if(ke.getKeyCode() == KeyEvent.VK_W){

        }
        if(ke.getKeyCode() == KeyEvent.VK_S){

        }
        if(ke.getKeyCode() == KeyEvent.VK_A){

        }
        if(ke.getKeyCode() == KeyEvent.VK_D){

        }
    }

    public useItem(){

    }

    public attack(){

    }
}

