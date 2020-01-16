package swexpert.D3;

import java.util.Scanner;

public class 최장경로_SW2814 {
    static boolean map[][], visited[];
    static int n, result;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();
        for (int t = 1; t <= tc; t++) {
            n = sc.nextInt();       //n : n개의 정점
            int m = sc.nextInt();       //m : m개의 간선
            map = new boolean[n + 1][n + 1];
            result = 0;
            visited = new boolean[n + 1];
            for (int i = 0; i < m; i++) {
                int a = sc.nextInt();
                int b = sc.nextInt();
                map[a][b] = true;
                map[b][a] = true;
            }

            for (int i = 1; i <= n; i++) {
                visited[i] = true;
                dfs(i, 1);
                visited[i] = false;
            }
            System.out.println("#" + t + " " + result);
        }
    }

    private static void dfs(int idx, int cnt) {
        if (result < cnt)
            result = cnt;

        for (int i = 1; i <= n; i++) {
            if (map[idx][i] && !visited[i]) {
                visited[i] = true;
                dfs(i, cnt + 1);
                visited[i] = false;

            }
        }

    }
}
