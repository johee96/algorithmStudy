package programmers.sort;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class K번째수 {
    public static void main(String[] args) {
        K번째수_Solution sol = new K번째수_Solution();
        int[] arr = {1, 5, 2, 6, 3, 7, 4};
        int[][] commands = {{2, 5, 3}, {4, 4, 1}, {1, 7, 3}};

        int[] re = sol.solution(arr, commands);
        for (int i = 0; i < re.length; i++)
            System.out.print(re[i] + " ");
    }
}

class K번째수_Solution {

    //내가 푼 방식
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        for (int i = 0; i < commands.length; i++) {
            ArrayList<Integer> tmp = new ArrayList<>();
            int start = commands[i][0];
            int end = commands[i][1];
            int k = commands[i][2];
            for (int j = start - 1; j < end; j++) {
                tmp.add(array[j]);
            }
            Collections.sort(tmp);
            answer[i] = tmp.get(k - 1);
        }
        return answer;
    }

    // copyOfRange 함수 사용
    public int[] solution2(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];

        for(int i=0; i<commands.length; i++){
            int[] temp = Arrays.copyOfRange(array, commands[i][0]-1, commands[i][1]);
            Arrays.sort(temp);
            answer[i] = temp[commands[i][2]-1];
        }

        return answer;
    }

    // 직접 sort 구현
    public int[] solution3(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        return answer;
    }
}
