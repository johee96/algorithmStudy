package programmers.stackandqueue;

import java.util.Stack;

public class 탑 {
    public static void main(String[] args) {
        탑_Solution sol = new 탑_Solution();
        int[] data = {6, 9, 5, 7, 4};
        int[] result = sol.solution(data);
        for (int re : result) {
            System.out.print(re + " ");
        }
    }
}

class 탑_Solution {
    public int[] solution(int[] heights) {
        int[] answer = {};
        answer = new int[heights.length];
        Stack<Integer> heightStack = new Stack<>();
        for(int h : heights){
            heightStack.push(h);
        }
        while(!heightStack.isEmpty()){
            int tmp = heightStack.pop();
            for(int i = heightStack.size(); i>=0;i--){
                if(tmp<heights[i]){
                    answer[heightStack.size()] = i+1;
                    break;
                }
            }
        }
        return answer;
    }
}
