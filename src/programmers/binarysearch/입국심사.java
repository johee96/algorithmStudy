package programmers.binarysearch;

import java.util.Arrays;

public class 입국심사 {
    public static void main(String[] args) {
        입국심사_Solution sol = new 입국심사_Solution();
        int[] data = {10, 4, 9, 5};
        System.out.print(sol.solution(10, data));
    }
}

class 입국심사_Solution {
    public long solution(int n, int[] times) {
        long answer = 0;
        Arrays.sort(times);
        long maxTime = n * (long) times[times.length - 1];
        long minTime = 1;
        long midTime = 0;

        answer = maxTime;

        while (true) {
            if (minTime > maxTime)
                break;
            midTime = (minTime + maxTime) / 2;
            long cnt = count(times, midTime);
            if (cnt >= n) {
                answer = Math.min(midTime, answer);
                maxTime = midTime - 1;
            } else {
                minTime = midTime + 1;
            }
        }
        return answer;
    }

    long count(int[] times, long mid) {
        long result = 0;
        for (int i = 0; i < times.length; i++) {
            result += (mid / times[i]);
        }
        return result;

    }
}
