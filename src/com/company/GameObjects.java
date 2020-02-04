package com.company;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class GameObjects {
    protected int height;
    protected int width;
    protected int x;
    protected int y;
    protected boolean grav=true;
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

    public void gravity(ArrayList<Wall> walls) {
        for (int i=0; i<walls.size(); i++) {
            if (y+height==walls.get(i).y && (x<walls.get(i).x+32 || x+width<walls.get(i).x) && walls.get(i).solid) {
                grav=false;
                break;
            } else { grav=true;}

        }
        if (grav) {
            y+=3;
        }
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