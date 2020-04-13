package programmers.graph;

public class 순위 {
    public static void main(String[] args) {
        int[][] data = {{4, 3}, {4, 2}, {3, 2}, {1, 2}, {2, 5}};
        순위_Solution s = new 순위_Solution();
        System.out.println(s.solution(5, data));
    }
}

class 순위_Solution {
    int[][] resultMap;
    boolean[] visited;
    boolean[][] map;

    public int solution(int n, int[][] results) {
        int answer = 0;
        resultMap = new int[n + 1][n + 1];
        visited = new boolean[n + 1];
        map = new boolean[n + 1][n + 1];
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                if (i == j) {
                    resultMap[i][j] = 0;
                } else {
                    resultMap[i][j] = -1;
                }
            }
        }
        for (int i = 0; i < results.length; i++) {
            int a = results[i][0];
            int b = results[i][1];
            map[a][b] = true;
        }
        for (int i = 1; i < n + 1; i++) {
            visited[i] = true;
            dfs(i, 0, n, i);
            visited[i] = false;
        }
        for (int i = 1; i < n + 1; i++) {
            boolean check = true;
            for (int j = 1; j < n + 1; j++) {
                if (resultMap[i][j] == -1) {
                    check = false;
                    break;
                }
            }
            if (check) answer++;
        }
        return answer;
    }

    void dfs(int idx, int cnt, int n, int start) {
        if (idx > n + 1 || cnt > n) {
            return;
        }
        for (int i = 1; i < n + 1; i++) {
            if (map[idx][i] && !visited[i] && resultMap[start][i] != 1) {
                System.out.println("idx:" + idx + " i:" + i);
                if (idx != i) {
                    resultMap[start][i] = 1;
                    resultMap[i][start] = 1;
                }
                visited[i] = true;
                dfs(i, cnt + 1, n, start);
                visited[i] = false;
            }
        }
    }

}
