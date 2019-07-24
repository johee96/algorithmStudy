package level10;


import java.util.Scanner;
public class level10_2_3 {

	static long n;
	static long k;
	static long result = 0;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		n = sc.nextLong();
		k = sc.nextLong();

		binary(1, n * n);
		System.out.println(result);
	}

	static void binary(long s, long e) {
		if (s > e) {
			result = s;
			return;
		}
		long mid = (s + e) / 2;
		long count = 0;

		for (long i = 1; i <= n; i++) {
		
			long v = mid / i;
			if (v < i)
				break;
			
			if (v >= n)
				count += 1 + 2 * (n - i);

			else
				count += 1 + 2 * (v - i);
	
			if (count >= k)
				break;
		}

		if (count == mid) {
			result = mid;
			return;
		}

		if (count >= k)
			binary(s, mid - 1);
		else
			binary(mid + 1, e);

	}

}
