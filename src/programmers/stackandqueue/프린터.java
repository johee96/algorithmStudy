package programmers.stackandqueue;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class 프린터 {
    public static void main(String[] args) {
        프린터_Solution sol = new 프린터_Solution();
        int[] priorities = {1, 1, 9, 1, 1, 1};
        int location = 0;
        System.out.println(sol.solution(priorities, location));
    }
}

class 프린터_Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        int[] answerSeq = new int[priorities.length];
        int idx = 0;

        Queue<Integer> pQueue = new LinkedList<>();
        for (int i = 0; i < priorities.length; i++) {
            pQueue.add(i);
        }
        while (!pQueue.isEmpty()) {
            int tmp = pQueue.poll();
            boolean push = false;

            Iterator<Integer> iter = pQueue.iterator();
            while(iter.hasNext()){
                if(priorities[tmp] < priorities[iter.next()]){
                    pQueue.add(tmp);
                    push = true;
                    break;
                }
            }
            if (!push) {
                answerSeq[idx] = tmp;
                idx++;
            }
        }
        for (int i = 0; i < answerSeq.length; i++) {
            if (location == answerSeq[i]) {
                answer = i;
                break;
            }
        }
        return answer+1;
    }
}