package level19;

//미로찾기
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class level19_5 {
	static int visited[][];
	static int map[][];
	static int n, m;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		map = new int[n][m];
		visited = new int[n][m];

		for (int i = 0; i < n; i++)
			for (int j = 0; j < m; j++)
				map[i][j] = sc.nextInt();

		find(n - 1, 0);

	}

	static void find(int a, int b) {
		int dx[] = { 0, 1, 0, -1 };
		int dy[] = { 1, 0, -1, 0 };

		Queue<node> q = new LinkedList();
		q.add(new node(a, b));
		visited[a][b] = 0;
		int count = 0;
		while (!q.isEmpty()) {
			node tmp = q.poll();
			if (map[tmp.x][tmp.y] == 0)
				count++;
			for (int i = 0; i < 4; i++) {
				int x = tmp.x + dx[i];
				int y = tmp.y + dy[i];
				if ((x > -1 && x < n) && (y > -1 && y < m) && map[x][y] == 0) {
					if (visited[x][y] == 0) {
						visited[x][y] = visited[tmp.x][tmp.y]+1;
						q.add(new node(x, y));
					} else {
						visited[x][y] = Math.min(visited[tmp.x][tmp.y]+1, visited[x][y]);
					}
				}
			}

		}
		System.out.println(visited[0][m - 1]);

	}

	public static class node {
		int x, y;

		public node(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}
