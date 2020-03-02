package baekjoon.dq;

import java.util.Scanner;

public class B2749 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();
        int pisano = 1500000;
        long data[] = new long[pisano];
        data[0] = 0;
        data[1] = 1;
        long index = n;
        for (int i = 2; i < pisano && i <= n; i++) {
            data[i] = (data[i - 1] + data[i - 2]) % 1000000;
        }
        if (n >= pisano) {
            index %= pisano;
        }
        System.out.print(data[(int) index]% 1000000);

    }
}
