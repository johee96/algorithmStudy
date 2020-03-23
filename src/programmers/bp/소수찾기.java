package programmers.bp;

import java.util.ArrayList;

public class 소수찾기 {
    public static void main(String[] args) {
        소수찾기_Solution sol = new 소수찾기_Solution();
        System.out.print(sol.solution("011"));
    }
}

class 소수찾기_Solution {

    public int solution(String numbers) {
        char[] numStr = numbers.toCharArray();
        int answer = 0;
        ArrayList<Integer> primeNum = new ArrayList<>();
        boolean visited[] = new boolean[numStr.length];
        findPrimeNum(0, "", numStr, primeNum, visited);

        return primeNum.size();
    }

    public void findPrimeNum(int depth, String str, char[] numStr, ArrayList<Integer> primeNum, boolean visited[]) {
        if (depth == numStr.length) {
            return;
        }
        for (int i = 0; i < numStr.length; i++) {
            if (visited[i] != true) {
                visited[i] = true;
                str += numStr[i];
                if (checkPrimeNum(str)) {
                    if (!primeNum.contains(Integer.parseInt(str))) {
                        primeNum.add(Integer.parseInt(str));
                    }
                }
                findPrimeNum(depth + 1, str, numStr, primeNum, visited);
                str = str.substring(0, str.length() - 1);
                visited[i] = false;
            }
        }


    }


    public boolean checkPrimeNum(String str) {
        boolean result = true;
        int num = Integer.valueOf(str);
        if (num == 1 || num == 0)
            return false;
        for (int i = 2; i < num; i++) {
            if (num % i == 0) {
                result = false;
                break;
            }
        }

        return result;
    }
}
