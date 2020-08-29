package programmers.dfs_bfs;

public class 비밀지도 {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] a = {9, 20, 28, 18, 11};
        int[] b = {30, 1, 21, 17, 28};
        s.solution(5, a, b);
    }
}

class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        for (int i = 0; i < n; i++) {
            String binaryArr1Str = Integer.toBinaryString(arr1[i]);
            String binaryArr2Str = Integer.toBinaryString(arr2[i]);

            String zero = "0";
            if (binaryArr1Str.length() < n) {
                binaryArr1Str = zero.repeat(n - binaryArr1Str.length()) + binaryArr1Str;
            }
            if (binaryArr2Str.length() < n) {
                binaryArr2Str = zero.repeat(n - binaryArr2Str.length()) + binaryArr2Str;
            }

            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < n; j++) {
                int v = (binaryArr1Str.charAt(j) - '0') + (binaryArr2Str.charAt(j) - '0');
                if (v == 0)
                    sb.append(" ");
                else
                    sb.append("#");
            }
            answer[i] = sb.toString();
        }
        return answer;
    }
}