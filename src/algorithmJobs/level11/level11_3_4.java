package algorithmJobs.level11;


import java.util.Scanner;

public class level11_3_4 {
	static int result;
	static String str;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		str = sc.next();

		giho giho = new giho(str.length());
		for (int i = 0; i < str.length(); i++) {
			int v = giho.check(str.charAt(i), i);
			if (v == -1)
				break;
		}

		if (result != -1)
			System.out.println(result);
		else
			System.out.println(0);
	}

	static class giho {
		int size;
		int top;
		int ch[];
		int temp;

		giho(int size) {
			this.size = size;
			top = -1;
			ch = new int[size];
			temp = 1;
		}

		int check(char c, int idx) {
			if ((top == -1 && (c == ')' || c == ']'))
					|| (top != -1 && ((ch[top] == -3 && c == ')') || (ch[top] == -2 && c == ']')))) {
				result = -1;
				return -1;
			}

			if (c == '(')
				push(-2);

			else if (c == '[')
				push(-3);

			else if (c == ')') {
				if (ch[top] == -2)
					ch[top] = 2;
				else if (ch[top] > 0) {
					int t = 0;
					while (ch[top] > 0) {
						int v = pop();
						if (top == -1) {
							result = -1;
							return -1;
						} else
							t += v;
					}
					if (ch[top] == -2)
						ch[top] = t * 2;
					else {
						result = -1;
						return -1;
					}
				}

			} else if (c == ']') {
				if (ch[top] == -3)
					ch[top] = 3;
				else if (ch[top] > 0) {
					int t = 0;
					while (ch[top] > 0) {
						int v = pop();
						if (top == -1) {
							result = -1;
							return -1;
						} else
							t += v;

					}
					if (ch[top] == -3)
						ch[top] = t * 3;
					else {
						result = -1;
						return -1;
					}
				}
			}

			if (idx == str.length() - 1) {
				for (int i = 0; i < ch.length; i++) {
					// System.out.print(ch[i] + " ");
					if (ch[i] > 0) {
						result += ch[i];
					} else if (ch[i] == 0) {
						break;
					} else {
						result = -1;
						break;
					}
				}
			}
			return 0;

		}

		void push(int c) {
			if (top == size - 1) {
				result = -1;
			}
			top += 1;
			ch[top] = c;

		}

		int pop() {
			if (top == -1) {
				// result = -1;
				return -1;
			}
			int pop = ch[top];
			ch[top] = 0;
			top -= 1;
			return pop;
		}
	}

}
