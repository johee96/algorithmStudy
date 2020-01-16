package swexpert.D3;

import java.util.Scanner;

public class N_Queen_SW2806 {
    static int result = 0;
    static int n;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();
        for (int t = 1; t <= tc; t++) {
            n = sc.nextInt();
            result = 0;
            int col[] = new int[n];
            for (int i = 0; i < n; i++) {
                col[0] = i;
                queen(col, 0);
            }
            System.out.println("#"+t+" "+result);
        }
    }

    private static void queen(int col[], int row) {
        if (row == n - 1) {
            result++;
            return;
        } else {
            for (int i = 0; i < n; i++) {
                col[row + 1] = i;
                if (check(col, row + 1))
                    queen(col, row + 1);
            }
        }

    }

    private static boolean check(int col[], int row) {
        for (int i = 0; i < row; i++) {
            //col : row의 행까지 같은 col에 위치하는 퀸이 있는지 확
            if (col[i] == col[row])
                return false;
            //대각선 : 대각선에 위치하면, 두 좌표의 y 좌표 의 차  x 좌표의 차는 같다.
            if (Math.abs(row - i) == Math.abs(col[row] - col[i]))
                return false;
        }

        return true;
    }


}
