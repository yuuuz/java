package zy.j20180309;

import java.util.Scanner;

/**
 * 2018/3/24 9:51
 */
public enum  Enum1 {
    SMALL("S"),MEDIUM("M"),LARGE("L"),EXTRA_LARGE("XL");
    private String abbreviation;

    private Enum1(String abbreviation){
        this.abbreviation = abbreviation;
    }
    public String getAbbreviation(){
        return abbreviation;
    }
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        System.out.print("Enter a size:(SMALL,MEDIUM,LARGE,EXTRA_LARGE) ");
        String input = in.next().toUpperCase();
        Enum1 e = Enum.valueOf(Enum1.class,input);
        System.out.println("size=" + e);
        System.out.println("abbreviation=" + e.getAbbreviation());
        if (e == Enum1.EXTRA_LARGE)
            System.out.println("Good job--you paid attention to the _.");
    }
}
