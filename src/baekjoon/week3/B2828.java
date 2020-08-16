package baekjoon.week3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B2828 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int j = Integer.parseInt(br.readLine());

        int dist = 0;
        int start = 1;
        int end = start + m - 1;
        for (int i = 0; i < j; i++) {
            int value = Integer.parseInt(br.readLine());
            if (start <= value && end >= value) continue;

            if (value > end) {
                dist += value - end;
                end = value;
                start = end - m + 1;
            } else {
                dist += start - value;
                start = value;
                end = start + m - 1;
            }
        }
        System.out.println(dist);

    }
}
