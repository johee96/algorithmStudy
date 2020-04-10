package programmers.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class 가장먼노드 {
    public static void main(String[] args) {
        int[][] ver = {{3, 6}, {4, 3}, {3, 2}, {1, 3}, {1, 2}, {2, 4}, {5, 2}};
        가장먼노드_Solution s = new 가장먼노드_Solution();
        s.solution(6, ver);
    }
}

class 가장먼노드_Solution {
    //인접리스트
    public int solution(int n, int[][] edge) {
        int answer = 0;
        ArrayList<ArrayList<Integer>> listGraph = new <ArrayList<Integer>>ArrayList();
        int[] dist = new int[n];
        for (int i = 0; i < dist.length; i++)
            dist[i] = Integer.MAX_VALUE;
        for (int i = 0; i < edge.length; i++) {
            listGraph.add(new ArrayList<Integer>());
        }

        for (int i = 0; i < edge.length; i++) {
            listGraph.get(edge[i][0] - 1).add(edge[i][1] - 1);
            listGraph.get(edge[i][1] - 1).add(edge[i][0] - 1);
        }
        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        dist[0] = 0;
        while (!queue.isEmpty()) {
            int tmp = queue.poll();
            for (int i = 0; i < listGraph.get(tmp).size(); i++) {
                if (dist[listGraph.get(tmp).get(i)] == Integer.MAX_VALUE) {
                    dist[listGraph.get(tmp).get(i)] = Math.min(dist[listGraph.get(tmp).get(i)], dist[tmp] + 1);
                    queue.add(listGraph.get(tmp).get(i));
                }
            }
        }
        Arrays.sort(dist);
        int t = dist[dist.length - 1];
        for (int i = 0; i < dist.length; i++) {
            if (t == dist[i])
                answer++;
        }
        System.out.println(answer);
        return answer;
    }

}