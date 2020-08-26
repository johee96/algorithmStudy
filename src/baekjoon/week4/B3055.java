package baekjoon.week4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B3055 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        char[][] map = new char[R][C];
        boolean[][] visited = new boolean[R][C];

        int[] A = {-1, 1, 0, 0};
        int[] B = {0, 0, -1, 1};

        Queue<Node> water = new LinkedList<>();     //물
        Queue<Node> hedgehog = new LinkedList<>();  //고슴도치
        Node D = null;

        for (int i = 0; i < R; i++) {
            String str = br.readLine();
            for (int j = 0; j < str.length(); j++) {
                map[i][j] = str.charAt(j);
                if (map[i][j] == '*') {
                    water.add(new Node(i, j));
                    visited[i][j] = true;
                } else if (map[i][j] == 'X') {
                    visited[i][j] = true;
                } else if (map[i][j] == 'S') {
                    hedgehog.add(new Node(i, j));
                } else if (map[i][j] == 'D') {
                    D = new Node(i, j);
                }
            }
        }
        int result = 0;
        while (!hedgehog.isEmpty()) {
            //물 먼저 처리하기
            int waterSize = water.size();
            for (int w = 0; w < waterSize; w++) {
                Node waterNode = water.poll();
                for (int i = 0; i < 4; i++) {
                    int newA = waterNode.a + A[i];
                    int newB = waterNode.b + B[i];
                    if (newA < 0 || newA >= R || newB < 0 || newB >= C || visited[newA][newB])
                        continue;
                    if (map[newA][newB] == '.') {
                        water.add(new Node(newA, newB));
                        visited[newA][newB] = true;
                    }
                }
            }

            //고슴도치
            int hedgehogSize = hedgehog.size();
            for (int h = 0; h < hedgehogSize; h++) {
                Node hedgehogNode = hedgehog.poll();
                if (hedgehogNode.a == D.a && hedgehogNode.b == D.b) {
                    System.out.println(result);
                    return;
                }
                for (int i = 0; i < 4; i++) {
                    int newA = hedgehogNode.a + A[i];
                    int newB = hedgehogNode.b + B[i];
                    if (newA < 0 || newA >= R || newB < 0 || newB >= C || visited[newA][newB])
                        continue;
                    if (map[newA][newB] == '.' || map[newA][newB] == 'D') {
                        hedgehog.add(new Node(newA, newB));
                        visited[newA][newB] = true;
                    }
                }
            }
            result++;

        }
        System.out.println("KAKTUS");

    }

    static class Node {
        int a;
        int b;

        public Node(int a, int b) {
            this.a = a;
            this.b = b;
        }

    }

}
