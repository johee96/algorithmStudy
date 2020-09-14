package baekjoon.week7;

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
        long m = Integer.parseInt(st.nextToken());
        long[] trees = new long[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            trees[i] = Long.parseLong(st.nextToken());
        }
        Arrays.sort(trees);
        System.out.println(countTree(trees, m));
    }

    private static long countTree(long[] trees, long m) {
        long low = 0;
        long high = trees[trees.length - 1];
        long mid;
        long ans = 0;
        while (low <= high) {
            mid = (low + high) / 2;
            long value = divTree(mid, trees);
            if (value >= m) {
                ans = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return ans;
    }

    private static long divTree(long h, long[] trees) {
        long result = 0;
        for (int i = 0; i < trees.length; i++) {
            if (trees[i] > h)
                result += trees[i] - h;
        }
        return result;
    }
}
