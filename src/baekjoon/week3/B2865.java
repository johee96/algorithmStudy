package baekjoon.week3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B2865 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        double[] data = new double[n + 1];

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            while (st.hasMoreTokens()) {
                int idx = Integer.parseInt(st.nextToken());
                double value = Double.parseDouble(st.nextToken());
                data[idx] = Math.max(data[idx], value);
            }
        }

        Arrays.sort(data);
        double sum = 0;
        for (int i = data.length - 1; i >= data.length - k; i--)
            sum += data[i];
        System.out.println(String.format("%.1f", sum));
    }
}
