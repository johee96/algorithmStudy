package baekjoon.week6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;


public class B6549 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            if (n == 0)
                break;
            int idx = -1;
            long maxValue = 0;
            Stack<Stick> sticks = new Stack<>();
            while (st.hasMoreTokens()) {
                idx++;
                long v = Long.parseLong(st.nextToken());
                if (sticks.isEmpty()) {
                    sticks.push(new Stick(v, idx, idx));
                    maxValue = v;
                    continue;
                }
                if (sticks.peek().value < v) {
                    long newMax = Math.max(v, (idx - sticks.peek().startIdx + 1) * sticks.peek().value);
                    maxValue = Math.max(maxValue, newMax);
                    sticks.push(new Stick(v, idx, idx));
                    continue;
                }

                Stick peekStick = sticks.peek();
                while (!sticks.isEmpty() && sticks.peek().value > v) {
                    peekStick = sticks.pop();
                    maxValue = Math.max(maxValue, (idx - peekStick.startIdx) * peekStick.value);
                }

                sticks.push(new Stick(v, peekStick.startIdx, idx));
            }

            //stack 비우기
            int lastIdx = 0;
            if (!sticks.isEmpty()) lastIdx = sticks.peek().endIdx;
            while (!sticks.isEmpty()) {
                Stick s = sticks.pop();
                maxValue = Math.max(maxValue, (lastIdx - s.startIdx + 1) * s.value);
            }
            System.out.println(maxValue);
        }
    }

    private static class Stick {
        long value;
        int startIdx;
        int endIdx;

        public Stick(long value, int startIdx, int endIdx) {
            this.value = value;
            this.startIdx = startIdx;
            this.endIdx = endIdx;
        }
    }
}

//10 0 1 2 3 4 5 6 7 8 9
//9 10 10 10 10 10 10 9 10 10

//todo 정리하기
//http://www.informatik.uni-ulm.de/acm/Locals/2003/output/histogram.out
//http://www.informatik.uni-ulm.de/acm/Locals/2003/input/histogram.in
//https://greeksharifa.github.io/ps/2018/07/07/PS-06549/