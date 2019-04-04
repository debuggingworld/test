package com.zth;

import javax.swing.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class SplitFile {
    public static void main(String[] args) throws Exception{
        JFileChooser chooser = new JFileChooser(new File("C:\\Users\\Administrator\\Desktop"));

        int result = chooser.showOpenDialog(null);

        File file = null;

        if (result == JFileChooser.APPROVE_OPTION){
            file = chooser.getSelectedFile();
        }

        String  str = JOptionPane.showInputDialog("输入文件拆分的份数");
        int num = Integer.valueOf(str);

        splitFile(file,num);

    }

    private static void splitFile(File file ,int num) throws Exception{
        /**
         * 将拆分后的文件保存在相同路径下的同名文件夹下
         */
        String path = file.getAbsolutePath();
        int lastPoint = path.lastIndexOf(".");

        File newPath = new File(path.substring(0,lastPoint));

        // 创建用于保存拆分后文件的文件夹
        newPath.mkdirs();

        // 每个小文件的大小

        long size = file.length()/num;

        // 获取文件名及后缀名
        String fileName = file.getName();

        FileInputStream inputStream = new FileInputStream(file);

        byte[] buffer = new byte[1024];
        int len = -1;


        for (int i =1 ; i <= num; i++) {
            File subFile  = new File(newPath,fileName+"_"+i);
            FileOutputStream outputStream = new FileOutputStream(subFile);

            while (subFile.length() <= size && -1 != (len = inputStream.read(buffer)) ){

                outputStream.write(buffer,0,len);
                /*if(subFile.length() > size) {
                    break;
                }*/
            }
            outputStream.close();
        }
        inputStream.close();


        System.out.println("文件拆分完成");
    }
}
