package algorithmJobs.level11;
import java.util.Scanner;

public class level11_3_5 {
	static long value[] ;
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		 value = new long[n];
		for (int i = 0; i < n; i++)
			value[i] = sc.nextLong();
		stack st = new stack(n);
		long result[] = new long[n];
	
		st.push(0);
		result[0] = 0;
		
		for (int i = 1; i < n; i++) {
			//st.push(value[i]);
			result[i] = st.find(i);
		}
		for (int i = 0; i < n; i++) {
			System.out.print(result[i] + " ");
		}

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

		long find(int v) {
			long re = 0;
			if (top > -1) {
				//System.out.println("top: "+ top +" v: "+ v + " st[top]: "+st[top]);
				if(value[v] < value[st[top]]) {
					re = st[top] +1 ;
					push(v);
				}else {
					pop();
					long r = find(v);
					if (r==0)
						push(v);
					else
						re = r;
				}
			}
			return re;
		}

		void pop() {
			if (top == -1)
				return;
			//long result = st[top];
			top--;

		}

	}

}
