package baekjoon.samsung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Easy2048 {
    static int max = 0;
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        int[][] map = new int[n][n];
        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            for (int j = 0; j < n; j++) {
                int value = Integer.parseInt(str.split(" ")[j]);
                max = Math.max(max, value);
                map[i][j] = value;
            }
        }
        dfs(0, map);
        System.out.println(max);
    }

    private static void dfs(int cnt, int[][] map) {
        if (cnt == 5) {
            findMaxNumber(map);
//            System.out.println("------");
//            for (int i = 0; i < n; i++) {
//                for (int j = 0; j < n; j++)
//                    System.out.print(map[i][j] + " ");
//                System.out.println("");
//            }

            return;
        }
        int[][] tmpMap = initMap(map);

        //위
        tmpMap = up(tmpMap);
        dfs(cnt + 1, tmpMap);
        //init
        tmpMap = initMap(map);
        //아래
        tmpMap = down(tmpMap);
        dfs(cnt + 1, tmpMap);
        //init
        tmpMap = initMap(map);
        //좌
        tmpMap = left(tmpMap);
        dfs(cnt + 1, tmpMap);
        //init
        tmpMap = initMap(map);
        //우
        tmpMap = right(tmpMap);
        dfs(cnt + 1, tmpMap);
    }

    private static int[][] right(int[][] tmpMap) {
        boolean[] tmpCheck = new boolean[n];

        for (int i = 0; i < n; i++) {
            tmpCheck = new boolean[n];
            for (int j = n - 2; j >= 0; j--) {
                int newX = j;
                if (tmpMap[i][newX] == 0) continue;
                while (true) {
                    if (newX == n - 1) break;
                    if (!tmpCheck[newX + 1] && !tmpCheck[newX] && tmpMap[i][newX + 1] == tmpMap[i][newX]) {
                        tmpMap[i][newX + 1] *= 2;
                        tmpMap[i][newX] = 0;
                        tmpCheck[newX + 1] = true;
                    } else if (tmpMap[i][newX + 1] == 0) {
                        tmpMap[i][newX + 1] = tmpMap[i][newX];
                        tmpMap[i][newX] = 0;
                    } else break;
                    newX++;
                }

            }
        }
        return tmpMap;
    }

    private static int[][] left(int[][] tmpMap) {
        boolean[] tmpCheck = new boolean[n];

        for (int i = 0; i < n; i++) {
            tmpCheck = new boolean[n];
            for (int j = 1; j < n; j++) {
                int newX = j;
                if (tmpMap[i][newX] == 0) continue;
                while (true) {
                    if (newX == 0) break;
                    if (!tmpCheck[newX - 1] && !tmpCheck[newX] && tmpMap[i][newX - 1] == tmpMap[i][newX]) {
                        tmpMap[i][newX - 1] *= 2;
                        tmpMap[i][newX] = 0;
                        tmpCheck[newX - 1] = true;
                    } else if (tmpMap[i][newX - 1] == 0) {
                        tmpMap[i][newX - 1] = tmpMap[i][newX];
                        tmpMap[i][newX] = 0;
                    } else break;
                    newX--;
                }
            }
        }
        return tmpMap;
    }

    private static int[][] down(int[][] tmpMap) {
        boolean[] tmpCheck = new boolean[n];

        for (int j = 0; j < n; j++) {
            tmpCheck = new boolean[n];
            for (int i = n - 2; i >= 0; i--) {
                int newY = i;
                if (tmpMap[newY][j] == 0) continue;
                while (true) {
                    if (newY == n - 1) break;
                    if (!tmpCheck[newY + 1] && !tmpCheck[newY] && tmpMap[newY + 1][j] == tmpMap[newY][j]) {
                        tmpMap[newY + 1][j] *= 2;
                        tmpMap[newY][j] = 0;
                        tmpCheck[newY + 1] = true;
                    } else if (tmpMap[newY + 1][j] == 0) {
                        tmpMap[newY + 1][j] = tmpMap[newY][j];
                        tmpMap[newY][j] = 0;
                    } else break;
                    newY++;
                }

            }
        }
        return tmpMap;
    }

    private static int[][] up(int[][] tmpMap) {
        boolean[] tmpCheck = new boolean[n];
        for (int j = 0; j < n; j++) {
            tmpCheck = new boolean[n];
            for (int i = 1; i < n; i++) {
                int newY = i;
                if (tmpMap[newY][j] == 0) continue;
                while (true) {
                    if (newY == 0) break;
                    if (!tmpCheck[newY - 1] && !tmpCheck[newY] && tmpMap[newY - 1][j] == tmpMap[newY][j]) {
                        tmpMap[newY - 1][j] *= 2;
                        tmpMap[newY][j] = 0;
                        tmpCheck[newY - 1] = true;
                    } else if (tmpMap[newY - 1][j] == 0) {
                        tmpMap[newY - 1][j] = tmpMap[newY][j];
                        tmpMap[newY][j] = 0;
                    } else break;
                    newY--;
                }
            }
        }
        return tmpMap;
    }

    private static void findMaxNumber(int[][] map) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (max < map[i][j]) {
                    max = map[i][j];
                }
            }
        }
    }

    private static int[][] initMap(int[][] map) {
        int[][] tmpMap = new int[n][n];

        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                tmpMap[i][j] = map[i][j];

        return tmpMap;
    }

}
