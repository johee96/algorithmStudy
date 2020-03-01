package baekjoon.dq;

import java.util.Scanner;

public class B10830 {
    static int n;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        long b = sc.nextLong();
        long[][] data = new long[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                data[i][j] = sc.nextLong();
            }
        }
        long[][] result = pow(data, b);
        printData(result);
    }

    static long[][] pow(long[][] data, long b) {

        if (b == 0) {
            long[][] tmp = new long[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    tmp[i][j] = 1;
                }
            }
            return tmp;
        }
        if (b == 1)
            return data;
        if (b % 2 == 1) {
            //홀수
            long[][] tmp = pow(data, b - 1);
            return countPow(data, tmp);
        } else {
            //짝수
            long[][] tmp = pow(data, b / 2);
            return countPow(tmp, tmp);
        }
    }

    static long[][] countPow(long[][] dataA, long[][] dataB) {
        long[][] result = new long[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                long tmp = 0;
                for (int k = 0; k < n; k++) {
                    tmp += dataA[i][k] * dataB[k][j];
                }
                result[i][j] = tmp % 1000;
            }
        }
        return result;
    }

    static void printData(long[][] result) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print((result[i][j]%1000)  + " ");
            }
            System.out.println("");
        }
    }
}
