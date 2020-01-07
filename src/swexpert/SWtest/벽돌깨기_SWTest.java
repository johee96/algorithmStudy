package swexpert.SWtest;

import java.util.Scanner;

public class 벽돌깨기_SWTest {
    static int map[][], tmp[][];
    static int count, n, w, h;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();
        for (int t = 1; t <= tc; t++) {
            n = sc.nextInt();
            w = sc.nextInt();
            h = sc.nextInt();
            map = new int[h][w];
            tmp = new int[h][w];

            count = Integer.MAX_VALUE;

            for (int i = 0; i < h; i++)
                for (int j = 0; j < w; j++)
                    map[i][j] = sc.nextInt();

            solve();
            System.out.println("#"+t+" "+count);
        }

    }

    private static void solve() {
        //폭탄을 떨어트릴 순서 넘기
        for (int i = 0; i < w; i++)
            for (int j = 0; j < w; j++)
                for (int k = 0; k < w; k++)
                    for (int v = 0; v < w; v++)
                        bombSeq(i, j, k, v);

    }

    private static void bombSeq(int a, int b, int c, int d) {
        //폭탄 떨어트릴 순서배열
        int seq[] = new int[4];
        seq[0] = a;
        seq[1] = b;
        seq[2] = c;
        seq[3] = d;

        initTmp(); //tmp 배열 초기
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < h; j++) {
                if (tmp[j][seq[i]] != 0) {
                    //폭탄 터짐
                    bomb(j, seq[i], tmp[j][seq[i]]);
                    break;
                }
            }
            //빈 공간있으면 down
            down();
        }
        //남은 벽돌 수 세기
        getCount();

    }

    //폭탄 터짐
    private static void bomb(int a, int b, int v) {
        int da[] = {1, -1, 0, 0};
        int db[] = {0, 0, -1, 1};

        tmp[a][b] = 0;
        if (v == 1) return;

        for (int i = 0; i < 4; i++) {
            for (int j = 1; j < v; j++) {
                int tmpA = a + da[i] * j;
                int tmpB = b + db[i] * j;
                if (tmpA >= 0 && tmpA < h && tmpB >= 0 && tmpB < w) {
                    if (tmp[tmpA][tmpB] > 0) {
                        bomb(tmpA, tmpB, tmp[tmpA][tmpB]);
                    }
                }else break;

            }
        }
    }

    //비어있는 칸 아래로 내리기
    private static void down() {
        for (int i = 0; i < w; i++) {
            for (int j = h - 1; j >= 0; j--) {
                if (tmp[j][i] == 0) {
                    for (int k = j - 1; k >= 0; k--) {
                        if (tmp[k][i] != 0) {
                            tmp[j][i] = tmp[k][i];
                            tmp[k][i] = 0;
                            break;
                        }
                    }
                }
            }

        }

    }

    //남은 벽돌 수 세기
    private static void getCount() {
        int cnt = 0;
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++)
                if (tmp[i][j] != 0)
                    cnt++;
        }
        if (cnt < count)
            count = cnt;
    }

    //tmp 배열 초기화
    private static void initTmp() {
        for (int i = 0; i < h; i++)
            for (int j = 0; j < w; j++)
                tmp[i][j] = map[i][j];

    }
}
