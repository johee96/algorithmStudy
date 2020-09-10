package baekjoon.week6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

//todo : 정리하면 좋을 듯 https://brocess.tistory.com/185
public class B1764 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        Set<String> hear = new HashSet<>();
        ArrayList<String> hearAndSee = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            hear.add(br.readLine());
        }

        for (int i = 0; i < m; i++) {
            String value = br.readLine();
            if (hear.contains(value))
                hearAndSee.add(value);
        }
        Collections.sort(hearAndSee);

        System.out.println(hearAndSee.size());
        for (String str : hearAndSee) {
            System.out.println(str);
        }
    }
}
