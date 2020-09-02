package baekjoon.week5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// result type은 long!!!
public class B1202 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        PriorityQueue<Jewelry> jewelries = new PriorityQueue<>();
        int[] bags = new int[k];
        long result = 0;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int m = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            jewelries.add(new Jewelry(m, v));
        }
        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            bags[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(bags);
        PriorityQueue<Integer> priceQueue = new PriorityQueue<>(Comparator.reverseOrder());

        for (int i = 0; i < k; i++) {
            int bag = bags[i];
            while (!jewelries.isEmpty() && bag >= jewelries.peek().weight) {
                priceQueue.add(jewelries.poll().price);
                if (jewelries.isEmpty())
                    break;
            }
            if (!priceQueue.isEmpty())
                result += (long) priceQueue.poll();

        }
        System.out.print(result);


    }

    private static class Jewelry implements Comparable<Jewelry> {
        int weight;
        int price;

        public Jewelry(int weight, int price) {
            this.weight = weight;
            this.price = price;
        }

        @Override
        public int compareTo(Jewelry o) {
            if (this.weight > o.weight)
                return 1;
            else if (this.weight == o.weight)
                return o.price - this.price;
            return -1;
        }
    }
}
