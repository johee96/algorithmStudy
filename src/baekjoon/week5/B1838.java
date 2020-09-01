package baekjoon.week5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/*
todo 다시풀기
버블정렬의 특징
    - 가장 큰 값이 차례대로 맨 뒤로 이동한다.
 */
public class B1838 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        PriorityQueue<Data> data = new PriorityQueue<>();
        int result = 0;

        //input
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            long v = Long.parseLong(st.nextToken());
            data.add(new Data(v, i));
        }

        int index = 0;
        while (!data.isEmpty()) {
            Data d = data.poll();
            if (result < d.index - index) {
                result = d.index - index;
            }
            index++;
        }

        System.out.print(result);
    }

    static class Data implements Comparable<Data> {
        Long value;
        int index;

        public Data(Long value, int index) {
            this.index = index;
            this.value = value;
        }

        @Override
        public int compareTo(Data o) {
            return this.value - o.value > 0 ? 1 : -1;
        }
    }
}


