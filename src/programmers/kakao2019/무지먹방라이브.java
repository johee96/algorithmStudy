package programmers.kakao2019;

import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;

public class 무지먹방라이브 {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] d = {3, 1, 2};
        System.out.println(s.solution(d, 5));
    }

    static class Solution {
        public int solution(int[] food_times, long k) {
            int answer = 0;
            long passedTime = 0;
            long removeTime = 0;
            PriorityQueue<Food> foodItems = new PriorityQueue<>();
            for (int i = 1; i <= food_times.length; i++)
                foodItems.add(new Food(i, food_times[i - 1]));

            while (!foodItems.isEmpty()) {
                long peekTime = foodItems.peek().time - removeTime;
                long total = foodItems.size() * peekTime;
                if (total <= k - passedTime) {
                    while (!foodItems.isEmpty() && foodItems.peek().time - removeTime == peekTime)
                        foodItems.poll();
                    passedTime += total;
                    removeTime += peekTime;
                    continue;
                }
                break;
            }

            if (foodItems.isEmpty())
                return -1;

            ArrayList<Food> foodList = new ArrayList<>(foodItems);
            Collections.sort(foodList, (o1, o2) -> o1.idx - o2.idx);
            int remainTime = (int) ((k - passedTime) % foodItems.size());
            answer = foodList.get(remainTime).idx;

            return answer;
        }

        class Food implements Comparable<Food> {
            int idx;
            long time;

            public Food(int idx, long time) {
                this.idx = idx;
                this.time = time;
            }

            @Override
            public int compareTo(Food o) {
                if (o.time == this.time)
                    return o.idx - this.idx;
                return o.time < this.time ? 1 : -1;
            }
        }
    }
}
