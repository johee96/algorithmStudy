package programmers.heep;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

public class 디스크컨트롤러 {
    public static void main(String[] args) {
        DiskControllerSolution sl = new DiskControllerSolution();
        int[][] jobs = {{3, 3}, {1, 9},{5,10}};
        int result = sl.solution(jobs);
        System.out.print("result:" + result);
    }
}

class DiskControllerSolution {
    public int solution(int[][] jobs) {
        int answer = 0;
        int listIdx = 0;
        int runningTime = 0;
        int sum = 0;
        Arrays.sort(jobs, (a,b) -> a[0] == b[0] ? a[1]-b[1] : a[0]-b[0]);   // 같은 시간에 들어 오는 것도 고려해야 함

        ArrayList<Job> jobList = new ArrayList<>();

        for (int j = 0; j < jobs.length; j++) {
            jobList.add(new Job(jobs[j][0], jobs[j][1]));
        }

        PriorityQueue<Job> readyQ = new PriorityQueue<>();
        readyQ.add(jobList.get(listIdx));
        runningTime = jobList.get(listIdx).getArrivalTime();
        listIdx++;
        while (!readyQ.isEmpty()) {
            Job tmp = readyQ.poll();
            runningTime += tmp.getBurstTime();
            sum += runningTime - tmp.getArrivalTime();

            while (listIdx < jobList.size()) {
                if (runningTime < jobList.get(listIdx).getArrivalTime())
                    break;
                readyQ.add(jobList.get(listIdx));
                listIdx++;
            }
            if (readyQ.isEmpty() && listIdx < jobList.size()) {
                runningTime = jobList.get(listIdx).getArrivalTime();
                readyQ.add(jobList.get(listIdx));
                listIdx++;
            }
        }

        answer = sum / jobList.size();
        return answer;
    }

    class Job implements Comparable<Job> {
        int arrivalTime;
        int burstTime;

        public Job(int arrivalTime, int burstTime) {
            this.arrivalTime = arrivalTime;
            this.burstTime = burstTime;
        }

        public int getBurstTime() {
            return burstTime;
        }

        public int getArrivalTime() {
            return arrivalTime;
        }


        @Override
        public int compareTo(Job o) {
            return this.burstTime - o.burstTime;
        }
    }
}