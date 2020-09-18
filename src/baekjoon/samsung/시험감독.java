package baekjoon.samsung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 시험감독 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] data = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++)
            data[i] = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int supervise = Integer.parseInt(st.nextToken());
        int subSupervise = Integer.parseInt(st.nextToken());

        long result = n;
        for (int i = 0; i < n; i++) {
            double d = data[i] - supervise;
            if (d <= 0) { //감독관으로 충분
                continue;
            }
            //  result += Math.ceil(d / subSupervise);
            result += d / subSupervise;
            if (d % subSupervise > 0)
                result += 1;
        }
        System.out.print(result);
    }
}
