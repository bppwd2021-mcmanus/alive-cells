package com.company;

import java.awt.*;
import java.awt.image.BufferedImage;

public class GameObjects {
    protected int height;
    protected int width;
    protected int x;
    protected int y;
<<<<<<< HEAD
    protected BufferedImage img;

    public GameObjects(int height, int width, int x, int y, BufferedImage img){
=======

    public GameObjects(int width, int height, int x, int y){
>>>>>>> 4862c268ad32a68a9159abcdd5866f3dad813914
        this.height = height;
        this.width = width;
        this.x = x;
        this.y = y;
        this.img = img;
    }

    public boolean contains(int x, int y){
        if(x >= this.x && x <= this.x + this.width && y >= this.y && y <= this.y + this.height){
            return true;
        }
        return false;
    }

    public boolean intersection(GameObjects other){
        boolean intersect = false;
        System.out.println(other.x + other.y + other.width + other.height);
        for (int row = 0; row < other.width+1; row++) {
            for (int col = 0; col < other.height+1; col++) {
                if(this.contains(other.x+row, other.y+col)){
                    intersect = true;
                }
            }
        }
        return (intersect);
    }

    public void update(){

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

    public void setY(int y) {
        this.y = y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public void draw(Graphics pen) {
        pen.drawImage(this.img, this.x, this.y, this.width, this.height, null);
    }
}
