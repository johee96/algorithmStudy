package programmers.sort;

import java.util.Arrays;
import java.util.Comparator;

public class 가장큰수 {
    public static void main(String[] args) {

        가장큰수_Solution sol = new 가장큰수_Solution();
        int[] arr = {0, 0, 0, 0};

        String re = sol.solution(arr);

        System.out.println(re);
    }
}

class 가장큰수_Solution {

    public String solution(int[] numbers) {
        String answer = "";
        String[] numStr = new String[numbers.length];

        for (int i = 0; i < numStr.length; i++) {
            numStr[i] = String.valueOf(numbers[i]);
        }

        Arrays.sort(numStr, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return (o2 + o1).compareTo(o1 + o2);
            }
        });

        // 들어오는 숫자가 다 0 일 수도...!!
        if (numStr[0].equals("0")) {
            answer = "0";
        } else {
            for (int i = 0; i < numStr.length; i++) {
                answer += numStr[i];
            }
        }
        return answer;
    }

}
