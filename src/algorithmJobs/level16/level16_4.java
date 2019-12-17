package algorithmJobs.level16;
import java.util.Scanner;

public class level16_4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		long max = 0;
		int n = sc.nextInt();
		long data0[] = new long[n];
		long data1[] = new long[n];
		long data2[] = new long[n];

		for (int i = 0; i < n; i++) {
			int v = sc.nextInt();
			if (i == 0) {
				data0[i] = 0;
				data1[i] = v;
				data2[i] = 0;
			} else {
				long m = Math.max(data0[i - 1], data1[i - 1]);
				m = Math.max(m, data2[i - 1]);
				data0[i] =m;
				data1[i] = v + data0[i - 1];
				data2[i] = v + data1[i - 1];
			}
		}
		max = Math.max(data0[n - 1], data1[n - 1]);
		max = Math.max(max, data2[n - 1]);
		System.out.println(max);
	}


}
