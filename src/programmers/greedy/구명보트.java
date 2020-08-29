package programmers.greedy;

import java.util.Arrays;

public class 구명보트 {
    public static void main(String[] args) {

    }

    class Solution {
        public int solution(int[] people, int limit) {
            Arrays.sort(people);
            int answer = 0;
            int index = people.length - 1;
            for (int i = 0; i < people.length; i++, answer++) {
                while (index > i && people[i] + people[index--] > limit)
                    answer++;
            }
            return answer;
        }
    }
}