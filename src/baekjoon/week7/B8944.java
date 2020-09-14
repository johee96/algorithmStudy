package baekjoon.week7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B8944 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        for (int t = 0; t < tc; t++) {
            int n = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            Node root = new Node(Integer.parseInt(st.nextToken()));
            for (int i = 0; i < n - 1; i++) {
                root = insertNode(root, Integer.parseInt(st.nextToken()));
            }
            long result = countPermutation(root);
            System.out.println(result);
        }
    }

    private static long countPermutation(Node root) {
        long result = 0;
        if (root == null) return result;
        long left = countPermutation(root.left);
        long right = countPermutation(root.right);
        if (left == 0 && right == 0)
            return 1;
        if (left == 0 && right != 0)
            return right;
        if (left != 0 && right == 0)
            return left;
        result = (left * right * combination(root.childCnt, root.left.childCnt + 1)) % 9999991;
        return result;
    }

    private static long combination(long n, long r) {
        if ((n == r) || r == 0) {
            return 1;
        }
        return combination(n - 1, r - 1) + combination(n - 1, r);
    }

    private static Node insertNode(Node root, long value) {
        Node newNode = null;
        if (root == null) return new Node(value);
        if (root.value < value) {
            //오른족으로 붙
            newNode = insertNode(root.right, value);
            root.right = newNode;
        } else {
            newNode = insertNode(root.left, value);
            root.left = newNode;
        }
        root.childCnt++;

        return root;
    }

    static class Node {
        long value;
        int childCnt;
        Node left;
        Node right;

        public Node(long value) {
            this.value = value;
        }
    }
}
