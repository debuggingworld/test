package com.zpiutil;

import javax.swing.*;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

public class DecompressUtil {

    public static final int BUF_SIZE = 1024*8;

    /**
     * 选择需要进行解压的 zip 文件
     * @return
     */

    private static File getSrcFile(){

        File srcFile = null;
        while (true){
            // 原文件选择框
            JFileChooser chooser = new JFileChooser("C:\\Users\\Administrator\\Desktop");

            chooser.setDialogTitle("请选择需要解压的文件");
            chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
            int result = chooser.showOpenDialog(null);

            if (result == JFileChooser.APPROVE_OPTION){
                srcFile = chooser.getSelectedFile();
            }

            // 判断是否选中文件，若未选中，提示是否重新选择
            if (srcFile == null){
                int res = JOptionPane.showConfirmDialog(null,"未选中文件，是否重新选择？","未选中文件",JOptionPane.YES_NO_OPTION);

                if (res == JOptionPane.YES_OPTION){
                    continue;
                }else {
                    // 未进行重新选择，则直接退出程序
                    System.exit(0);
                }

            }else {
                // 判断文件是否为 zip 文件，若不是，提示是否重新选择

                String fileName = srcFile.getName();
                int index = fileName.lastIndexOf(".");


                if (!fileName.substring(index+1).toLowerCase().equals("zip") ){
                    // 不是 zip 文件
                    int res = JOptionPane.showConfirmDialog(null,"所选文件不是zip压缩文件，是否重新选择？","所选文件为非zip压缩文件",JOptionPane.YES_NO_OPTION);

                    if (res == JOptionPane.YES_OPTION){
                        continue;
                    }else {
                        System.exit(0);
                    }
                }else {
                    // 非 zip 文件
                    break;
                }
            }
        }
        return srcFile;
    }

    /**
     * 选择解压后文件保存路径
     * @return
     */
    private static File getTargetPath(){
        File targetFile = null;

        while (true){
            JFileChooser chooser = new JFileChooser("C:\\Users\\Administrator\\Desktop");

            chooser.setDialogTitle("请选择解压后文件的保存路径");

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


    private static void unZip(File srcFile, File targetPath) throws IOException {

        ZipFile zipFile = new ZipFile(srcFile, Charset.forName("GBK"));

        Enumeration<? extends ZipEntry> zipEntris = zipFile.entries();

        while (zipEntris.hasMoreElements()){
            ZipEntry zipEntry = zipEntris.nextElement();

            if (zipEntry.isDirectory()){
                //创建解压文件夹
                File targetFile = new File(targetPath+File.separator+zipEntry.getName().substring(0,zipEntry.getName().lastIndexOf("/")));

                if (!targetFile.exists()){
                    targetFile.exists();
                }
            }else {
                File newPath = new File(targetPath+File.separator+zipEntry.getName());

                File up = new File(newPath.toString().substring(0,newPath.toString().lastIndexOf(File.separator)));

                if (!up.exists()){
                    up.mkdirs();
                }

                FileOutputStream outputStream = new FileOutputStream(newPath);

                InputStream inputStream = zipFile.getInputStream(zipEntry);

                byte[] buf = new byte[BUF_SIZE];
                int len =  -1;

                while ((len = (inputStream.read(buf))) > 0){

                    outputStream.write(buf,0,len);
                }

                outputStream.close();
                inputStream.close();

            }

    }
    }


    public static void main(String[] args) throws IOException {

        File scrFile = getSrcFile();
        System.out.println("srcFile::"+scrFile);

        File targetPath = getTargetPath();
        System.out.println("srcFile::"+targetPath);

        System.out.println("解压开始，请稍后....");
        unZip(scrFile,targetPath);

        System.out.println("解压完成！");


    }
}
