package programmers.greedy;
public class 체육복 {
    public static void main(String[] args) {

    }

    class Solution {
        public int solution(int n, int[] lost, int[] reserve) {
            int answer = 0;
            int[] data = new int[n];
            for (int i = 0; i < lost.length; i++) {
                data[lost[i] - 1] = -1;
            }
            for (int i = 0; i < reserve.length; i++) {
                if (data[reserve[i] - 1] == -1) {
                    data[reserve[i] - 1] = 0;
                } else {
                    data[reserve[i] - 1] = 1;
                }
            }

            for (int i = 0; i < n; i++) {
                if (data[i] == -1) {
                    if (i - 1 >= 0 && data[i - 1] == 1) {
                        answer++;
                        data[i - 1]--;
                    } else if (i + 1 < n && data[i + 1] == 1) {
                        answer++;
                        data[i + 1]--;
                    }
                    continue;
                }
                answer++;
            }
            return answer;
        }
    }

}
