package baekjoon.samsung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 뱀 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] map = new int[n][n];        //1:사과, 2:벰
        int k = Integer.parseInt(br.readLine());
        for (int i = 0; i < k; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;
            map[a][b] = 1;
        }
        int l = Integer.parseInt(br.readLine());
        Queue<ChangeInfo> changeInfos = new LinkedList<>();
        for (int i = 0; i < l; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            changeInfos.add(new ChangeInfo(Integer.parseInt(st.nextToken()), st.nextToken().charAt(0)));
        }

        int[] a = {0, 0, -1, 1}; //우,좌,위,아래
        int[] b = {1, -1, 0, 0};
        Deque<Snake> snake = new ArrayDeque<>();
        int time = 0;
        int direct = 0;
        snake.add(new Snake(0, 0));
        map[0][0] = 2;
        while (true) {
            time += 1;
            //뱀 이동
            Snake head = snake.peekLast();
            int newA = head.a + a[direct];
            int newB = head.b + b[direct];
            //종료조건
            if (newA < 0 || newA >= n || newB < 0 || newB >= n) { //벽에 부딪
                break;
            }
            if (map[newA][newB] == 2) { //뱀에 부딪
                break;
            }

            if (map[newA][newB] != 1) {                //다음칸이 사과가 아니면
                Snake s = snake.pollFirst();
                map[s.a][s.b] = 0;
            }
            snake.addLast(new Snake(newA, newB));
            map[newA][newB] = 2;

            if (!changeInfos.isEmpty() && changeInfos.peek().time == time) {
                //시간이 되었으면 방향회전
                ChangeInfo changeInfo = changeInfos.poll();
                direct = changeDirect(direct, changeInfo.com);
            }

        }
        System.out.print(time);
    }

    private static int changeDirect(int direct, char com) {
        if (direct == 0) { //우,좌
            if (com == 'L') {
                direct = 2;
            } else {  //D
                direct = 3;
            }
        } else if (direct == 1) {
            if (com == 'L') {
                direct = 3;
            } else {  //D
                direct = 2;
            }
        } else if (direct == 3) {
            if (com == 'L') {
                direct = 0;
            } else {  //D
                direct = 1;
            }
        } else {
            if (com == 'L') {
                direct = 1;
            } else {  //D
                direct = 0;
            }
        }
        return direct;
    }

    static class Snake {
        int a, b;

        public Snake(int a, int b) {
            this.a = a;
            this.b = b;
        }
    }

    static class ChangeInfo {
        int time;
        char com;

        public ChangeInfo(int time, char com) {
            this.com = com;
            this.time = time;
        }
    }
}
