package baekjoon.week2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class B1874 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();

        int inputValue = 1;
        boolean isPossible = true;
        for (int t = 0; t < n; t++) {
            int target = Integer.parseInt(br.readLine());
            while (inputValue <= target) {
                stack.push(inputValue++);
                sb.append("+ \n");
            }
            if (stack.isEmpty()) {
                isPossible = false;
                break;
            }
            while (stack.peek() >= target) {
                stack.pop();
                sb.append("- \n");
                if (stack.isEmpty())
                    break;
            }
        }
        if (isPossible)
            System.out.println(sb);
        else
            System.out.println("NO");
    }
}
