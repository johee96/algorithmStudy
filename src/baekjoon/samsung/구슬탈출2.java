package baekjoon.samsung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 구슬탈출2 {
    static char[][] map;
    static int n, m;
    static int result = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new char[n][m];
        Point R = null, B = null;
        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            for (int j = 0; j < m; j++) {
                map[i][j] = str.charAt(j);
                if (str.charAt(j) == 'R') {
                    R = new Point(i, j, 0);
                }
                if (str.charAt(j) == 'B') {
                    B = new Point(i, j, 0);
                }
            }
        }
        BFS(R, B);
        System.out.print(result);
    }

    private static void BFS(Point redStart, Point blueStart) {
        int[] nDir = {1, 0, -1, 0};
        int[] mDir = {0, 1, 0, -1};

        Queue<Point> redQ = new LinkedList<>();
        Queue<Point> blueQ = new LinkedList<>();
        redQ.add(redStart);
        blueQ.add(blueStart);

        while (!redQ.isEmpty() && !blueQ.isEmpty()) {
            Point red = redQ.poll();
            Point blue = blueQ.poll();
            for (int i = 0; i < 4; i++) {
                Point redPos = new Point(red.n, red.m, red.count);
                Point bluePos = new Point(blue.n, blue.m, blue.count);

                boolean checkRed = false;
                boolean checkBlue = false;

                map[red.n][red.m] = 'R';
                map[blue.n][blue.m] = 'B';
                if (redPos.count >= 10) {
                    result = -1;
                    continue;
                }

                while (true) {
                    //red가 빠질 때
                    if (map[redPos.n + nDir[i]][redPos.m + mDir[i]] == 'O') {
                        checkRed = true;
                        map[redPos.n][redPos.m] = '.';
                        redPos.n += nDir[i];
                        redPos.m += mDir[i];
                    }
                    //blue가 빠질 때
                    if (map[bluePos.n + nDir[i]][bluePos.m + mDir[i]] == 'O') {
                        checkBlue = true;
                        break;
                    }

                    //종료
                    if (map[bluePos.n + nDir[i]][bluePos.m + mDir[i]] != '.' &&
                            (map[redPos.n + nDir[i]][redPos.m + mDir[i]] != '.' || checkRed))
                        break;

                    //red 움직이기
                    if (!checkRed && map[redPos.n + nDir[i]][redPos.m + mDir[i]] == '.') {
                        map[redPos.n][redPos.m] = '.';
                        redPos.n += nDir[i];
                        redPos.m += mDir[i];
                        map[redPos.n][redPos.m] = 'R';
                    }

                    //blue 움직이기
                    if (map[bluePos.n + nDir[i]][bluePos.m + mDir[i]] == '.') {
                        map[bluePos.n][bluePos.m] = '.';
                        bluePos.n += nDir[i];
                        bluePos.m += mDir[i];
                        map[bluePos.n][bluePos.m] = 'B';
                    }
                }

                if (!checkBlue && checkRed) {
                    result = red.count + 1;
                    return;
                }

                if (checkBlue) {
                    result = -1;
                } else {
                    redPos.count += 1;
                    bluePos.count += 1;
                    redQ.add(redPos);
                    blueQ.add(bluePos);
                }
                //초기화
                if (map[bluePos.n][bluePos.m] == 'B')
                    map[bluePos.n][bluePos.m] = '.';
                if (map[redPos.n][redPos.m] == 'R')
                    map[redPos.n][redPos.m] = '.';
            }
        }


    }

}

class Point {
    int n, m, count;

    public Point(int n, int m, int count) {
        this.n = n;
        this.m = m;
        this.count = count;
    }
}

