package baekjoon.week4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B7576 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        int[][] box = new int[n][m];
        int[] A = {-1, 1, 0, 0};
        int[] B = {0, 0, -1, 1};
        Queue<Tomato> queue = new LinkedList<>();
        boolean check = true;
        //input
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                box[i][j] = Integer.parseInt(st.nextToken());
                if (box[i][j] == 1) {
                    queue.add(new Tomato(i, j, 1));
                }
                if (box[i][j] == 0)
                    check = false;
            }
        }

        //다 익은 상태
        if (check) {
            System.out.println(0);
            return;
        }

        //bfs
        while (!queue.isEmpty()) {
            Tomato t = queue.poll();
            for (int i = 0; i < 4; i++) {
                int a = A[i] + t.a;
                int b = B[i] + t.b;

                if (a < 0 || a >= n || b < 0 || b >= m)
                    continue;
                if (box[a][b] == 0) {
                    box[a][b] = t.day + 1;
                    queue.add(new Tomato(a, b, t.day + 1));
                }

            }
        }

        int max = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (box[i][j] == 0) {
                    System.out.println(-1);
                    return;
                }
                max = Math.max(max, box[i][j]);
            }
        }
        System.out.println(max - 1);

    }

    static class Tomato {
        int a;
        int b;
        int day;

        public Tomato(int a, int b, int day) {
            this.a = a;
            this.b = b;
            this.day = day;
        }
    }
}
