package programmers.heep;

import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;

public class 이중우선순위큐 {
    public static void main(String[] args) {

        이중우선순위큐_Solution sol = new 이중우선순위큐_Solution();
        String[] datas = {"I 7", "I 5", "I -5", "D -1"};

        int re[] = sol.solution2(datas);
        System.out.println(re[0] + " " + re[1]);
    }
}

class 이중우선순위큐_Solution {
    //Use Arraylist
    public int[] solution(String[] operations) {
        int[] answer = new int[2];
        ArrayList<Integer> operationsQueue = new ArrayList<>();
        for (int i = 0; i < operations.length; i++) {
            String[] data = operations[i].split(" ");
            if (data[0].equals("I")) {
                operationsQueue.add(Integer.valueOf(data[1]));
            } else {
                if (operationsQueue.size() == 0)
                    continue;
                if (data[1].equals("-1")) {
                    operationsQueue.remove(0);
                } else {
                    operationsQueue.remove(operationsQueue.size() - 1);
                }
            }
            Collections.sort(operationsQueue);
        }
        if (operationsQueue.size() == 0) {
            answer[0] = 0;
            answer[1] = 0;
        } else {
            answer[0] = operationsQueue.get(operationsQueue.size() - 1);
            answer[1] = operationsQueue.get(0);
        }

        return answer;
    }

    //Use PriorityQueue
    public int[] solution2(String[] operations) {
        int[] answer = {0,0};
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<Integer>();
        PriorityQueue<Integer> reversePriorityQueue = new PriorityQueue<Integer>(Collections.reverseOrder());
        for (int i = 0; i < operations.length; i++) {
            String[] data = operations[i].split(" ");
            if (data[0].equals("I")) {
                priorityQueue.add(Integer.parseInt(data[1]));
                reversePriorityQueue.add(Integer.parseInt(data[1]));
            } else {
                if (priorityQueue.size() == 0 || reversePriorityQueue.size() ==0)
                    continue;
                if (data[1].equals("-1")) {
                    // 최값솟 삭제
                    int min = priorityQueue.poll();
                    reversePriorityQueue.remove(min);
                } else {
                    // 최댓값 삭제
                    int max = reversePriorityQueue.poll();
                    priorityQueue.remove(max);
                }
            }
        }

        if(priorityQueue.size()>0){
            answer[0] = reversePriorityQueue.poll();
            answer[1] = priorityQueue.poll();
        }
        return answer;
    }
}