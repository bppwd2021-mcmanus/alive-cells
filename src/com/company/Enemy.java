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
    private int iframes;
    private int iframesSet = 60;
    private boolean hit;
    private BufferedImage hurtImg, enemyImg;
    private int hurtTimer;



    public Enemy(int health, int height, int width, int x, int y){
        super(height, width, x, y, null);
        try {
            enemyImg = ImageIO.read(new File("Enemy.png"));
            hurtImg = ImageIO.read(new File("HitImage.png"));
        } catch (
                IOException ex) {

        }
        super.setImage(enemyImg);
        this.health = health;
        this.dmgCheck = false;
    }

    public void enemyUpdate(Player player1, boolean enterCheck){
        iframes ++;
        if(player1.isAttackLandsCheck() && enterCheck && iframes > 60){
            iframes = 0;
        }
        if(hurtTimer > 0){
            super.setImage(hurtImg);
            hurtTimer--;
        }
        else{
            super.setImage(enemyImg);
        }
    }

    public void setHurtTimer(int hurtTimer) {
        this.hurtTimer = hurtTimer;
    }

    public int getIframes() {
        return iframes;
    }

    public int getIframesSet() {
        return iframesSet;
    }

    public void setIframes(int iframes) {
        this.iframes = iframes;
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

    public double getTagtimer() {
        return tagtimer;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public void setHeight(int height) {
        this.height = height;
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
