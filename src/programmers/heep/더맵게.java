package programmers.heep;

import java.util.PriorityQueue;

public class 더맵게 {

    public static void main(String[] args) {
        int[] scoville = {1, 1};
        int k = 7;
        Solution s = new Solution();
        int result = s.solution(scoville, k);
        System.out.println(result);
    }
}


class Solution {
    public int solution(int[] scoville, int k) {
        int answer = 0;
        PriorityQueue<Integer> scovillePQ = new PriorityQueue<>();
        for (int i = 0; i < scoville.length; i++) {
            scovillePQ.offer(scoville[i]);
        }

        while (scovillePQ.peek() <= k) {
            if (scovillePQ.size() == 1)
                return -1;

            int first = scovillePQ.poll();
            int second = scovillePQ.poll();
            int mixed = first + second * 2;
            scovillePQ.offer(mixed);
            answer++;

        }
        return answer;
    }
}
//
//
//class Solution {
//    public int solution(int[] scoville, int k) {
//        int answer = 0;
//        PriorityQueue<Integer> scovilleQueue = new PriorityQueue<Integer>();
//        int lastIdx = -1;
//        Arrays.sort(scoville);
//        for (int i = 0; i < scoville.length; i++) {
//            if (scoville[i] < k) {
//                lastIdx = i;
//                scovilleQueue.offer(scoville[i]);
//            }
//        }
//        if (lastIdx + 1 < scoville.length)
//            scovilleQueue.offer(scoville[lastIdx + 1]);
//
//        while (!scovilleQueue.isEmpty()) {
//            int first = scovilleQueue.poll();
//            if (first >= k) {
//                return answer;
//            }
//            if (scovilleQueue.isEmpty()) {
//                return -1;
//            }
//            int sec = scovilleQueue.poll();
//            int tmp = first + (sec * 2);
//
//            scovilleQueue.offer(tmp);
//            answer++;
//        }
//        return answer;
//    }
//}