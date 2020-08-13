package programmers.kakao;

public class 문자열압축 {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.solution("xababcdcdababcdcd"));
    }
}

class Solution {
    public int solution(String s) {
        int answer = s.length();
        for (int unit = 1; unit <= s.length() / 2; unit++) {
            int cnt = 0;
            int idx = 0;
            StringBuilder sb = new StringBuilder();
            String compareStr = s.substring(idx, idx + unit);

            while (idx < s.length()) {
                idx += unit;
                if (idx + unit > s.length()) {
                    if (cnt > 0) {
                        sb.append(cnt + 1);
                    }
                    sb.append(compareStr);
                    sb.append(s.substring(idx));
                    break;
                }
                String targetStr = s.substring(idx, idx + unit);
                if (compareStr.equals(targetStr)) {
                    cnt++;
                    continue;
                }
                //다름
                if (cnt > 0) {
                    sb.append(cnt + 1);
                    sb.append(compareStr);
                } else {
                    sb.append(compareStr);
                }
                compareStr = targetStr;
                cnt = 0;

            }
            answer = Math.min(answer, sb.length());
        }
        return answer;
    }
}