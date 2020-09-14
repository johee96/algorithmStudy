package baekjoon.week7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class B10816 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        HashMap<Integer, Integer> map = new HashMap<>();
        while (st.hasMoreTokens()) {
            int v = Integer.parseInt(st.nextToken());
            if (map.containsKey(v))
                map.put(v, map.get(v) + 1);
            else
                map.put(v, 1);
        }
        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        while (st.hasMoreTokens()) {
            int v = Integer.parseInt(st.nextToken());
            if (map.containsKey(v))
                System.out.print(map.get(v) + " ");
            else
                System.out.print(0 + " ");

        }

    }
}
