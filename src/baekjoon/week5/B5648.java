package baekjoon.week5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class B5648 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        ArrayList<Long> data = new ArrayList<>();
        while (true) {
            while (st.hasMoreTokens()) {
                Long value = reverseValue(st.nextToken());
                data.add(value);
                n--;
            }
            if (n == 0)
                break;
            st = new StringTokenizer(br.readLine());
        }

        Collections.sort(data);
        for (int i = 0; i < data.size(); i++)
            System.out.println(data.get(i));

    }

    //원소를 거꾸로 뒤집기
    private static Long reverseValue(String value) {
        StringBuilder reStr = new StringBuilder();
        for (int i = value.length() - 1; i >= 0; i--) {
            reStr.append(value.charAt(i));
        }
        Long result = Long.parseLong(reStr.toString());

        return result;
    }
}
