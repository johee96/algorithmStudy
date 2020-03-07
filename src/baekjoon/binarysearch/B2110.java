package baekjoon.binarysearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B2110 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        long[] data = new long[n];
        for (int i = 0; i < n; i++) {
            data[i] = Long.parseLong(br.readLine());
        }
        Arrays.sort(data);

        long low = 0;
        long high = data[data.length - 1] - data[0];
        long mid = 0;
        long ans = 0;
        while (true) {
            long cnt = 0;
            if (low > high) {
                break;
            }
            mid = (low + high) / 2;
            long start = data[0];
            for (int i = 1; i < n; i++) {
                if (data[i] - start >= mid) {
                    cnt++;
                    start = data[i];
                }
            }

            if (cnt >= c-1) {
                low = mid + 1;
                ans = Math.max(ans, mid);
            } else {
                high = mid - 1;
            }
        }
        System.out.print(ans);
    }
}
