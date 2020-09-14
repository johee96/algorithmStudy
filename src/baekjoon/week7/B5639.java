package baekjoon.week7;

import java.util.Scanner;

public class B5639 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        Node root = new Node(N);
        while (sc.hasNext()) {
            try {
                N = sc.nextInt();
                root = insertNode(root, N);
            } catch (Exception e) {
                break;
            }
        }
        postOrder(root);
    }

    private static void postOrder(Node node) {
        if (node == null)
            return;
        postOrder(node.left);
        postOrder(node.right);
        System.out.println(node.value);

    }

    private static Node insertNode(Node root, int value) {
        Node newNode = null;
        if (root == null) return new Node(value);
        if (root.value < value) {
            //오른쪽으로 삽입
            newNode = insertNode(root.right, value);
            root.right = newNode;
        } else {
            newNode = insertNode(root.left, value);
            root.left = newNode;
        }
        return root;
    }

    static class Node {
        int value;
        Node left;
        Node right;

        public Node(int value) {
            this.value = value;
        }
    }
}
