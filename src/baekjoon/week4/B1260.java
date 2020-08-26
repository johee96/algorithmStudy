package baekjoon.week4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B1260 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int v = Integer.parseInt(st.nextToken());
        LinkedList<Integer>[] adjList = new LinkedList[n + 1];
        for (int i = 0; i <= n; i++) {
            adjList[i] = new LinkedList<Integer>();
        }

        boolean[] visited = new boolean[n + 1];
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());
            adjList[v1].add(v2);
            adjList[v2].add(v1);
        }

        for (int i = 1; i <= n; i++) {
            Collections.sort(adjList[i]);
        }
        dfs(v, adjList, visited);
        for (int i = 0; i < visited.length; i++) {
            visited[i] = false;
        }
        System.out.println();
        bfs(v, adjList, visited);

    }

    //BFS
    public static void bfs(int v, LinkedList<Integer>[] adjList, boolean[] visited) {
        Queue<Integer> queue = new LinkedList<Integer>();
        visited[v] = true;
        queue.add(v);

        while (!queue.isEmpty()) {
            v = queue.poll();
            System.out.print(v + " ");
            for (int i = 0; i < adjList[v].size(); i++) {
                int val = adjList[v].get(i);
                if (!visited[val]) {
                    visited[val] = true;
                    queue.add(val);
                }
            }
        }

    }

    //DFS
    public static void dfs(int v, LinkedList<Integer>[] adjList, boolean[] visited) {
        visited[v] = true;
        System.out.print(v + " ");
        for (int i = 0; i < adjList[v].size(); i++) {
            int val = adjList[v].get(i);
            if (!visited[val]) {
                visited[val] = true;
                dfs(val, adjList, visited);
            }
        }
    }
}
