package algorithmJobs.level14;

import java.util.Scanner;

public class level14_1_1 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		long m = sc.nextLong();
		long result;
		result = cal(n, m);
		System.out.println(result);
	}

	// 1000000000000000000
	public static long cal(int n, long m) {
		if (m == 1)
			return n % 10007;
		long re = 1;
		long r = cal(n, m / 2);
		if (m % 2 == 0) {
			// 짝수
			re *= r * r % 10007;
		} else {
			re *= n * r * r % 10007;
		}
		// System.out.println("re: " + re);

		return re;
	}

}

/*
 * 문제 n과 m이 주어질 때, n의 m승을 구하는 프로그램을 작성하시오. 단, n의 m승의 값이 커질 수 있기 때문에, 정답을 10,007
 * 으로 나눈 나머지를 출력한다.
 * 
 * 
 * 
 * 입력 첫 번째 줄에 숫자 n과 m이 주어진다. ( 1 ≤ n ≤ 100, 1 ≤ m ≤ 1,000,000,000,000,000,000 )
 * 
 * 출력 첫째 줄에 n의 m승을 10,007 으로 나눈 나머지를 출력한다.
 * 
 * 
 * 
 * 예제 입력 copy3 4 예제 출력 copy81
 */