package programmers.bp;


public class 숫자야구 {
    public static void main(String[] args) {
        int[][] baseball = {{123, 1, 1}, {356, 1, 0}, {327, 2, 0}, {489, 0, 1}};
        숫자야구_Solution solution = new 숫자야구_Solution();
        System.out.print(solution.solution(baseball));
    }
}

class 숫자야구_Solution {
    int answer = 0;
    public int solution(int[][] baseball) {
        int[] out = new int[3];
        boolean[] visited = new boolean[9];
        numberBaseball(0, out, visited, 0, baseball);

        return answer;
    }
    private void numberBaseball(int depth, int[] out, boolean[] visited, int idx, int[][] baseball) {
        if (depth == 3) {
            if (checkCondition(out, baseball))
                answer++;
            return;
        }
        for (int i = 0; i < 9; i++) {
            if (!visited[i]) {
                visited[i] = true;
                out[idx] = i + 1;
                numberBaseball(depth + 1, out, visited, idx + 1, baseball);
                visited[i] = false;
            }
        }
    }

    private boolean checkCondition(int[] num, int[][] baseball) {
        boolean result = true;
        for (int i = 0; i < baseball.length; i++) {
            int strike = baseball[i][1];
            int ball = baseball[i][2];
            String baseBallStr = Integer.toString(baseball[i][0]);

            //strike 조건찾기
            int strikeCnt = 0;
            for (int j = 0; j < 3; j++) {
                if (num[j] == baseBallStr.charAt(j) - '0')
                    strikeCnt++;
            }
            if (strike != strikeCnt) {
                result = false;
                break;
            }
            // ball 조건 찾기
            int ballCnt = 0;
            if (num[0] == baseBallStr.charAt(1) - '0' || num[0] == baseBallStr.charAt(2) - '0')
                ballCnt++;
            if (num[1] == baseBallStr.charAt(0) - '0' || num[1] == baseBallStr.charAt(2) - '0')
                ballCnt++;
            if (num[2] == baseBallStr.charAt(0) - '0' || num[2] == baseBallStr.charAt(1) - '0')
                ballCnt++;
            if (ball != ballCnt) {
                result = false;
                break;
            }
        }
        return result;
    }
}