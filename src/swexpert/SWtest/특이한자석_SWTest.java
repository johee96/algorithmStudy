package swexpert.SWtest;

import java.util.Scanner;

public class 특이한자석_SWTest {
	public static int map[][];
	public static int points[];
	public static int rotation[];

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		for (int t = 1; t <= tc; t++) {
			int k = sc.nextInt();
			map = new int[5][9];
			points = new int[5];
			rotation = new int[5];
			for (int i = 1; i < 5; i++) {
				points[i] = 1;
				rotation[i] = 0;
				for (int j = 1; j < 9; j++)
					map[i][j] = sc.nextInt();
			}
			for (int tk = 1; tk <= k; tk++) {
				int m = sc.nextInt();
				int r = sc.nextInt();

				checkRotation(m, r);
				rotation();
				for (int i = 1; i < 5; i++)
					rotation[i] = 0;	//초기화

			}

			int sum = 0;
			for (int i = 1; i <= 4; i++)
				if (map[i][points[i]] == 1)
					sum += Math.pow(2, i - 1);
			System.out.println("#" + t + " " + sum);
		}

	}

	//pointer값 변경하기 즉, 회전하기
	public static void rotation() {
		for (int i = 1; i <= 4; i++) {
			if (rotation[i] == 1) {
				points[i] = points[i] - 1;
			} else if (rotation[i] == -1) {
				points[i] = points[i] + 1;
			}
			if (points[i] == 0)
				points[i] = 8;
			if (points[i] == 9)
				points[i] = 1;

		}
	}

	//index 범위 확인하기
	public static int checkRange(int value) {
		if (value >= 9)
			value = value % 9 + 1;

		return value;
	}

	//오른쪽, 왼쪽 방향으로 회전할 것들 확인하기
	public static void checkRotation(int m, int r) {
		rotation[m] = r;
		
		//오른쪽 자석들 검사
		for(int i=m+1;i<=4;i++) {
			if(map[i-1][checkRange(points[i - 1] + 2)] == map[i][checkRange(points[i] + 6)])
				break;
			else
				rotation[i] = -rotation[i-1];
		}
		
		//왼쪽 자석들 검사
		for(int i=m-1;i>=1;i--) {
			if(map[i][checkRange(points[i] + 2)] == map[i+1][checkRange(points[i+1] + 6)])
				break;
			else
				rotation[i] = -rotation[i+1];
		}
	}


}
