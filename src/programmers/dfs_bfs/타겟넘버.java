package programmers.dfs_bfs;

public class 타겟넘버 {
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Solution sol = new Solution();
        int numbers[] = {1, 1, 1, 1, 1};
        int re = sol.solution(numbers, 3);
        System.out.println(re);
    }

    static class Solution {
        int answer = 0;

        public int solution(int[] numbers, int target) {
            dfs(numbers, target, 0, 0);
            return answer;
        }

        private void dfs(int[] numbers, int target, int tmpNum, int index) {
            if (index >= numbers.length) {
                if (tmpNum == target)
                    answer++;
                return;
            }
            dfs(numbers, target, tmpNum + numbers[index], index + 1);
            dfs(numbers, target, tmpNum + numbers[index] * -1, index + 1);
        }
    }
}
