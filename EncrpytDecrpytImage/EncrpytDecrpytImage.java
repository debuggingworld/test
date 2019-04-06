package com.zth;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class EncrpytDecrpytImage {

    public static void main(String[] args) throws Exception{
        JFileChooser jFileChooser = new JFileChooser(new File("C:\\Users\\Administrator\\Desktop"));

        FileNameExtensionFilter filter = new FileNameExtensionFilter("图片呀图片","jpg","png","gif","zth");

        jFileChooser.setFileFilter(filter);

        int returnvalue = jFileChooser.showOpenDialog(null);

        if (returnvalue == JFileChooser.APPROVE_OPTION){
            encrpytDecrpytImage(jFileChooser.getSelectedFile(),true);
        }
    }

    /**
     * 对文件进行加密或解密
     * aaa.jpg<-->aaa_jpg.zth
     * @param file
     * @param del 是否保留原文件 true 不保留
     */
    public static void encrpytDecrpytImage(File file ,boolean del)throws Exception{

        String message;
        String filename = file.getName();
        // 获取最后一个.的位置
        int lastdot = filename.lastIndexOf(".");
        // 获取文件名前缀
        String preName = filename.substring(0,lastdot);
        // 获取文件后缀
        String extname = filename.substring(lastdot);
        // 获取图片路径的父目录---->即加密解密后文件保存地址
        File path = file.getParentFile();

        File target ;


        FileInputStream inputStream = new FileInputStream(file);

        FileOutputStream outputStream ;

        if (".zth".equals(extname)) {
            // 解密 aaa.jpg<--aaa_jpg.zth
            message = "解密完成";
            // 获取 _ 的位置
            int laseUnderLine = preName.lastIndexOf("_");
            // 解密后的文件名
            String name = preName.substring(0,laseUnderLine);
            // 解密后的文件后缀
            String exname = preName.substring(laseUnderLine+1);

            target = new File(file.getParentFile(),name+"."+exname);

        }else{
            // 加密 aaa.jpg-->aaa_jpg.zth
            message = "加密完成";
            target = new File(file.getParentFile(),preName+"_"+extname.substring(1)+".zth");
        }

        outputStream = new FileOutputStream(target);
        byte[] buffer = new byte[1024*4];

        int len = -1;
        while (-1 != (len =inputStream.read(buffer) )){
            for (int i = 0; i < len; i++) {
                buffer[i] ^= 13;
            }
            outputStream.write(buffer,0,len);
        }

        if (del) file.delete();
        inputStream.close();
        outputStream.close();
        JOptionPane.showMessageDialog(null,message);
    }
}
