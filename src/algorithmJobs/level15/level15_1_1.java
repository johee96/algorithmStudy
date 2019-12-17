package algorithmJobs.level15;

import java.util.Scanner;

public class level15_1_1 {

	static int data[];

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		data = new int[n];
		for (int i = 0; i < n; i++)
			data[i] = sc.nextInt();

		System.out.println(cal(0, n - 1));

	}

	public static int cal(int start, int end) {
		if (start >= end)
			return data[start];

		int mid = (start + end) / 2;

		int left = cal(start, mid);
		int right = cal(mid + 1, end);

		int midMax = 0;
		int midleft = 0, midright = 0;
		int midleftMax = Integer.MIN_VALUE;
		int midrightMax = Integer.MIN_VALUE;

		for (int i = mid; i >= start; i--) {
			midleft += data[i];
			if (midleft > midleftMax)
				midleftMax = midleft;
		}
		for (int i = mid + 1; i <= end; i++) {
			midright += data[i];
			if (midright > midrightMax)
				midrightMax = midright;
		}

		midMax = midleftMax + midrightMax;

		if (left >= right && left >= midMax)
			return left;
		else if (right >= left && right >= midMax)
			return right;
		else
			return midMax;

	}
}

/*
 * 문제 N개의 정수가 주어질 때, 연속된 부분을 선택하여 합을 최대화 하는 프로그램을 작성하시오. 예를 들어, 아래와 같이 8개의 숫자가
 * 있을 경우, 색칠된 부분을 선택했을 때 그 합이 가장 최대가 된다.
 * 
 * 연속부분최대합
 * 
 * 
 * 
 * 입력 첫 번째 줄에 n이 주어진다. ( 1 ≤ n ≤ 100,000 ) 두 번째 줄에 n개의 정수가 주어진다.
 * 
 * 
 * 
 * 출력 연속된 부분을 선택하였을 때의 최댓값을 출력한다.
 * 
 * 
 * 
 * 예제 입력 copy8 2 3 -5 8 -3 4 2 -9 예제 출력 copy11
 * 
 * 
 * 예제 입력 copy5 -1 -2 3 -2 4 예제 출력 copy5
 */