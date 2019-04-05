package com.upload;

import javax.servlet.http.Part;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;


public class FileUploadUtils {

    public static List<UploadResult> uploadFile(Collection<Part> parts,String path,long limitSize,String ... types) throws UploadException{

        List<UploadResult> list = new ArrayList<>();

        if (parts == null || parts.isEmpty()){
            throw new UploadException(1,"上传文件为空");
        }

        Iterator<Part> iterator = parts.iterator();
        while (iterator.hasNext()){
            UploadResult result = new UploadResult();
            Part part =  iterator.next();
            String oldName = part.getSubmittedFileName();
            if (oldName == null){
                continue;
            }
            if (part.getSize() > limitSize){
                throw new UploadException(2,"上传文件过大");
            }
            String extName = getExtName(oldName).substring(1);
            int flag = 0;

            for (String type:types) {
                if (type.equals(extName)){
                    flag = 1;
                    break;
                }
            }

            if (flag<=0){
                throw new UploadException(3,"上传文件格式不符");
            }


            String randomName = getRandomName();
            String newName = randomName+getExtName(oldName);
            String mimeType = part.getContentType();
            String targetPath = path+ File.separator+newName;

            result.setMimeType(mimeType);
            result.setNewName(newName);
            result.setOldName(oldName);

            list.add(result);

            try {
                part.write(targetPath);
            } catch (IOException e) {

                e.printStackTrace();
            }
        }
        return list;
    }

    private static String getExtName(String name){
        int index = name.lastIndexOf(".");
        return   name.substring(index);
    }

    private static String getRandomName(){
        SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmmssSSS");

        return format.format(new Date())+new Random().nextInt(1000);
    }

}
