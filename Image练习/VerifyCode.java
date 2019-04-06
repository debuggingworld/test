package com.zth;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.util.Random;

public class  VerifyCode{
    public static void main(String[] args) throws Exception {
        BufferedImage img = new BufferedImage(600,400,BufferedImage.TYPE_3BYTE_BGR);
        Graphics g = img.getGraphics();

        g.setColor(Color.gray);
        g.fillRect(0,0,600,400);

        // 防止图片丢失
        Image bg = ImageIO.read(new FileInputStream("E:\\Java 新卓越\\liu\\作业\\cat.png"));
        g.drawImage(bg,0,0,null);

        g.setColor(Color.black);
        g.setFont(new Font("微软雅黑",Font.BOLD,20));
        g.drawString("验证码:",290,340);
        // 验证码框
        g.setColor(new Color(153, 255, 204));
        g.fillRect(360,310,120,40);

        // 生成验证码（四位随机数 +两位字母）
        Random r = new Random();
        StringBuilder str = new StringBuilder();
        for(int i = 0;i<4;i++){
            str.append(r.nextInt(10));
        }
        for(int i = 0;i<2;i++){
            str.append((char)(r.nextInt(27)+97));
        }
        String str1 = str.toString();

        g.setColor(Color.red);
        //g.drawBytes(ran,0,4,365,330);
        g.drawString(str1,370,335);

        ImageIO.write(img,"png",new File("E:\\Java 新卓越\\liu\\作业\\VerifyCode.png"));
        System.out.println("验证码："+str);
    }

}
