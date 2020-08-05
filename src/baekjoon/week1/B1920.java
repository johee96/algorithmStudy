package baekjoon.week1;

import java.util.Arrays;
import java.util.Scanner;

public class B1920 {
    static int[] data;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        data = new int[n];
        for (int i = 0; i < n; i++) {
            data[i] = sc.nextInt();
        }
        int m = sc.nextInt();
        int[] num = new int[m];
        for (int i = 0; i < m; i++) {
            num[i] = sc.nextInt();
        }
        Arrays.sort(data);
        for (int i = 0; i < m; i++) {
            findNum(num[i]);
        }
    }

    private static void findNum(int num) {
        int left = 0;
        int right = data.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (data[mid] == num) {
                System.out.println(1);
                return;
            } else if (data[mid] > num) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        System.out.println(0);
    }
}
