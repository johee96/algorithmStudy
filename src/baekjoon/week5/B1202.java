package baekjoon.week5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class B1202 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        PriorityQueue<Jewelry> jewelries = new PriorityQueue<>();
        int[] bags = new int[k];
        long result = 0;        //result type은 long으로 해야 함

        //input
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
        PriorityQueue<Integer> priceQueue = new PriorityQueue<>(Comparator.reverseOrder()); //보석의 가격을 넣는 큐(내림차순)

        for (int i = 0; i < k; i++) {
            int bag = bags[i];
            while (!jewelries.isEmpty() && bag >= jewelries.peek().weight) {
                priceQueue.add(jewelries.poll().price);     //해당 가방에 들어갈 수 있는 보석들
                if (jewelries.isEmpty())
                    break;
            }
            if (!priceQueue.isEmpty())
                result += (long) priceQueue.poll(); //해당 가방에 들어갈 수 있는 가장 큰 보석의 가격

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

        //무게를 기준으로 오름차순, 만약 같은 경우 가격을 기준으로 내림차순
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
