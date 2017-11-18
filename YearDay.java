package zy.j20171104;

import java.util.Scanner;

/**
 * 给出年月日算出是这一年的第几天
 * 2017/11/6 22:42
 */
public class YearDay {
    public static void main(String[] args){
        System.out.print("请输入年月日（例如20171012）：");
        Scanner s = new Scanner(System.in);
        int a = s.nextInt();
        System.out.println();
        getdays(a);
    }

    private static void getdays(int a){
        int day = a % 100;
        int month = a / 100 % 100;
        int year = a / 10000;
        int[] b = {0,31,28,31,30,31,30,31,31,30,31,30};
        int s = 0;
        if ((year % 4 == 0 || year % 100 == 0) && year % 400 != 0){
            b[2] = 29;
        }
        for (int i = 1; i <= month; i++) {
            s += b[i - 1];
        }
        s += day;
        System.out.println("第" + s + "天");
    }
}
