package baekjoon.week4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class B11724 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        LinkedList<Integer>[] adjList = new LinkedList[n + 1];
        boolean[] visited = new boolean[n + 1];

        for (int i = 0; i <= n; i++) {
            adjList[i] = new LinkedList<Integer>();
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());
            adjList[v1].add(v2);
            adjList[v2].add(v1);
        }

        int count = 0;
        for (int i = 1; i <= n; i++) {
            if (!visited[i]) {
                count++;
                dfs(i, adjList, visited);
            }
        }
        System.out.println(count);
    }

    public static void dfs(int v, LinkedList<Integer>[] adjList, boolean[] visited) {
        visited[v] = true;
        for (int i = 0; i < adjList[v].size(); i++) {
            int val = adjList[v].get(i);
            if (!visited[val]) {
                dfs(val, adjList, visited);
            }
        }
    }
}
