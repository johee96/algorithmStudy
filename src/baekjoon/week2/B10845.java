package baekjoon.week2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B10845 {
    public static void main(String[] args) throws IOException {
        usingMyQueue();
    }

    private static void usingMyQueue() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        MyQueue mQueue = new MyQueue();
        for (int i = 0; i < n; i++) {
            String data = br.readLine();
            String[] splitData = data.split("\\s");
            if (splitData.length == 2) {
                mQueue.push(Integer.valueOf(splitData[1]));
                continue;
            }
            switch (splitData[0]) {
                case "pop":
                    System.out.println(mQueue.size() == 0 ? -1 : mQueue.pop());
                    break;
                case "size":
                    System.out.println(mQueue.size());
                    break;
                case "empty":
                    System.out.println(mQueue.isEmpty() ? 1 : 0);
                    break;
                case "front":
                    System.out.println(mQueue.front());
                    break;
                case "back":
                    System.out.println(mQueue.back());
                    break;
            }

        }
    }

    private static void usingQueue() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int lastValue = 0;
        Queue<Integer> numQueue = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            String data = br.readLine();
            String[] splitData = data.split("\\s");
            if (splitData.length == 2) {
                lastValue = Integer.valueOf(splitData[1]);
                numQueue.add(lastValue);
                continue;
            }
            switch (splitData[0]) {
                case "pop":
                    System.out.println(numQueue.size() == 0 ? -1 : numQueue.poll());
                    break;
                case "size":
                    System.out.println(numQueue.size());
                    break;
                case "empty":
                    System.out.println(numQueue.isEmpty() ? 1 : 0);
                    break;
                case "front":
                    System.out.println(numQueue.size() == 0 ? -1 : numQueue.peek());
                    break;
                case "back":
                    System.out.println(numQueue.size() == 0 ? -1 : lastValue);
                    break;
            }

        }
    }

    private static class MyQueue {
        LinkedList<Object> myQueue;

        MyQueue() {
            myQueue = new LinkedList();
        }

        public Object pop() {
            if (myQueue.size() == 0) return -1;
            int item = (int) myQueue.get(0);
            myQueue.remove(0);
            return item;
        }

        public void push(int item) {
            myQueue.add(item);
        }

        public boolean isEmpty() {
            return myQueue.isEmpty();
        }

        public int size() {
            return myQueue.size();
        }

        public Object front() {
            if (myQueue.size() == 0) return -1;
            return (int) myQueue.get(0);
        }

        public Object back() {
            if (myQueue.size() == 0) return -1;
            return (int) myQueue.get(myQueue.size() - 1);
        }
    }

}
