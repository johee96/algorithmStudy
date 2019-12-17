package algorithmJobs.level10;

import java.util.Scanner;

public class level10_2_5 {
	static long sum = 0;
	static long scope[];
	static long k;
	static long result;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		scope = new long[n * 2 + 1];
		long min = Long.MAX_VALUE;
		long max = -1;
		for (int i = 1; i <= n * 2; i++) {
			scope[i] = sc.nextLong();
			if (max < scope[i])
				max = scope[i];
			if (min > scope[i])
				min = scope[i];
		}
		k = sc.nextLong();
		k += 1;
		binary(min, max);
		System.out.println(result);

	}

	static void binary(long s, long e) {
		if (s > e) {
			return;
		}
		long mid = (s + e) / 2;
		long cnt = 0;

		for (int i = 1; i < scope.length; i = i + 2) {
			if (scope[i + 1] <= mid)
				cnt += scope[i + 1] - scope[i] + 1;
			else {
				if (scope[i] > mid)
					continue;
				cnt += mid - scope[i] + 1;
			}
			// System.out.println("#sum: "+cnt);

		}
		// System.out.println("mid: "+mid+ " sum: " +cnt);
		if (cnt == k) {
			result = mid;
			return;
		}

		if (cnt > k) {
			result = mid;
			binary(s, mid - 1);
		} else {
			// result = mid;
			binary(mid + 1, e);
		}

	}

}
