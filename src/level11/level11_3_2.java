package level11;

import java.util.ArrayList;
import java.util.Scanner;

public class level11_3_2 {
	static ArrayList<String> result;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		result = new ArrayList<String>();

		String str = sc.next();
		plate pt = new plate(str.length());

		// char ch[] = str.toCharArray();
		for (int i = 0; i < str.length(); i++) {
			pt.cal(str.charAt(i)); // 숫자로 보냄
		}
		if (result.contains("impossible")) {
			System.out.println("impossible");
			return;
		}
		for (int i = 0; i < result.size(); i++)
			System.out.println(result.get(i));
	}

	static class plate {
		int top;
		int size;
		int alp[];
		int inputvalue;

		plate(int size) {
			top = -1;
			inputvalue = 96;
			this.size = size;
			alp = new int[size];
		}

		void cal(int v) {
			// System.out.println(v);

			if (top == -1 && inputvalue == 96 + size) {
				result.add("impossible");
				return;
			}
			if (top == v - 97) {
				pop();
				return;
			}

			if (top < v - 97) {
				if (inputvalue < v) {
					for (int i = inputvalue + 1; i <= v; i++)
						push(i);
				}

			}
			while (top > -1) {
				if (alp[top] == v) {
					pop();
					break;

				} else
					pop();
			}

		}

		void push(int v) {
			result.add("push");
			top += 1;
			alp[top] = v;
			inputvalue = v;
		}

		void pop() {
			result.add("pop");
			top -= 1;
		}

	}

}
