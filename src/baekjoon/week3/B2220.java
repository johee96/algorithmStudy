package baekjoon.week3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B2220 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] heap = new int[n + 1];
        for (int i = 2; i <= n; i++) {
            heap[i - 1] = i;
            int j = i - 1;
            //swap
            while (j > 1) {
                int tmp = heap[j / 2];
                heap[j / 2] = heap[j];
                heap[j] = tmp;
                j = j / 2;
            }
        }
        heap[n] = 1;
        for (int i = 1; i <= n; i++) {
            System.out.print(heap[i] + " ");
        }
    }
}
