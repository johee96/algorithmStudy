package baekjoon.binarysearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B12015 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] data = new int[n];
        int[] list = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            data[i] = Integer.parseInt(st.nextToken());
        }
        list[0] = data[0];
        int idx = 0;
        for (int i = 1; i < n; i++) {
            if (list[idx] < data[i]) {
                idx++;
                list[idx] = data[i];
            } else {
                int lower = getLowerBound(data[i], idx, list);
                list[lower] = data[i];
            }
        }
        System.out.print(idx + 1);
    }

    //lowerbound 이용.
    private static int getLowerBound(int data, int idx, int[] list) {
        int low = 0;
        int high = idx + 1;
        while (low < high) {
            int mid = (low + high) / 2;
            if (list[mid] < data) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return high;
    }
}

//https://jason9319.tistory.com/113