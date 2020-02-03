package com.company;

import java.awt.*;
import java.awt.image.BufferedImage;

public class GameObjects {
    protected int height;
    protected int width;
    protected int x;
    protected int y;
    protected BufferedImage img;

    public GameObjects(int height, int width, int x, int y, BufferedImage img){
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
        System.out.println("update");
    }

    public void setImage(BufferedImage newImg){
        this.img = newImg;
    }

    public void draw(Graphics pen) {
        pen.drawImage(this.img, this.x, this.y, this.width, this.height, null);
    }
}