package baekjoon.week4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

//todo 다시 풀어보기 -> PQ 사용해보기
public class B1261 {
    static int m, n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        int[][] box = new int[n][m];

        //input
        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            for (int j = 0; j < m; j++)
                box[i][j] = str.charAt(j) - '0';
        }

        bfs(box);

        /*dfs : 메모리 초과
        boolean[][] visited = new boolean[n][m];
        dfs(0, 0, box, visited, 0);
        System.out.println(min);
         */
    }

    private static void bfs(int[][] box) {
        int[] A = {-1, 1, 0, 0};
        int[] B = {0, 0, -1, 1};
        boolean[][] visited = new boolean[n][m];

        Deque<Node> deque = new ArrayDeque<>();
        deque.add(new Node(0, 0, 0));
        visited[0][0] = true;

        while (!deque.isEmpty()) {
            Node node = deque.pollFirst();

            if (node.a == n - 1 && node.b == m - 1) {
                System.out.println(node.cnt);
                return;
            }
            for (int i = 0; i < 4; i++) {
                int newA = node.a + A[i];
                int newB = node.b + B[i];
                if (newA < 0 || newA >= n || newB < 0 || newB >= m || visited[newA][newB])
                    continue;

                if (box[newA][newB] == 1) {
                    deque.addLast(new Node(newA, newB, node.cnt + 1));
                } else {
                    deque.addFirst(new Node(newA, newB, node.cnt));
                }
                visited[newA][newB] = true;             //방문확인을 큐에서 poll할 때 하면 메모리 초과 오류가 난다.
                // 즉, 큐에 넣을 때 방문확인을 해줘야지 중복으로 안들어가는 듯??
            }
        }
    }

    static class Node {
        int a;
        int b;
        int cnt;

        public Node(int a, int b, int cnt) {
            this.a = a;
            this.b = b;
            this.cnt = cnt;
        }

    }

    /*메모리 초과
    private static void dfs(int a, int b, int[][] box, boolean[][] visited, int cnt) {
        int[] A = {-1, 1, 0, 0};
        int[] B = {0, 0, -1, 1};
        if (a == n - 1 && b == m - 1) {
           min = Math.min(min, cnt);
            return;
        }
        visited[a][b] = true;
        for (int i = 0; i < 4; i++) {
            int newA = a + A[i];
            int newB = b + B[i];
            if (newA < 0 || newA >= n || newB < 0 || newB >= m)
                continue;
            if (!visited[newA][newB]) {
                if (box[newA][newB] == 1) {
                    dfs(newA, newB, box, visited, cnt + 1);
                } else {
                    dfs(newA, newB, box, visited, cnt);
                }
            }

        }
        visited[a][b] = false;

    }

     */
}
