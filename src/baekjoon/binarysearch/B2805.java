package baekjoon.binarysearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B2805 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        long m = Long.parseLong(st.nextToken());
        long[] data = new long[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            data[i] = Long.parseLong(st.nextToken());
        }
        Arrays.sort(data);
        long low = 1;
        long high = data[data.length - 1];
        long mid = 0;
        long ans = 0;
        while (true) {
            if (low > high) {
                break;
            }
            mid = (low + high) / 2;
            if (cal(data, mid) >= m) {
                ans = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        System.out.print(ans);

    }

    static long cal(long[] data, long mid) {
        long re = 0;
        for (int i = 0; i < data.length; i++) {
            if (data[i] > mid)
                re += data[i] - mid;
        }
        return re;
    }
}
