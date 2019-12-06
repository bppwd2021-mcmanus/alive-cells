package com.company;
import java.awt.*;
public class Item {
    private int x;
    private int y;
    private int width;
    private int height;
    private int use;
    private int val;
    public Item(){
        x=0;
        y=0;
        width=0;
        height=0;
        use=0;
        val=0;
    }
    public Item(int x, int y, int w, int h, int u, int v){
        this.x=x;
        this.y=y;
        this.width=w;
        this.height=h;
        this.use=u;
        this.val=v;
    }
    public void useItem(){
        use --;
    }
    public void update(){
        if(use<1){
            x=0;
            y=0;
            width=0;
            height=0;
        }
    }

}

