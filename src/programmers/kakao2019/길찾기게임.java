package programmers.kakao2019;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class 길찾기게임 {

    class Solution {
        public int[][] solution(int[][] nodeinfo) {
            int[][] answer = {};
            List<Node> list = new LinkedList<>();
            for (int i = 0; i < nodeinfo.length; i++) {
                list.add(new Node(nodeinfo[i][0], nodeinfo[i][1], i + 1));
            }
            Collections.sort(list);
            Node root = list.get(0);
            for (int i = 1; i < list.size(); i++) {
                addNode(root, list.get(i));
            }

            List<Integer> preAns = new LinkedList<>();
            pre(preAns, root);
            answer = new int[2][preAns.size()];
            for (int i = 0; i < preAns.size(); i++) {
                answer[0][i] = preAns.get(i);
            }

            List<Integer> postAns = new LinkedList<>();
            post(postAns, root);
            for (int i = 0; i < postAns.size(); i++) {
                answer[1][i] = postAns.get(i);
            }
            return answer;
        }


        public void post(List<Integer> postAns, Node node) {
            if (node.left != null)
                post(postAns, node.left);
            if (node.right != null)
                post(postAns, node.right);

            postAns.add(node.value);

        }

        public void pre(List<Integer> preAns, Node node) {
            preAns.add(node.value);

            if (node.left != null)
                pre(preAns, node.left);
            if (node.right != null)
                pre(preAns, node.right);

        }

        public void addNode(Node par, Node child) {
            if (par.x > child.x) {
                if (par.left == null) {
                    par.left = child;
                } else {
                    addNode(par.left, child);
                }
            } else {
                if (par.right == null) {
                    par.right = child;
                } else {
                    addNode(par.right, child);
                }
            }
        }

        class Node implements Comparable<Node> {
            int x;
            int y;
            int value;
            Node left;
            Node right;

            public Node(int x, int y, int value) {
                this.x = x;
                this.y = y;
                this.value = value;
            }

            @Override
            public int compareTo(Node o) {
                if (this.y == o.y)
                    return this.x - o.x;
                return o.y - this.y;
            }
        }
    }
}
