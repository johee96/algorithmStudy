package baekjoon.week2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class B10799 {
    public static void main(String[] args) throws IOException {
        BufferedReader sb = new BufferedReader(new InputStreamReader(System.in));
        String value = sb.readLine();
        Stack<Character> stack = new Stack<>();
        int pieceCnt = 0;
        char[] c = value.toCharArray();

        for (int i = 0; i < value.length(); i++) {
            if (c[i] == '(') {
                stack.push(c[i]);
            } else {
                stack.pop();
                if (c[i - 1] == '(') {
                    pieceCnt += stack.size();
                } else {
                    pieceCnt++;
                }
            }
        }
        System.out.println(pieceCnt);
    }
}
/*
     char c = value.charAt(i);
            if (c == '(') {
                stickCnt++;
            } else {
                stickCnt--;
                char peekStack = stack.peek();
                if (peekStack == '(') {
                    pieceCnt += stickCnt;
                }else{
                    pieceCnt++;
                }
            }
            stack.push(c);
 */