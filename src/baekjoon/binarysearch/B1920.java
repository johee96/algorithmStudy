package baekjoon.binarysearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

import java.util.StringTokenizer;

public class B1920 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] dataA = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            dataA[i] = Integer.parseInt(st.nextToken());
        }

        int m = Integer.parseInt(br.readLine());

        int[] dataB = new int[m];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            dataB[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(dataA);

        for (int i = 0; i < m; i++) {
            int low = 0;
            int high = dataA.length - 1;
            int mid = 0;
            while (true) {
                if (low > high) {
                    System.out.println(0);
                    break;
                }
                mid = (low + high) / 2;
                if (dataA[mid] == dataB[i]) {
                    System.out.println(1);
                    break;
                } else if (dataA[mid] > dataB[i]) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }
        }

    }
}
