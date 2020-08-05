package programmers.sort;

import java.util.Stack;

public class 크레인인형뽑기게임 {
    public static void main(String[] args) {
        int[][] b = {{0, 0, 0, 0, 0}, {0, 0, 1, 0, 3}, {0, 2, 5, 0, 1}, {4, 2, 4, 4, 2}, {3, 5, 1, 3, 1}};
        int[] moves = {1, 5, 3, 5, 1, 2, 1, 4};
        Solution s = new Solution();
        System.out.println(s.solution(b, moves));
    }

    static class Solution {
        public int solution(int[][] board, int[] moves) {
            int answer = 0;
            Stack<Integer> stack = new Stack<>();
            int n = board.length;
            for (int i = 0; i < moves.length; i++) {
                int idx = moves[i] - 1;
                int popValue = 0;
                for (int j = 0; j < n; j++) {
                    if (board[j][idx] != 0) {
                        popValue = board[j][idx];
                        board[j][idx] = 0;
                        break;
                    }
                }
                if (popValue == 0)
                    continue;
                if (stack.size() == 0) {
                    stack.push(popValue);
                    continue;
                }
                if (stack.peek() == popValue) {
                    stack.pop();
                    answer += 2;
                } else {
                    stack.push(popValue);
                }
            }
            return answer;
        }
    }
}
