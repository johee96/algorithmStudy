package programmers.bp;

import java.util.ArrayList;
import java.util.List;

public class 모의고사 {
    public static void main(String[] args) {

    }
}

class 모의고사_Solution {
    public int[] solution(int[] answers) {
        int[] answer = {};
        int[] ans1 = {1, 2, 3, 4, 5};
        int[] ans2 = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] ans3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};

        int[] students = new int[3];
        for (int i = 0; i < answers.length; i++) {
            if (ans1[i % 5] == answers[i])
                students[0]++;
            if (ans2[i % 8] == answers[i])
                students[1]++;
            if (ans3[i % 10] == answers[i])
                students[2]++;
        }
        int max = Math.max(students[0], students[1]);
        max = Math.max(max, students[2]);

        List<Integer> win = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            if (max == students[i]) {
                win.add(i);
            }
        }
        answer = new int[win.size()];
        for (int i = 0; i < win.size(); i++) {
            answer[i] = win.get(i) + 1;
        }
        return answer;
    }
}