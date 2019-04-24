package com.zth;

/**
 * @author zth
 * @Date 2019-04-21 20:13
 */
public class Calculator {
    private static int result;
    public void add(int n) {
        result += n;
    }
    public void substract(int n) {
        result -= n;
    }
    public void multiply(int n) {
        result *= n;
    }
    public void divide(int n) throws Exception {
        if(n == 0) {
            throw new  Exception("除数不能为0");
        }
        result /= n;
    }
    public void clear() {
        result = 0;
    }
    public int getResult() {
        return result;
    }
}