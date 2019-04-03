package com.zpiutil;

import javax.swing.*;
import java.io.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**
 * @author 时光·漫步
 * 将文件或目录压缩为 zip  文件
 */
public class CompressUtil {

    /**
     * 定义缓冲区大小
     */
    public static final int BUF_SIZE = 1024*4;  // 4K

    /**
     * 将文件或目录压缩为 Zip 格式
     * @param srcFile 原文件 File 对象
     * @param zipOutputStream 压缩文件输出流
     */
    public static void toZip(File srcFile,ZipOutputStream zipOutputStream,String path) throws IOException {

        byte[] buf = new byte[BUF_SIZE];
        int len = -1;



        // 判断原文件是否为目录文件
        if (srcFile.isFile()){     // 普通文件
            String name = srcFile.getName();
            FileInputStream inputStream = new FileInputStream(srcFile);

            // 向 zip 输出流中添加一个 zip 实体，name 为zip 实体的文件名
            zipOutputStream.putNextEntry(new ZipEntry(path));

            while ((len = inputStream.read(buf)) >0){
                zipOutputStream.write(buf,0,len);
            }

            inputStream.close();
            zipOutputStream.closeEntry();

        }else {
            // 目录文件
            File[] files = srcFile.listFiles();

            if (files == null || files.length == 0 ){
                // 对空文件夹进行处理
                zipOutputStream.putNextEntry(new ZipEntry(path+"/"));
                zipOutputStream.closeEntry();

            }else {

                for (File file:files) {
                    String name = file.getName();
                    toZip(file,zipOutputStream,path+"/"+name);
                }
            }

        }
    }

    /**
     * 选择进行压缩操作的文件或目录
     * 文件不能为空
     * 文件不能是zip文件
     */

    private static File getSrcFile(){

        File srcFile = null;
        while (true){
            // 原文件选择框
            JFileChooser chooser = new JFileChooser("C:\\Users\\Administrator\\Desktop");

            chooser.setDialogTitle("请选择需要压缩的文件");
            chooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
            int result = chooser.showOpenDialog(null);

            if (result == JFileChooser.APPROVE_OPTION){
                srcFile = chooser.getSelectedFile();
            }

            // 判断是否选中文件，若未选中，提示是否重新选择
            if (srcFile == null){
                int res = JOptionPane.showConfirmDialog(null,"未选择文件，是否重新选择？","未选中文件",JOptionPane.YES_NO_OPTION);

                if (res == JOptionPane.YES_OPTION){
                    continue;
                }else {
                    // 未进行重新选择，则直接退出程序
                    System.exit(0);
                }

            }else {

                // 判断文件是否为 zip 文件，若是，提示是否重新选择
                if (srcFile.isFile()){
                    String fileName = srcFile.getName();
                    int index = fileName.lastIndexOf(".");
                    if (fileName.substring(index+1).toLowerCase().equals("zip") || fileName.substring(index+1).toLowerCase().equals("rar")){
                        // 是 zip 文件
                        int res = JOptionPane.showConfirmDialog(null,"选择文件已是压缩文件，是否重新选择？","所选文件为压缩文件",JOptionPane.YES_NO_OPTION);

                        if (res == JOptionPane.YES_OPTION){
                            continue;
                        }else {
                            System.exit(0);
                        }


                    }else {
                        // 非 zip 文件
                        break;
                    }
                }else {
                    break;
                }

            }

        }
        return srcFile;
    }

    /**
     * 选择压缩文件保存路径
     * @return
     */
    private static File getTargetPath(){

        File targetFile = null;

        while (true){
            JFileChooser chooser = new JFileChooser("C:\\Users\\Administrator\\Desktop");

            chooser.setDialogTitle("请选择压缩文件的保存路径");

            chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);

            int result = chooser.showOpenDialog(null);

            if (result == JFileChooser.APPROVE_OPTION){
                targetFile = chooser.getSelectedFile();
            }

            if (targetFile == null){
                int res = JOptionPane.showConfirmDialog(null,"未选中路径，是否重新选择？","未选中文件保存路径",JOptionPane.YES_NO_OPTION);

                if (res == JOptionPane.YES_OPTION){
                    continue;
                }else {
                    System.exit(0);
                }
            }else {
                break;
            }
        }
        return targetFile;
    }



    public static void main(String[] args) throws IOException {

        File srcFile = getSrcFile();

        File targetPath = getTargetPath();

        ZipOutputStream zipOutputStream = null;
        String enName = null;

        // 生成压缩文件名（原文件或文件夹名）

        String name = srcFile.getName();

        if (srcFile.isFile()){
            enName = name.substring(0,name.lastIndexOf(".")+1)+"zip";
        }else {
            enName = name+".zip";
        }

        System.out.println("开始压缩，请稍后...");
        zipOutputStream = new ZipOutputStream(new FileOutputStream(targetPath+File.separator+enName));

        toZip(srcFile,zipOutputStream,name);

        zipOutputStream.close();

        System.out.println("文件压缩完成！");

    }
}
