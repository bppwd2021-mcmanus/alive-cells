package com.company;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class Enemy extends GameObjects {
    private int health;
    private String facing = "d";
    private Weapon[] weaponEquipped = new Weapon[1];
    private boolean dmgCheck;
    private boolean startDmgTimer;
    private double tagtimer;



    public Enemy(int health, int height, int width, int x, int y, BufferedImage img){
        super(height, width, x, y, img);
        this.img = img;
        this.health = health;
        this.dmgCheck = false;
    }

    public void draw(Graphics pen) {
        pen.setColor(Color.GREEN);
        pen.fillRect(x, y, width, height);
    }

    public void enemyUpdate(){
        if(startDmgTimer){
            tagtimer = System.currentTimeMillis();
            startDmgTimer = false;
        }
        if(dmgCheck && System.currentTimeMillis() - tagtimer > 1000){
            dmgCheck = false;
        }
    }

    public boolean contains(int _x, int _y){
        if(_x >= this.x && _x <= this.x + this.width && _y >= this.y && _y <= this.y + this.height){
            return true;
        }
        return false;
    }

    public void loseHealth(Player player1){
        health -= player1.getWeaponEquipped()[0].getDmg();
    }

    public int getHealth() {
        return health;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public void setDmgCheck(boolean dmgCheck) {
        this.dmgCheck = dmgCheck;
    }

    public void setStartDmgTimer(boolean startDmgTimer) {
        this.startDmgTimer = startDmgTimer;
    }

    public boolean isDmgCheck() {
        return dmgCheck;
    }

    public void follow (Player x){
        if(this.x>x.getX()){
            this.x--;
        }
        else if(this.x<x.getX()){
            this.x++;
        }
    }


}
