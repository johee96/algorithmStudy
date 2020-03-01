package baekjoon.dq;

import java.util.Scanner;

public class B1629 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        long result = pow(a, b, c);
        System.out.println(result);
    }

    static long pow(int a, int b, int c) {
        long re = 1;
        if (b == 0)
            return 1;
        if (b == 1)
            return a % c;
        if (b % 2 == 0) {
            long tmp = pow(a, b / 2, c);
            return (tmp * tmp) % c;
        } else {
            long tmp = pow(a, b - 1, c);
            return a * tmp % c;
        }
    }
}
