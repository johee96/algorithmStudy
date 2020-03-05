package algorithmJobs.level10;

import java.util.Scanner;

public class level10_2_4 {

	static long result = 0;

	static int n;

	static long value[];

	public static void main(String[] args) {

		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		value = new long[n + 1];

		for (int i = 1; i < n + 1; i++)
			value[i] = sc.nextLong();

		binary(1, n);

		System.out.println(result);

	}

	static void binary(long s, long e) {
		if (s > e)
			return;

		long mid = (s + e) / 2;
		boolean isok = false;
		long check[] = new long[n + 1];
		long dup = 0;
		int del = 1;

		for (int i = del; i < del + mid; i++)
			check[(int) value[i]]++;

		for (int i = del; i < n + 1; i++) {
			if (check[i] >= 2)
				dup++;
		}

		if (dup == 0)
			isok = true;

		if (!isok)
			while (del + mid < n + 1) {
				check[(int) value[del]]--;

				if (check[(int) value[del]] == 1)
					dup--;
				del++;
				check[(int) value[(int) (del + mid - 1)]]++;
				if (check[(int) value[(int) (del + mid - 1)]] == 2) {
					dup++;
				}
				if (dup == 0) {
					isok = true;
					break;
				}
			}

		if (isok) {
			result = mid;
			binary(mid + 1, e);
		} else
			binary(s, mid - 1);

	}

}
