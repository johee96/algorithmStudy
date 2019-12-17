package algorithmJobs.level14;
//50

//12131231321231213123132131213212312131231321231213

import java.util.Scanner;

public class level14_1_2 {
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
문제
숫자 1, 2, 3으로만 이루어지는 수열이 있다. 임의의 길이의 인접한 두 개의 부분 수열이 동일한 것 이 있으면, 그 수열을 나쁜 수열이라고 부른다. 그렇지 않은 수열은 좋은 수열이다.

다음은 나쁜 수열의 예이다.

33

32121323

123123213

다음은 좋은 수열의 예이다.

2

32

32123

1232123

길이가 N인 좋은 수열들을 N자리의 정수로 보아 그중 가장 작은 수를 나타내는 수열을 구하는 프로그램 을 작성하라. 예를 들면, 1213121과 2123212는 모두 좋은 수열이지만 그 중에서 작은 수를 나타내는 수 열 1213121이다.

 

입력
입력은 숫자 N하나로 이루어진다. N은 1 이상 80 이하이다.

 

출력
첫 번째 줄에 1, 2, 3으로만 이루어져 있는 길이가 N인 좋은 수열들 중에서 가장 작은 수를 나타내 는 수열만 출력한다. 수열을 이루는 1, 2, 3들 사이에는 빈칸을 두지 않는다.

 

예제 입력
copy7
예제 출력
copy1213121
*/