package baekjoon.binarysearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B1654 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int k = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        long[] data = new long[k];

        for (int i = 0; i < k; i++) {
            data[i] = Long.parseLong (br.readLine());
        }
        Arrays.sort(data);

        long low = 1;
        long high = data[data.length - 1];
        long mid = 0;
        long answer = 0;
        while (true) {
            if (low > high) {
                break;
            }
            mid = (low + high) / 2;
            if (countLine(data, mid) >= n) {
                answer = Math.max(mid,answer) ;
                low = mid + 1;
            } else {
                high = mid - 1;
            }

        }
        System.out.print(answer);
    }

    static long countLine(long[] data, long mid) {
        long result = 0;
        for (int i = 0; i < data.length; i++) {
            result += data[i] / mid;
        }
        return result;
    }
}
