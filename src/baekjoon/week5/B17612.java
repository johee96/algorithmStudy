package baekjoon.week5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class B17612 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        long result = 0;        //결과값
        int inputCnt = n;       //입력받아야하는 input(손님)의 수 (n부터 줄여나감)
        int outputIdx = 1;      //쇼핑몰을 빠져나가는 순서

        PriorityQueue<Customer> customerQueue = new PriorityQueue<>();      //고객을 넣는 큐
        PriorityQueue<Integer> counterQueue = new PriorityQueue<>();        //카운터번호를 넣는 큐(비어있는 카운터)

        //1. 먼저 전부 비어있는 카운터에 고객 넣기
        for (int i = 0; i < k; i++) {
            if (inputCnt == 0)
                break;
            st = new StringTokenizer(br.readLine());
            int cId = Integer.parseInt(st.nextToken());
            int cW = Integer.parseInt(st.nextToken());
            customerQueue.add(new Customer(cId, cW, i + 1));
            inputCnt--;
        }

        while (!customerQueue.isEmpty()) {
            Customer out;
            while (true) { //손님 나감
                out = customerQueue.poll();
                result += outputIdx * (long) out.id;
                counterQueue.add(out.counterNum);
                outputIdx++;

                if (customerQueue.isEmpty() || customerQueue.peek().w != out.w)     //같은 시간에 끝나는 고객이 없으면 break
                    break;
            }

            //비어있는 카운터에 고객 넣기
            while (customerQueue.size() < k && inputCnt > 0) {
                st = new StringTokenizer(br.readLine());
                int cId = Integer.parseInt(st.nextToken());
                int cW = Integer.parseInt(st.nextToken());
                customerQueue.add(new Customer(cId, cW + out.w, counterQueue.poll()));
                inputCnt--;
            }
            
        }

        System.out.print(result);

    }

    static class Customer implements Comparable<Customer> {
        int id;
        int w;
        int counterNum;

        public Customer(int id, int w, int counterNum) {
            this.id = id;
            this.w = w;
            this.counterNum = counterNum;
        }

        @Override
        public int compareTo(Customer o) {
            if (this.w > o.w)
                return 1;
            else if (this.w == o.w)
                if (this.counterNum < o.counterNum)
                    return 1;

            return -1;

        }
    }
}