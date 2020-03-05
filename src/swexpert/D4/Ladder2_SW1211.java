package swexpert.D4;

import java.util.Scanner;

public class Ladder2_SW1211 {
	public static int map[][];
	public static int min_dist, min_idx;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		map = new int[100][100];
		for (int t = 1; t <= 10; t++) {
			int tc = sc.nextInt();
			min_dist = Integer.MAX_VALUE;
			min_idx = Integer.MAX_VALUE;

			for (int i = 0; i < 100; i++)
				for (int j = 0; j < 100; j++) {
					map[i][j] = sc.nextInt();
				}
			System.out.print("#" + tc + " ");

			for (int i = 0; i < 100; i++)
				if (map[0][i] == 1)
					ladder(0, i, i, 0, 0);
			System.out.print(min_idx);
			System.out.println("");

		}

	}

	private static void ladder(int a, int b, int idx, int dist, int cnt) {

		if (a == 99) {
			if (min_dist > cnt) {
				min_dist = cnt;
				min_idx = idx;
			}
			return;
		}

		int dx[] = { 0, 0, 1 };
		int dy[] = { 1, -1, 0 };
		// (0,1):오 (0,-1):왼 (1,0):아래
		if (dist == 0) {
			for (int i = 0; i < 2; i++) {
				int da = a + dx[i];
				int db = b + dy[i];
				if (da >= 0 && da < 100 && db >= 0 && db < 100) {
					if (map[da][db] != 0) {
						if (i == 0)
							ladder(da, db, idx, 1, cnt + 1);
						else if (i == 1)
							ladder(da, db, idx, -1, cnt + 1);
						return;
					}
				}
			}
			if (a + dx[2] >= 0 && a + dx[2] < 100 && b + dy[2] >= 0 && b + dy[2] < 100) {
				ladder(a + dx[2], b + dy[2], idx, 0, cnt + 1);

				return;
			}
		} else if (dist == 1) {
			int da = a + dx[0];
			int db = b + dy[0];
			if (da >= 0 && da < 100 && db >= 0 && db < 100)
				if (map[da][db] != 0) {
					ladder(da, db, idx, dist, cnt + 1);
					return;
				}

			if (a + dx[2] >= 0 && a + dx[2] < 100 && b + dy[2] >= 0 && b + dy[2] < 100) {
				ladder(a + dx[2], b + dy[2], idx, 0, cnt + 1);
				return;
			}

		} else if (dist == -1) {

			int da = a + dx[1];
			int db = b + dy[1];
			if (da >= 0 && da < 100 && db >= 0 && db < 100)
				if (map[da][db] != 0) {
					ladder(da, db, idx, dist, cnt + 1);
					return;
				}

			if (a + dx[2] >= 0 && a + dx[2] < 100 && b + dy[2] >= 0 && b + dy[2] < 100) {
				ladder(a + dx[2], b + dy[2], idx, 0, cnt + 1);
				return;
			}

		}
	}
}
