package level10;

import java.util.Scanner;
import java.util.Arrays;

public class level10_1_4 {
	static int n;
	static long min = Long.MAX_VALUE;
	static long a = Long.MAX_VALUE;
	static long b = Long.MAX_VALUE;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();

		int value[] = new int[n];
		for (int i = 0; i < n; i++)
			value[i] = sc.nextInt();
		Arrays.sort(value);

		int s = 0;
		int e = value.length - 1;
		while (s < e) {
			long v = Math.abs(value[s] + value[e]);
			if (v == 0) {
				a = value[s];
				b = value[e];
				break;
			}
			if (min > v) {
				min = v;
				a = value[s];
				b = value[e];
			}
			if (value[s] + value[e] > 0)
				e--;
			else
				s++;

		}

		System.out.println(a + " " + b);
	}

}