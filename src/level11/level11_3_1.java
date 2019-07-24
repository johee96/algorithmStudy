package level11;

import java.util.Scanner;

public class level11_3_1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();

		stack st = new stack(n);

		for (int i = 0; i < m; i++) {
		
			int a = sc.nextInt();
			int b=0;
			if(a==1) {
				b= sc.nextInt();
			}
			
			if (a == 1)
				st.push(b);
			else if (a == 2)
				st.pop();
			else if (a == 3)
				st.top();
		}
	}

	static class stack {

		int size;
		int stack[];
		int top;

		public stack(int size) {
			this.size = size;
			this.top = -1;
			stack = new int[size];
		}

		void push(int v) {
			if (top == size - 1)
				System.out.println("Overflow");
			else {
				top += 1;
				stack[top] = v;
			}
			
		}

		void pop() {
			if (top == -1)
				System.out.println("Underflow");
			else {
					
				
				stack[top] = 0;
				top -= 1;
				//System.out.println("*"+stack[top]);	
			}
			
		}

		void top() {
			if (top == -1)
				System.out.println("NULL");
			else {
				System.out.println(stack[top]);
			}
			
		}

	}
}
