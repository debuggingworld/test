package com.zth;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;

public class Watermark {
    public static void main(String[] args) throws Exception {
        BufferedImage bg = ImageIO.read(new FileInputStream("E:\\Java 新卓越\\liu\\作业\\cat.png"));
        int x = bg.getWidth();
        int y = bg.getHeight();

        BufferedImage img = new BufferedImage(x,y,BufferedImage.TYPE_3BYTE_BGR);
        Graphics g = img.getGraphics();

        g.drawImage(bg,0,0,x,y,null);
        g.setColor(new Color(128, 0, 0));
        g.setFont(new Font("微软雅黑",Font.PLAIN,20));
        g.drawString("@时光·漫步",x-150,y-20);

        ImageIO.write(img,"png",new File("E:\\Java 新卓越\\liu\\作业\\Watermark.png"));
        System.out.println("ok!");
    }

}
