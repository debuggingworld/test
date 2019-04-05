package com.upload;

public class UploadException extends Exception {

    /**
     * 1------上传文件为空
     * 2------上传文件过大
     * 3------上传文件格式不符
     */
    private int errorCode=0;

    public UploadException(int errorCode,String msg){
        super(msg);
        this.errorCode = errorCode;
    }

    public int getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }
}
