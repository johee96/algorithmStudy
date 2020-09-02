package baekjoon.week5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class B1931 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        ArrayList<Meeting> meetings = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            meetings.add(new Meeting(start, end));
        }
        Collections.sort(meetings);

        int time = 0;   //회의가 진행된 시간
        int result = 0;    //가능한 회의의 수
        for (int i = 0; i < n; i++) {
            if (meetings.get(i).start >= time) { // 회의가 진행된 시간과 회의가 시작하는 시간을 비교하여 해당되면 회의 가능!
                result++;
                time = meetings.get(i).end;
            }
        }
        System.out.print(result);

    }

    private static class Meeting implements Comparable<Meeting> {
        int start;
        int end;

        public Meeting(int start, int end) {
            this.start = start;
            this.end = end;
        }

        //끝나는 시간을 기준으로 오름차순 정렬 -> 같으면 시작 시간을 기준으로 오름차순 정렬
        @Override
        public int compareTo(Meeting o) {
            if (this.end - o.end > 0)
                return 1;
            else if (this.end == o.end)
                return this.start - o.start;
            return -1;
        }
    }
}
