package programmers.stackandqueue;

import java.util.LinkedList;
import java.util.Queue;

public class 다리를지나는트럭 {
    public static void main(String[] args) {
        다리를지나는트럭_Solution sol = new 다리를지나는트럭_Solution();
        int[] data = {7, 4, 5, 6};
        System.out.print(sol.solution(2, 10, data));
    }
}

class 다리를지나는트럭_Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        int[] endTime = new int[truck_weights.length];
        Queue<Integer> bridge = new LinkedList<>();
        int totalTime=0;
        int index = 0;
        while (true){
            //도착한 버스 제거
            if(!bridge.isEmpty() && endTime[bridge.peek()] == totalTime){
                weight+=truck_weights[bridge.poll()];
            }
            //대기하는 버스 추가
           if(index<truck_weights.length &&truck_weights[index]<=weight){
               bridge.add(index);
               endTime[index] = totalTime + bridge_length;
               weight -=truck_weights[index];
               index++;
           }
            totalTime++;
           if(bridge.isEmpty())
               break;
        }
        answer =totalTime;
        return answer;
    }
}