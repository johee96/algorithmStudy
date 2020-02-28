package baekjoon;

import java.util.Scanner;

//2630. 색종이만들기
public class B2630 {
    static int whiteCnt = 0;
    static int blueCnt = 0;
    static int n;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        int[][] data = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                data[i][j] = sc.nextInt();
            }
        }
        make(data, n, 0, 0);
        System.out.println(whiteCnt + "\n" + blueCnt);

    }

    static void make(int[][] data, int d, int a, int b) {
        if (d < 1 || a < 0 || b < 0 || a >= n || b >= n)
            return;
        if (!check(data, d, a, b)) {
            make(data, d / 2, a, b);
            make(data, d / 2, a, b + d / 2);
            make(data, d / 2, a + d / 2, b);
            make(data, d / 2, a + d / 2, b + d / 2);
        }
    }

    static boolean check(int[][] data, int d, int a, int b) {
        boolean result = true;
        int value = data[a][b];
        for (int i = a; i < a + d; i++) {
            for (int j = b; j < b + d; j++) {
                if (value != data[i][j]) {
                    result = false;
                    return result;
                }
            }
        }
        if (value == 0) {
            whiteCnt++;
        } else {
            blueCnt++;
        }
        return result;
    }
}
