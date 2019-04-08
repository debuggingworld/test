package com.zth;

public class method03 {
    public static void main(String[] args){
        int i = 256;

        if (fun(i)){
            System.out.println("i 是 2 的次方！");
        }else {
            System.out.println("i 不是 2 的次方！");
        }
    }
    public static boolean fun(int i){
        return (i> 0 )&&(i & (i - 1))==0;
    }
}
