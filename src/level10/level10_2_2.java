package level10;

import java.util.Arrays;
import java.util.Scanner;

public class level10_2_2 {

	static long result = 0;
	static long tree[];

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		long m = sc.nextLong();
		tree = new long[n];

		for (int i = 0; i < n; i++)
			tree[i] = sc.nextInt();
		Arrays.sort(tree);
		binary(m, tree[0], tree[tree.length - 1]);
		System.out.println(result);

	}

	static void binary(long value, long s, long e) {

		if (s > e)
			return;

		long mid = (s + e) / 2;

		long sum = 0;
		for (int i = 0; i < tree.length; i++) {
			long sub = tree[i] - mid;
			if (sub > 0) {
				sum += sub;
			}
		}
		if (sum >= value)
			result = mid;

		if (sum < value)
			binary(value, s, mid - 1);
		else
			binary(value, mid + 1, e);

	}

}
