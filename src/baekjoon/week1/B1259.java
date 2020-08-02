package baekjoon.week1;

import java.util.ArrayList;
import java.util.Scanner;

public class B1259 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<String> data = new ArrayList<>();
        while (true) {
            String value = sc.next();
            if (Integer.parseInt(value) == 0)
                break;
            data.add(value);
        }

        for (int i = 0; i < data.size(); i++) {
            checkPalindrome(data.get(i));
        }
    }

    private static void checkPalindrome(String value) {
        String result = "no";
        int strSize = value.length();
        for (int i = 0; i < strSize / 2; i++) {
            if (value.charAt(i) != value.charAt(strSize - 1 - i)) {
                System.out.println(result);
                return;
            }
        }
        result = "yes";
        System.out.println(result);
    }
}
