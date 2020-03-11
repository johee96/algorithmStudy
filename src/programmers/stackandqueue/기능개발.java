package programmers.stackandqueue;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class 기능개발 {
    public static void main(String[] args) {
        기능개발_Solution s = new 기능개발_Solution();
        int[] progresses = {93, 30, 55};
        int[] speeds = {1, 30, 5};
        int[] result = s.solution(progresses, speeds);
        for (int re : result) {
            System.out.print(re + " ");
        }
    }
}
class 기능개발_Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        int[] answer = {};
        ArrayList<Integer> answerList = new ArrayList<>();
        Queue<Integer> days = new LinkedList<>();
        for (int i = 0; i < progresses.length; i++) {
            int gap = 100 - progresses[i];
            days.add((int) Math.ceil((double) gap / speeds[i]));
        }
        int idx = 0;
        int cnt = 1;
        int target = days.poll();
        while(!days.isEmpty()){
            int tmp = days.poll();
            if(target>=tmp){
                cnt++;
            }else{
                answerList.add(cnt);
                cnt = 1;
                target = tmp;
            }
        }
        answerList.add(cnt);
        answer = new int[answerList.size()];
        for (int v : answerList){
            answer[idx] = v;
            idx++;
        }
        return answer;
    }
}