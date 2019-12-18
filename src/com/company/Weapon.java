package com.company;
import java.awt.*;
import java.awt.image.BufferedImage;

public class Weapon extends GameObjects {
   private int dmg;

    public Weapon(int dmg, int width, int height, int x, int y, BufferedImage img){
       super(height, width, x, y, img);
       this.dmg = dmg;
       this.img = img;
    }

    public void draw(Graphics pen) {
        pen.fillRect(x,y,width,height);
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getDmg() {
        return dmg;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public int getY() {
        return y;
    }

    public int getX() {
        return x;
    }
}