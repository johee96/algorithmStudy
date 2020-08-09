package baekjoon.week2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class B1966 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int tc = Integer.parseInt(st.nextToken());
        for (int i = 0; i < tc; i++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            Queue<Data> queue = new LinkedList<>();
            Data[] data = new Data[n];

            String readLine = br.readLine();
            st = new StringTokenizer(readLine);

            for (int j = 0; j < n; j++) {
                Data d = new Data(j, Integer.parseInt(st.nextToken()));
                data[j] = d;
                queue.add(d);

            }
            Arrays.sort(data, Comparator.reverseOrder());
            int result = 0;
            int idx = 0;
            while (!queue.isEmpty()) {
                Data pollData = queue.poll();
                if (pollData.value == data[idx].value) {
                    result++;
                    idx++;
                    if (pollData.order == m) {
                        break;
                    }
                } else {
                    queue.add(pollData);
                }
            }
            System.out.println(result);
        }
    }

    static class Data implements Comparable<Data> {
        int order;
        int value;

        public Data(int order, int value) {
            this.order = order;
            this.value = value;
        }

        @Override
        public int compareTo(Data o) {
            return this.value - o.value;
        }
    }
}
