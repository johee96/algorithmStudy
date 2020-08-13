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
            // 만들어야 하는 수열의 수(target)를 위해 target까지 오름차순으로 stack에 넣는다.
            while (inputValue <= target) {
                stack.push(inputValue++);
                sb.append("+ \n");
            }
            if (stack.isEmpty()) {
                isPossible = false;
                break;
            }
            // 스택의 맨위의 값을 꺼내면서 target을 찾는다.
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
