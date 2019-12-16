package com.company;

import java.awt.*;

public class GameObjects {
    private int height;
    private int width;
    private int x;
    private int y;

    public GameObjects(int height, int width, int x, int y){
        this.height = height;
        this.width = height;
        this.x = x;
        this.y = y;
    }

    public boolean contains(int x, int y){
        if(x >= this.x && x <= this.x + this.width && y >= this.y && y <= this.y + this.height){
            return true;
        }
        return false;
    }

    public boolean intersection(GameObjects other){
        int tlcX = 0;
        int tlcY = 0;
        int brcX = width+x;
        int brcY = height+y;
        boolean intersect = false;
        for (int row = 0; row < other.width+1; row++) {
            for (int col = 0; col < other.height+1; col++) {
                if(this.contains(other.x+row, other.y+col)){
                    intersect = true;
                    if(other.x + row > tlcX) {
                        tlcX = other.x + row;
                    }
                    if(other.y + col > tlcY){
                        tlcY = other.y + col;
                    }
                    if(other.x + row < brcX){
                        brcX = other.x + row;
                    }
                    if(other.y + col < brcY){
                        brcY = other.y + col;
                    }
                }
            }
        }
        return (intersect);
    }

    public void update(){

    }

    public void draw(Graphics pen){

    }
}
