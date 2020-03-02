package baekjoon.dq;

import java.util.Scanner;

public class B6549 {
    static long maxRect;
    static int n;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            maxRect = -1;
            n = sc.nextInt();
            if (n == 0)
                break;
            long[] data = new long[n];
            for (int i = 0; i < n; i++) {
                data[i] = sc.nextInt();
            }
            SegmentTree segmentTree = new SegmentTree(data, n);

            findRect(data, 0, data.length - 1, segmentTree);
            System.out.println(maxRect);
        }
    }

    static void findRect(long[] data, int start, int end, SegmentTree segmentTree) {
        if (start > end)
            return;

        int minIdx = segmentTree.query(data, start, end, 1, 0, n - 1);

        long re = data[minIdx] * (end - start + 1);
        if (maxRect < re)
            maxRect = re;

        findRect(data, start, minIdx - 1, segmentTree);
        findRect(data, minIdx + 1, end, segmentTree);


    }


    static class SegmentTree {

        int[] segmentArr; // The array that stores segment tree nodes

        SegmentTree(long[] arr, int n) {

            int x = (int) Math.ceil(Math.log(100000) / Math.log(2));

            int segmentSize = (int) Math.pow(2, x) * 2;

            segmentArr = new int[segmentSize];

            init(arr, 0, n - 1, 1);
        }

        int init(long[] arr, int left, int right, int node) {

            if (left == right) return segmentArr[node] = left;

            int mid = (left + right) / 2;

            int leftChildNode = init(arr, left, mid, node * 2);
            int rightChildNode = init(arr, mid + 1, right, node * 2 + 1);

            return segmentArr[node] = arr[leftChildNode] <= arr[rightChildNode] ? leftChildNode : rightChildNode;
        }

        int query(long[] arr, int left, int right, int node, int nodeLeft, int nodeRight) {

            // 두 구간이 겹치지 않는 경우
            if (right < nodeLeft || left > nodeRight) return -1;

            // 노드 구간이 완전히 속하는 경우
            if (left <= nodeLeft && right >= nodeRight) return segmentArr[node];

            int nodeMid = (nodeLeft + nodeRight) / 2;

            int leftChildNode = query(arr, left, right, node * 2, nodeLeft, nodeMid);
            int rightChildNode = query(arr, left, right, node * 2 + 1, nodeMid + 1, nodeRight);

            if (leftChildNode == -1)
                return rightChildNode;
            else if (rightChildNode == -1)
                return leftChildNode;
            else
                return arr[leftChildNode] <= arr[rightChildNode] ? leftChildNode : rightChildNode;
        }

    }
}
