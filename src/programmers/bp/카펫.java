package programmers.bp;

public class 카펫 {
    public static void main(String[] args) {

    }

    class 카펫_Solution {
        public int[] solution(int brown, int red) {
            int[] answer = new int[2];
            int total = brown + red;

            for (int i = 3; i <= total / 3; i++) {
                if (total % i == 0) {
                    int a = i;
                    int b = total / i;
                    if ((a - 2) * (b - 2) == red) {
                        answer[0] = Math.max(a, b);
                        answer[1] = Math.min(a, b);
                    }
                }
            }
            return answer;
        }
    }
}
