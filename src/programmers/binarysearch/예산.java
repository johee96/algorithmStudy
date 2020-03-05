package programmers.binarysearch;

import java.util.Arrays;

public class 예산 {
    public static void main(String[] args) {
        예산_Solution s = new 예산_Solution();
        int[] data = {120, 110, 140, 100};
        int m = 400;
        System.out.print(s.solution(data, m));
    }
}

class 예산_Solution {
    static int re = -1;

    public int solution(int[] budgets, int M) {
        Arrays.sort(budgets);

        int answer = 0;
        long sum = sumData(budgets, budgets[budgets.length - 1]);
        if (sum <= M)
            return budgets[budgets.length - 1];

        search(budgets, 0, budgets[budgets.length - 1], M);
        answer = re;
        return answer;
    }

    static void search(int[] data, int start, int end, int m) {
        if (start > end)
            return;

        int mid = (start + end) / 2;
        long sum = sumData(data, mid);
        if (sum > m) {
            search(data, start, mid - 1, m);
        } else {
            re = Math.max(re, mid);
            search(data, mid + 1, end, m);
        }
        return;

    }

    static long sumData(int[] data, int target) {
        long result = 0;
        for (int i = 0; i < data.length; i++) {
            if (data[i] >= target)
                result += target;
            else
                result += data[i];
        }
        return result;
    }
}