package programmers.heep;

import java.util.Comparator;
import java.util.PriorityQueue;

public class 라면공장 {
    public static void main(String[] args) {
// TODO Auto-generated method stub
        라면공장_Solution sol = new 라면공장_Solution();
        int[] dates = {4, 10, 15};
        int[] supplies = new int[]{20, 5, 10};

        int re = sol.solution(4, dates, supplies, 30);
        System.out.println(re);
    }
}

class 라면공장_Solution {
    public int solution(int stock, int[] dates, int[] supplies, int k) {
        int answer = 0;
        int idx = 0;
        PriorityQueue<Integer> pQueue = new PriorityQueue<>(Comparator.reverseOrder());
        while (stock<k){
            while(idx<dates.length && dates[idx] <= stock){
                pQueue.add(supplies[idx]);
                idx++;
            }
            stock+=pQueue.poll();
            answer++;
        }
       return answer;
    }
}