package com.company;

import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.awt.Graphics;

public class Wall {
    public int x;
    public int y;
    int width=32;
    int height=32;
    public boolean solid=true;
    BufferedImage tileimg;

    public Wall(int valx, int valy, String valtile) {
        x=valx;
        y=valy;
        File file = null;

        if (valtile.equals("T")) {
            file = new File("tiles/top.png");
        } else if (valtile.equals("B")) {
            file = new File("tiles/bottom.png");
        } else if (valtile.equals("L")) {
            file = new File("tiles/left.png");
        } else if (valtile.equals("M")) {
            file= new File("tiles/mid.png");
        } else if (valtile.equals("0")) {
            file= new File("tiles/background.png");
            solid = false;
        }

        try {
            tileimg = ImageIO.read(file);
        } catch (IOException e) {
        }
    }

    public void draw(Graphics g) {
        g.drawImage(tileimg, x, y,null);
    }


}
