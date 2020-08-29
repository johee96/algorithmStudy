package programmers.dfs_bfs;


import java.util.LinkedList;
import java.util.Queue;

public class 컬러링북 {
    public static void main(String[] args) {

    }

    static class Node {
        int a, b;

        public Node(int a, int b) {
            this.a = a;
            this.b = b;

        }

    }

    class Solution {
        public int[] solution(int m, int n, int[][] picture) {
            int numberOfArea = 0;
            int maxSizeOfOneArea = 0;

            //0,-1은 방문한 것 처럼 사용
            int target = -1;
            Queue<Node> queue = new LinkedList<>();
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    picture[i][j] = picture[i][j];
                    if (picture[i][j] > 0) {
                        queue.add(new Node(i, j));
                        target = picture[i][j];
                        picture[i][j] = -1;

                        maxSizeOfOneArea = Math.max(maxSizeOfOneArea, bfs(queue, picture, m, n, target));

                        queue.clear();
                        numberOfArea++;
                    }
                }
            }

            int[] answer = new int[2];
            answer[0] = numberOfArea;
            answer[1] = maxSizeOfOneArea;
            return answer;
        }

        private int bfs(Queue<Node> queue, int[][] picture, int m, int n, int target) {
            int[] A = {-1, 1, 0, 0};
            int[] B = {0, 0, -1, 1};
            int cnt = 1;
            while (!queue.isEmpty()) {
                Node node = queue.poll();
                for (int i = 0; i < 4; i++) {
                    int newA = node.a + A[i];
                    int newB = node.b + B[i];
                    if (newA < 0 || newA >= m || newB < 0 || newB >= n || picture[newA][newB] <= 0)
                        continue;

                    if (picture[newA][newB] == target) {
                        queue.add(new Node(newA, newB));
                        picture[newA][newB] = -1; //방문처리
                        cnt++;

                    }
                }
            }
            return cnt;
        }
    }
}
