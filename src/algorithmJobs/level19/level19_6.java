package algorithmJobs.level19;

//단지번호붙이기
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class level19_6 {
	static boolean visited[][];
	static int map[][];
	static int n;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		map = new int[n][n];
		visited = new boolean[n][n];

		for (int i = 0; i < n; i++) {
			String a = sc.next();

			for (int j = 0; j < a.length(); j++) {
				map[i][j] = Integer.parseInt((String) a.subSequence(j, j + 1));
			}
		}
		ArrayList<Integer> counts = new ArrayList<>();

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				int re = bfs(i, j);
				if (re > 0)
					counts.add(re);
			}
		}
		Collections.sort(counts);
		System.out.println(counts.size());
		for (int i = 0; i < counts.size(); i++)
			System.out.println(counts.get(i));
	}

	static int bfs(int a, int b) {
		if (visited[a][b])
			return 0;

		int dx[] = { 0, 1, 0, -1 };
		int dy[] = { 1, 0, -1, 0 };

		Queue<node> q = new LinkedList();
		q.add(new node(a, b));
		visited[a][b] = true;
		int count = 0;
		while (!q.isEmpty()) {
			node tmp = q.poll();
			if (map[tmp.x][tmp.y] == 1)
				count++;
			for (int i = 0; i < 4; i++) {
				int x = tmp.x + dx[i];
				int y = tmp.y + dy[i];
				if ((x > -1 && x < n) && (y > -1 && y < n) && map[x][y] == 1) {
					if (!visited[x][y]) {
						visited[x][y] = true;
						q.add(new node(x, y));
					}
				}
			}

		}

		return count;

	}

	public static class node {
		int x, y;

		public node(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}
