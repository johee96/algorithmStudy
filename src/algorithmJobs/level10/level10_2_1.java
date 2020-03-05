package algorithmJobs.level10;

import java.util.Scanner;

public class level10_2_1 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		long n = sc.nextLong();
		binary(n, 1, (long) Math.sqrt(n)); // �����ϱ�

	}

	static void binary(long value, long s, long e) {

		if (s > e) {
			System.out.println(e);
			return;
		}
		long mid = (s + e) / 2;

		if (mid * (mid + 1) == value) {
			System.out.println(mid);
			return;
		}

		if (mid * (mid + 1) > value)
			binary(value, s, mid - 1);
		else
			binary(value, mid + 1, e);

	}
}