package baekjoon.week2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;
import java.util.StringTokenizer;

public class B10828 {
    public static void main(String[] args) throws IOException {
        usingStack();
    }

    private static void usingStack() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        Stack<Integer> numStack = new Stack<>();
        for (int i = 0; i < n; i++) {
            String data = br.readLine();
            String[] splitData = data.split("\\s");
            if (splitData.length == 2) {
                numStack.push(Integer.valueOf(splitData[1]));
                continue;
            }
            switch (splitData[0]) {
                case "pop":
                    System.out.println(numStack.size() == 0 ? -1 : numStack.pop());
                    break;
                case "top":
                    System.out.println(numStack.size() == 0 ? -1 : numStack.peek());
                    break;
                case "size":
                    System.out.println(numStack.size());
                    break;
                case "empty":
                    System.out.println(numStack.isEmpty() ? 1 : 0);
                    break;
            }
        }
    }

    private static void usingClass() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        MyStack numStack = new MyStack();
        for (int i = 0; i < n; i++) {
            String data = br.readLine();
            String[] splitData = data.split("\\s");
            if (splitData.length == 2) {
                numStack.push(Integer.valueOf(splitData[1]));
                continue;
            }
            switch (splitData[0]) {
                case "pop":
                    System.out.println(numStack.pop());
                    break;
                case "top":
                    System.out.println(numStack.peek());
                    break;
                case "size":
                    System.out.println(numStack.size());
                    break;
                case "empty":
                    System.out.println(numStack.isEmpty());
                    break;
            }
        }
    }

    private static class MyStack {
        ArrayList<Object> data;

        MyStack() {
            data = new ArrayList<Object>();
        }

        public Object pop() {
            if (data.size() == 0) return -1;
            int item = (int) data.get(data.size() - 1);
            data.remove(data.size() - 1);
            return item;
        }

        public void push(int item) {
            data.add(item);
        }

        public Object peek() {
            if (data.size() == 0) return -1;
            return (int) data.get(data.size() - 1);
        }

        public int isEmpty() {
            return data.isEmpty() ? 1 : 0;
        }

        public int size() {
            return data.size();
        }
    }
}