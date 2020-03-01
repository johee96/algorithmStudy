package baekjoon.dq;

import java.util.Scanner;

public class B2740 {
    static int n, m, m2, k;
    static int dataA[][], dataB[][];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        dataA = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                dataA[i][j] = sc.nextInt();
            }
        }
        m2 = sc.nextInt();
        k = sc.nextInt();
        dataB = new int[m2][k];
        for (int i = 0; i < m2; i++) {
            for (int j = 0; j < k; j++) {
                dataB[i][j] = sc.nextInt();
            }
        }
        int[][] result = new int[n][k];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < k; j++) {
                result[i][j] = resultValue(i,j);
            }
        }
        printData(result);
    }

    static int resultValue(int a, int b) {
        int result = 0;
        for (int i = 0; i < m; i++) {
            result += dataA[a][i] * dataB[i][b];
        }

        return result;
    }

    static void printData(int[][] result){
        for (int i=0;i<n;i++){
            for(int j=0;j<k;j++){
                System.out.print(result[i][j]+" ");
            }
            System.out.println("");
        }
    }
}
