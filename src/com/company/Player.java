package com.company;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class Player extends GameObjects {
    private int health;
    private int lives;

    private String facing = "d";

//    private String facing = "";

    private ArrayList<Item> items = new ArrayList<>();
    private Weapon[] weaponEquipped = new Weapon[1];
    private boolean attackCheck;
    private double tagtimer;
    private boolean startAttTimer;

    public Player(int health, int lives, int height, int width, int x, int y, BufferedImage img){
        super(height, width, x, y, img);
        this.health = health;
        this.lives = lives;
        this.attackCheck = false;
    }


    public void playerUpdate(){
        if(startAttTimer){
            tagtimer = System.currentTimeMillis();
            startAttTimer = false;
        }
        if(attackCheck && System.currentTimeMillis() - tagtimer > 500){
            attackCheck = false;
        }

    }

    public void setStartAttTimer(boolean startAttTimer) {
        this.startAttTimer = startAttTimer;
    }

    public boolean contains(int _x, int _y){
        if(_x >= this.x && _x <= this.x + this.width && _y >= this.y && _y <= this.y + this.height){
            return true;
        }
        return false;
    }

    public void setFacing(String facing) {
        this.facing = facing;
    }

    public void loseHealth(){
        health -= 1;
    }

    public void pickUpWeapon(Weapon weapon){
        Weapon blankWeapon = new Weapon(weapon.getDmg(),weapon.getWidth(),weapon.getHeight(),weapon.getX(),weapon.getY(), weapon.img);
        weaponEquipped[0] = blankWeapon;
        weapon.setWidth(0);
        weapon.setHeight(0);
    }

    public void pickUpItem(Item item){
        items.add(new Item(item.getX(), item.getY(), item.getWidth(), item.getHeight(), item.getUse(), item.getVal()));
    }

    public Weapon[] getWeaponEquipped() {
        return weaponEquipped;
    }

    public void jump(){
        y-=10;
    }

    public void gravity() {
        while(y!=50){
            y-=2;
        }
    }
    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public boolean isAttackCheck() {
        return attackCheck;
    }

    public void setAttackCheck(boolean attackCheck) {
        this.attackCheck = attackCheck;
    }

    public ArrayList<Item> getItems() {
        return items;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int x) {
        super.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void changeX(int number){
        super.x += number;
    }

    public void changeY(int number){
        super.y += number;
    }

    public String getFacing() {
        return facing;
    }

    public void attackLands(ArrayList<Enemy> EnemyList) {
        for (int i = 0; i < EnemyList.size(); i++) {
            if(weaponEquipped[0].contains(EnemyList.get(i).getX(), EnemyList.get(i).getY()) && weaponEquipped.length > 0){
                EnemyList.get(i).setHealth(0);
            }
        }
    }

    public void attackDraw(Graphics pen){
        if(facing.equals("a") && weaponEquipped[0] != null && attackCheck == true){
            pen.drawImage(weaponEquipped[0].img, x-weaponEquipped[0].getWidth()*2, y+weaponEquipped[0].getHeight()/2, weaponEquipped[0].getHeight(), weaponEquipped[0].getWidth(), null);

        }
        if(facing.equals("d")  && weaponEquipped[0] != null && attackCheck == true){
            pen.drawImage(weaponEquipped[0].img, x+weaponEquipped[0].getWidth()*2, y+weaponEquipped[0].getHeight()/2, weaponEquipped[0].getHeight(), weaponEquipped[0].getWidth(), null);
        }
    }
}

