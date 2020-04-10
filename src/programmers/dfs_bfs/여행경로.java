package programmers.dfs_bfs;

import java.util.ArrayList;

public class 여행경로 {
    public static void main(String[] args) {
        여행경로_Solution s = new 여행경로_Solution();
        String[][] t1 = {{"ICN", "SFO"}, {"ICN", "ATL"}, {"SFO", "ATL"}, {"ATL", "ICN"}, {"ATL", "SFO"}};
        String[][] t2 = {{"ICN", "JFK"}, {"HND", "IAD"}, {"JFK", "HND"}};
        s.solution(t2);
    }
}

class 여행경로_Solution {
    boolean[] checked;
    String re = "";

    public String[] solution(String[][] tickets) {
        String[] answer = {};
        checked = new boolean[tickets.length];
        ArrayList<Integer> icnList = new ArrayList<>();
        for (int i = 0; i < tickets.length; i++) {
            if (tickets[i][0].equals("ICN"))
                icnList.add(i);
        }
        for (int i = 0; i < icnList.size(); i++) {
            checked[icnList.get(i)] = true;
            route(icnList.get(i), tickets, "ICN" + " " + tickets[icnList.get(i)][1], 0);
            checked[icnList.get(i)] = false;

        }
        answer = new String[tickets.length + 1];
        answer = re.split(" ");
        return answer;
    }

    void route(int idx, String[][] tickets, String result, int cnt) {
        if (cnt >= tickets.length - 1) {
            if (re.length() == 0)
                re = result;
            else if (re.compareTo(result) > 0)
                re = result;
            return;
        }
        for (int i = 0; i < tickets.length; i++) {
            if (tickets[idx][1].equals(tickets[i][0])) {
                if (!checked[i]) {
                    checked[i] = true;
                    route(i, tickets, result + " " + tickets[i][1], cnt + 1);
                    checked[i] = false;
                }
            }
        }
    }
}