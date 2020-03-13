package programmers.stackandqueue;

import java.util.Stack;

public class 쇠막대기 {
    public static void main(String[] args) {
        쇠막대기_Solution sol = new 쇠막대기_Solution();
        System.out.print(sol.solution("()(((()())(())()))(())"));
    }
}
class 쇠막대기_Solution {
    public int solution(String arrangement) {
        int answer = 0;
        arrangement = arrangement.replace("()","*");
        String[] arrangementArr= arrangement.split("");
        Stack<String> stack = new Stack<>();
        for(int i=0;i<arrangementArr.length;i++){
            String tmp = arrangementArr[i];
            if(tmp.equals("(")){
                stack.push("(");
            }else if(tmp.equals("*")){
                answer+=stack.size();
            }else{
                answer++;
                stack.pop();
            }
        }
        return answer;
    }
}