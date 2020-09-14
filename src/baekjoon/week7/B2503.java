package baekjoon.week7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B2503 {
    static Question[] questions;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        questions = new Question[n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int[] v = new int[3];
            String strV = st.nextToken();
            for (int j = 0; j < 3; j++) {
                v[j] = strV.charAt(j) - '0';
            }
            questions[i] = (new Question(v, Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }

        int re = 0;
        for (int i = 123; i <= 987; i++) {
            String s = String.valueOf(i);
            int a = s.charAt(0) - '0';
            int b = s.charAt(1) - '0';
            int c = s.charAt(2) - '0';

            if (a == b || b == c || c == a || (a == 0 || b == 0 || c == 0)) {
                continue;
            }
            if (isPossible(s)) re++;
        }
        System.out.println(re);
    }

    static private boolean isPossible(String str) {
        boolean result = true;

        for (int i = 0; i < questions.length; i++) {
            Question q = questions[i];
            int strike = 0;
            int ball = 0;
            for (int j = 0; j < 3; j++) {
                for (int k = 0; k < 3; k++) {
                    if (q.value[j] == str.charAt(k) - '0') {
                        if (k == j) strike++;
                        else ball++;
                    }
                }
            }
            if (ball != q.ball || strike != q.strike) return false;
        }


        return result;
    }


    static class Question {
        int[] value;
        int strike;
        int ball;

        public Question(int[] value, int strike, int ball) {
            this.value = value;
            this.strike = strike;
            this.ball = ball;
        }
    }
}
