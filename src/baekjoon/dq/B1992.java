package baekjoon.dq;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;


class B1992 {
    static StringBuilder sb;
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        int[][] data = new int[n][n];
        sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            for (int j = 0; j < n; j++) {
                data[i][j] = Integer.parseInt(str.substring(j, j + 1));
            }
        }

        quadTree(data, n, 0, 0);
        System.out.println(sb.toString());
    }

    static void quadTree(int[][] data, int size, int row, int col) {

        if (size < 0 || row >= n || row < 0 || col >= n || col < 0) {
            return;
        }

        if (!check(data, size, row, col)) {
            sb.append("(");
            quadTree(data, size / 2, row, col);
            quadTree(data, size / 2, row, col + size / 2);
            quadTree(data, size / 2, row + size / 2, col);
            quadTree(data, size / 2, row + size / 2, col + size / 2);
            sb.append(")");
        }

    }

    static boolean check(int[][] data, int size, int row, int col) {
        int value = data[row][col];
        for (int i = row; i < row + size; i++) {
            for (int j = col; j < col + size; j++) {
                if (value != data[i][j]) {
                    return false;
                }
            }
        }
        sb.append(value);
        return true;
    }
}
