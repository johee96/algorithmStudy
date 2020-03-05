package algorithmJobs.level12;

import java.util.Scanner;
public class level12_1_1 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();

		queue q = new queue(n);
		for (int i = 0; i < m; i++) {
			int a = sc.nextInt();
			if (a == 1) {
				int b = sc.nextInt();
				q.push(b);
			} else if (a == 2)
				q.pop();
			else
				q.front();
		}

	}

	static class queue {
		int size;
		int q[];
		int rear;
		int point;

		queue(int size) {
			this.size = size;
			q = new int[size];
			rear = -1;
			point = 0;
		}

		void push(int v) {
			if (rear == size - 1) {
				System.out.println("Overflow");
			} else {
				rear++;
				q[rear] = v;
			}
		}

		void pop() {
			if (point == rear+1)
				System.out.println("Underflow");
			else {
				point++;
			}
		}

		void front() {
			if (point == rear + 1)
				System.out.println("NULL");
			else
				System.out.println(q[point]);
		}

	}

}