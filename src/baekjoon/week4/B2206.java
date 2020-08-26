package baekjoon.week4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//todo 다시 풀기
public class B2206 {
    public static void main(String[] args) throws IOException {
        int[] A = {-1, 1, 0, 0};
        int[] B = {0, 0, -1, 1};

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] map = new int[N][M];
        boolean[][][] visited = new boolean[N][M][2];    // visited[x][y][0] :벽이 부숴지지 않은 상태 && visited[x][y][1] : 벽이 부숴진 상태
        Queue<Node> queue = new LinkedList<>();

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < str.length(); j++) {
                map[i][j] = str.charAt(j) - '0';
            }
        }
        queue.add(new Node(0, 0, 1, 0));
        visited[0][0][0] = true;
        visited[0][0][1] = true;

        while (!queue.isEmpty()) {
            Node node = queue.poll();
            if (node.a == N - 1 && node.b == M - 1) {
                System.out.println(node.dist);
                return;
            }

            for (int i = 0; i < 4; i++) {
                int newA = node.a + A[i];
                int newB = node.b + B[i];
                if (newA < 0 || newA >= N || newB < 0 || newB >= M)
                    continue;
                if (map[newA][newB] == 1) { // 벽인 경우
                    if (node.block == 0 && !visited[newA][newB][1]) { // 벽돌을 깬 적이 없는 경우 && 벽돌을 깬 적이 없을 때 방문하지 않음
                        queue.add(new Node(newA, newB, node.dist + 1, 1));
                        visited[newA][newB][1] = true;
                    }
                } else { //벽이 아닌 경우
                    if (!visited[newA][newB][node.block]) {//방문한적이 없는 경우
                        queue.add(new Node(newA, newB, node.dist + 1, node.block));
                        visited[newA][newB][node.block] = true;
                    }

                }
            }
        }
        System.out.println(-1);
    }


    static class Node {
        int a;
        int b;
        int dist;
        int block;

        public Node(int a, int b, int dist, int block) {
            this.a = a;
            this.b = b;
            this.dist = dist;
            this.block = block;
        }

    }

}
