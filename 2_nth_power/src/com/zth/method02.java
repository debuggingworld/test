package com.zth;

public class method02 {
    public static void main(String[] args){

        int i = 128;     // 待判断的数
        int count = 0;  // 2 进制数中 1 的个数

        while (i > 0) {

            count += i & 0x01;
            /**
             * i 与 00000001 进行“与”操作
             * 右移位的过程中，把最后一位直接丢弃
             */
            i >>= 1;
        }
        if (count < 2){
            // count = 0 || count = 1
            System.out.println("i 是 2 的次方！");
        }else {
            System.out.println("i 不是 2 的次方！");
        }
    }
}
