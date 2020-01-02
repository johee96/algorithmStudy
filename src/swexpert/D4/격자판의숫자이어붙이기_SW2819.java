package swexpert.D4;

import java.util.ArrayList;
import java.util.Scanner;

public class 격자판의숫자이어붙이기_SW2819 {
	static ArrayList<Integer> result;
	static int map[][];

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			result = new ArrayList<Integer>();

			map = new int[4][4];
			for (int i = 0; i < 4; i++)
				for (int j = 0; j < 4; j++)
					map[i][j] = sc.nextInt();

			for (int i = 0; i < 4; i++)
				for (int j = 0; j < 4; j++)
					dfs(i, j, 0, 0);
			
			System.out.println("#" + tc + " " + result.size());
		}
	}

	private static void dfs(int a, int b, int value, int cnt) {
		value += map[a][b] * Math.pow(10, cnt);
		cnt++;
		if (cnt >= 7) {
			if (!result.contains(value))
				result.add(value);
			return;
		}

		int x[] = { 0, 0, 1, -1 };
		int y[] = { 1, -1, 0, 0 };

		
		for (int i = 0; i < 4; i++) {
			int da = x[i] + a;
			int db = y[i] + b;
			if (da >= 0 && da < 4 && db >= 0 && db < 4) {
				dfs(da, db, value, cnt);
			}
		}
	}

}
