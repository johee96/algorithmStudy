package swexpert.D2;

import java.util.Arrays;
import java.util.Scanner;

public class 최빈수구하기_SW1204 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();
        for (int k = 1; k <= tc; k++) {
            int t = sc.nextInt();
            int map[] = new int[101];
            for (int i = 0; i < 1000; i++) {
                int v = sc.nextInt();
                map[v]++;
            }
            int maxValue = findMax(map);
            System.out.println("#" + t + " " + maxValue);
        }
    }

    private static int findMax(int map[]) {
        int maxIndex = -1;
        int maxValue = -1;
        for (int i = 0; i < 100; i++) {
            if (maxValue < map[i]) {
                maxValue = map[i];
                maxIndex = i;
            }
        }
        return maxIndex;
    }
}
