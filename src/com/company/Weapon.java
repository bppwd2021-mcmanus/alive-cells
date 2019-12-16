package com.company;
import java.awt.*;

public class Weapon extends GameObjects{
   private int dmg;
//   private int width;
//   private int height;
//   private int x;
//   private int y;
   private Color color;

   public Weapon(int dmg, int width, int height, int x, int y, Color color){
       super(width,height,x,y);
       this.dmg = dmg;
//       this.width = width;
//       this.height = height;
//       this.x = x;
//       this.y = y;
       this.color = color;
    }
    public void draw(Graphics pen) {

       pen.fillRect(x,y,width,height);
    }

//    public void setHeight(int height) {
//        this.height = height;
//    }
//
//    public void setWidth(int width) {
//        this.width = width;
//    }

    public int getDmg() {
        return dmg;
    }

//    public void setY(int y) {
//        this.y = y;
//    }
//
//    public void setX(int x) {
//        this.x = x;
//    }

    public Color getColor() {
        return color;
    }

    public boolean contains(int _x, int _y){
        if(_x >= this.x && _x <= this.x + this.width && _y >= this.y && _y <= this.y + this.height){
            return true;
        }
        return false;
    }

//    public int getWidth() {
//        return width;
//    }
//
//    public int getHeight() {
//        return height;
//    }
//
//    public int getY() {
//        return y;
//    }
//
//    public int getX() {
//        return x;
//    }
}