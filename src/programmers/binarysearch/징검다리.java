package programmers.binarysearch;

import java.util.Arrays;

public class 징검다리 {
    public static void main(String[] args) {
        징검다리_Solution sol = new 징검다리_Solution();
        int[] data = {2, 14, 11, 21, 17};
        System.out.print(sol.solution(25, data, 2));
    }
}

class 징검다리_Solution {

    int removeRocks(int distance, int[] rocks, int mid) {
        int result = 0;
        int last = 0;

        for (int i = 0; i <= rocks.length; i++) {
            int gap = (i != rocks.length ? rocks[i] - last : distance - last);
            if (gap < mid) {
                result++;
            } else {
                if (i == rocks.length)
                    break;
                last = rocks[i];
            }
        }
        return result;
    }

    public int solution(int distance, int[] rocks, int n) {
        int answer = 0;
        int low = 1;
        int high = distance;
        int mid = 0;
        Arrays.sort(rocks);
        while (true) {
            if (low > high) {
                break;
            }
            mid = (low + high) / 2;
            if (removeRocks(distance, rocks, mid) > n) {
                high = mid - 1;
            } else {
                answer = mid;
                low = mid + 1;
            }
        }

        return answer;
    }
}