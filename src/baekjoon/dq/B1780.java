package baekjoon.dq;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//1780 종이의개수
public class B1780 {
    static int n;
    static int minus, zero, one;
    static int[][] data;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        data = new int[n][n];
        for (int i = 0; i < n; i++) {
            StringTokenizer str = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                data[i][j] = Integer.parseInt(str.nextToken());
            }
        }
        countPaper(n, 0, 0);
        System.out.println(minus + "\n" + zero + "\n" + one);
    }

    static void countPaper(int size, int row, int col) {
        if (size < 1 || row < 0 || col < 0 || row >= n || col >= n) {
            return;
        }
        int newSize = size / 3;
        if (!check(size, row, col)) {
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    countPaper(newSize, row + i * newSize, col + j * newSize);
                }
            }
        }
    }

    static boolean check(int size, int row, int col) {
        int v = data[row][col];
        for (int i = row; i < row + size; i++) {
            for (int j = col; j < col + size; j++) {
                if (v != data[i][j]) {
                    return false;
                }
            }
        }
        if (v == 1) {
            one++;
        } else if (v == 0) {
            zero++;
        } else {
            minus++;
        }
        return true;
    }
}
