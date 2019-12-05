package com.company;
import java.awt.*;

public class Weapon {
   private int dmg;
   private int width;
   private int height;
   private int x;
   private int y;
   public Weapon(){
       dmg = 0;
       width = 0;
       height = 0;
       x = 0;
       y = 0;
   }
    public Weapon(int dmg, int width, int height, int x, int y){
       this.dmg = dmg;
       this.width = width;
       this.height = height;
       this.x = x;
       this.y = y;
    }
    public void draw(Graphics pen) {
        pen.setColor(Color.BLACK);
        pen.drawRect(x,y,width,height);
    }
}
