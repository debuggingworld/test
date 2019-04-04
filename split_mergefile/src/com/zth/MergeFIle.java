package com.zth;

import javax.swing.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class MergeFIle {
    public static void main(String[] args) throws Exception{
        JFileChooser chooser = new JFileChooser("C:\\Users\\Administrator\\Desktop");

        chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);

        File file = null;
        int result = chooser.showOpenDialog(null);

        if (result == JFileChooser.APPROVE_OPTION){
            file = chooser.getSelectedFile();
        }

        mergeFile(file);

    }

    private static void mergeFile(File file) throws Exception{
        File[] files = file.listFiles();
        if (files == null || files.length==0){
            System.out.println("此文件夹为空");
            return;
        }

        File file0 = files[0];


        // 合并后文件后缀名
        String extName = file0.getName().substring(file0.getName().lastIndexOf("."),file0.getName().lastIndexOf("_"));

        // 合并后文件的保存路径
        String path = file0.getParent()+extName;


        FileOutputStream outputStream = new FileOutputStream(new File(path));

        byte[] buffer = new byte[1024];

        for (File subfile: files) {
            FileInputStream inputStream = new FileInputStream(subfile);

            int len = -1;

            while (-1 != (len = inputStream.read(buffer))){
                outputStream.write(buffer,0,len);
            }
        }
        System.out.println("文件合并完成");

    }
}
