package algorithmJobs.level11;

import java.util.Scanner;

public class level11_3_6 {
	static int value[];
	static int area[];
	static int max = -1;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		value = new int[n];
		area = new int[n];

		for (int i = 0; i < n; i++)
			value[i] = sc.nextInt();
		stack st = new stack(n);
		st.push(0);
		max = value[0];
		for (int i = 1; i < n; i++) {
			st.cal(i);
		}
		st.lastCheck(n);
		System.out.println(max);

	}

	static class stack {
		int size;
		int top;
		int st[];

		stack(int size) {
			this.size = size;
			top = -1;
			st = new int[size];
		}

		void push(int v) {
			top += 1;
			st[top] = v;
		}

		void lastCheck(int idx) {
			while (top > -1) {
				int h = value[peek()];
				pop();
				int w = idx;
				if (top > -1)
					w = idx - peek() - 1;

				max = Math.max(max, w * h);
			}
		}

		void cal(int idx) {
			while (top > -1 && value[peek()] > value[idx]) {
				int h = value[peek()];
				pop();
				int w = idx;
				if (top > -1)
					w = idx - peek() - 1;

				max = Math.max(max, w * h);
			}
			push(idx);

		}

		int peek() {
			return st[top];
		}

		void pop() {
			if (top == -1)
				return;
			top--;
		}

	}

}
/*
 * 문제 히스토그램이란, 아래 그림과 같이 직사각형이 배열되어 있는 것을 말한다. 각 직사각형의 가로 길이는 1로 모두 같고, 세로 길이는
 * 다를 수 있다. 예를 들어, 아래 그림은 높이가 2, 1, 4, 5, 1, 3, 3 인 직사각형으로 이루어진 히스토그램이다.
 * 
 * alt text
 * 
 * 히스토그램이 주어질 때, 가장 큰 직사각형의 너비를 출력하는 프로그램을 작성하시오. 위의 예제에서는 최대 직사각형의 너비가 그림과 같이
 * 8이다.
 * 
 * 
 * 
 * 입력 첫째 줄에 히스토그램을 이루는 직사각형의 개수 N이 주어진다. ( 1 ≤ N ≤ 100,000 ) 둘째 줄에는 각 직사각형의 높이가
 * 주어진다. 높이는 10,000보다 작은 양의 정수이다.
 * 
 * 출력 최대 직사각형의 너비를 출력한다.
 * 
 * 
 * 
 * 예제 입력 copy7 2 1 4 5 1 3 3 예제 출력 copy8
 */