package programmers.sort;

import java.util.Arrays;

public class HIndex {
    public static void main(String[] args) {
        HIndex_Solution sol = new HIndex_Solution();
        int[] arr = {1,18,19,20};
        int re = sol.solution(arr);

        System.out.println(re);
    }
}

class HIndex_Solution {
    public int solution(int[] citations) {
        int answer = 0;
        int size = citations.length;
        Arrays.sort(citations);

        for (int i = 0; i < size; i++) {
            int ci = size - i - 1;  //citations[i]회 이상 인용한 논문의 수
            if (ci < citations[i]) {
                answer = ci + 1;
                break;
            }
        }
        return answer;
    }

}
