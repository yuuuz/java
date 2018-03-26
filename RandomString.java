package zy.j20180309;

import java.util.*;

/**
 * 2018/3/10 9:37
 */
public class RandomString {
    public static final String allChar = "0123456789ABCDEFGHIGKLMNOPQRSTUVWXYZabcdefghigklmnopqrstuvwxyz";
    public static void randomss(int n){
        StringBuilder s = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < n; i++) {
            char a = allChar.charAt(random.nextInt(allChar.length()));
            s.append(a);
        }
        String b = s.toString();
        System.out.println(b);
    }
    public static void main(String[] args){
        System.out.println("请输入想要获取几位随机数：");
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        randomss(n);
    }
}
