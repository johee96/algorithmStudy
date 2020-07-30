package baekjoon.week1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B1018 {
    private static char[][] white, black;
    private static int N, M;
    private static char[][] data;

    public static void main(String[] args) throws IOException {
        makeAns();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        data = new char[N][M];
        for (int i = 0; i < N; i++) {
            data[i] = br.readLine().toCharArray();
        }
        int result = Integer.MAX_VALUE;
        for (int i = 0; i < N - 7; i++)
            for (int j = 0; j < M - 7; j++)
                result = Math.min(result, countChangeRect(i, j));
        System.out.println(result);
    }

    private static int countChangeRect(int n, int m) {
        int whiteAnsCnt = 0;
        int blackAnsCnt = 0;
        for (int i = n; i < n + 8; i++) {
            for (int j = m; j < m + 8; j++) {
                if (data[i][j] != white[i - n][j - m])
                    whiteAnsCnt++;
                if (data[i][j] != black[i - n][j - m])
                    blackAnsCnt++;
            }
        }

        return Math.min(whiteAnsCnt, blackAnsCnt);
    }

    private static void makeAns() {
        white = new char[8][8];
        black = new char[8][8];
        String wb = "WBWBWBWB";
        String bw = "BWBWBWBW";
        for (int i = 0; i < 7; i += 2) {
            white[i] = wb.toCharArray();
            white[i + 1] = bw.toCharArray();

            black[i] = bw.toCharArray();
            black[i + 1] = wb.toCharArray();

        }
    }
}
