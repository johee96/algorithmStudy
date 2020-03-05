package swexpert.D4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class 보급로_SW1249 {
	public static int map[][];
	public static int dist[][];

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine().trim());
		for (int t = 1; t <= tc; t++) {
			int n = Integer.parseInt(br.readLine().trim());
			map = new int[n][n];
			dist = new int[n][n];
			for (int i = 0; i < n; i++) {
				String str = br.readLine();
				for (int j = 0; j < n; j++) {
					map[i][j] = str.charAt(j) - '0';
					dist[i][j] = Integer.MAX_VALUE;
				}
			}
			dist[0][0] = 0;
			road2(0, 0, n);
			System.out.println("#" + t + " " + dist[n - 1][n - 1]);
		}

	}

	public static void road2(int a, int b, int n) {
		int da[] = { 0, 0, 1, -1 };
		int db[] = { 1, -1, 0, 0 };

		Queue<point> q = new LinkedList<>();
		q.add(new point(a, b));

		while (!q.isEmpty()) {
			point tmpP = q.poll();
			for (int i = 0; i < 4; i++) {
				int tmpA = tmpP.a + da[i];
				int tmpB = tmpP.b + db[i];
				if (tmpA >= 0 && tmpA < n && tmpB >= 0 && tmpB < n) {
					int tmpDist = map[tmpA][tmpB] + dist[tmpP.a][tmpP.b];
					if (tmpDist < dist[tmpA][tmpB]) {
						dist[tmpA][tmpB] = tmpDist;
						q.add(new point(tmpA, tmpB));
					}
				}
			}
		}
	}

	public static class point {
		int a, b;

		point(int a, int b) {
			this.a = a;
			this.b = b;
		}
	}

	// 이 방법은 시간 초과 남
	public static void road(int a, int b, int n) {
		if (a == n - 1 && b == n - 1) {
			return;
		}
		int da[] = { 0, 0, 1, -1 };
		int db[] = { 1, -1, 0, 0 };

		for (int i = 0; i < 4; i++) {
			int tmpA = a + da[i];
			int tmpB = b + db[i];
			if (tmpA >= 0 && tmpA < n && tmpB >= 0 && tmpB < n) {
				int tmpDist = map[tmpA][tmpB] + dist[a][b];
				if (tmpDist < dist[tmpA][tmpB]) {
					dist[tmpA][tmpB] = tmpDist;
					road(tmpA, tmpB, n);
				}
			}
		}
	}

}
