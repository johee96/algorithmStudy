package baekjoon.week2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class B9012 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        for (int i = 0; i < n; i++) {
            if (checkVPS(br.readLine()))
                System.out.println("YES");
            else
                System.out.println("NO");
        }
    }

    private static boolean checkVPS(String value) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < value.length(); i++) {
            char v = value.charAt(i);
            if (stack.size() == 0 || v == '(') {
                stack.push(v);
                continue;
            }
            if (stack.peek() == '(' && v == ')') {
                stack.pop();
            }
        }

        return stack.size() == 0 ? true : false;
    }
}
