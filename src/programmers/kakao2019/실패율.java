package programmers.kakao2019;

import java.util.ArrayList;
import java.util.Collections;

public class 실패율 {
    class Solution {
        public int[] solution(int N, int[] stages) {
            int[] answer = new int[N];

            int[] data = new int[N + 1];
            int size = stages.length;
            ArrayList<Fail> fails = new ArrayList<>();
            for (int i = 0; i < stages.length; i++) {
                if (stages[i] <= N)
                    data[stages[i]]++;
            }
            for (int i = 1; i <= N; i++) {
                double v;
                if (size == 0)
                    v = 0;
                else
                    v = (double) data[i] / size;

                fails.add(new Fail(i, v));
                size -= data[i];
            }
            Collections.sort(fails);
            for (int i = 0; i < N; i++) {
                answer[i] = fails.get(i).idx;
            }
            return answer;
        }
    }

    class Fail implements Comparable<Fail> {
        int idx;
        double value;

        public Fail(int idx, double value) {
            this.idx = idx;
            this.value = value;
        }

        @Override
        public int compareTo(Fail o) {
            if (this.value == o.value)
                return this.idx - o.idx;
            return this.value < o.value ? 1 : -1;
        }
    }
}
