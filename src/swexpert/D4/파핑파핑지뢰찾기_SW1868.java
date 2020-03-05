package swexpert.D4;

import java.util.Scanner;

public class 파핑파핑지뢰찾기_SW1868 {
	static int map[][];
	static boolean visited[][];
	static int n;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			n = sc.nextInt();
			map = new int[n][n];
			visited = new boolean[n][n];
			sc.nextLine();
			for (int i = 0; i < n; i++) {
				String str = sc.nextLine();
				for (int j = 0; j < n; j++) {
					if (str.charAt(j) == '.')
						map[i][j] = 0;
					else
						map[i][j] = -1;
				}
			}

			// 1. map을 숫자로 채우기
			for (int i = 0; i < n; i++)
				for (int j = 0; j < n; j++)
					if (map[i][j] == 0)
						fillDigit(i, j);

			// 2. 0 먼저 제거하기
			int count = 0;
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if (!visited[i][j] && map[i][j] == 0) {
						count++;
						clickZero(i, j);
					}
				}
			}

			// 3. 나머지 제거하기
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if (!visited[i][j] && map[i][j] != -1) {
						count++;
					}
				}
			}

			System.out.println("#" + tc + " " + count);

		}

	}

	static void fillDigit(int a, int b) {

		int x[] = { 1, 1, 1, -1, -1, -1, 0, 0 };
		int y[] = { 0, 1, -1, 0, -1, 1, 1, -1 };
		int cnt = 0;

		for (int i = 0; i < 8; i++) {
			int da = a + x[i];
			int db = b + y[i];
			if (da >= 0 && db >= 0 && da < n && db < n) {
				if (map[da][db] == -1) {
					cnt++;
				}
			}
		}
		map[a][b] = cnt;
	}

	static void clickZero(int a, int b) {
		if (visited[a][b] && map[a][b] == -1)
			return;

		visited[a][b] = true;

		int x[] = { 1, 1, 1, -1, -1, -1, 0, 0 };
		int y[] = { 0, 1, -1, 0, -1, 1, 1, -1 };

		for (int i = 0; i < 8; i++) {
			int da = a + x[i];
			int db = b + y[i];
			if (da >= 0 && db >= 0 && da < n && db < n) {
				if (!visited[da][db] && map[da][db] == 0)
					clickZero(da, db);
				else
					visited[da][db] = true;
			}
		}

	}

}
