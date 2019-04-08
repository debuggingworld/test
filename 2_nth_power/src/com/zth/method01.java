package com.zth;

public class method01 {
    public static void main(String[] args){
        int i = 16;    // 待判断的数
        int count = 1;  // 待判断的数是 2 的 count 次方

        while (i>0){
            if (2 == i){
                System.out.println("i 是 2 的 "+count+" 次方！");
                break;
            }
            if ( 0 == i%2){
                i /= 2;
                count++;
            }else {
                System.out.println("i 不是 2 的次方！");
                break;
            }
        }
    }
}
