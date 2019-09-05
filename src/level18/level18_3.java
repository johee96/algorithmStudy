package level18;

import java.util.Scanner;

public class level18_3 {
	static boolean map[][];
	static int visited[];
	static int n;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		int m = sc.nextInt();
		map = new boolean[n + 1][n + 1];
		visited = new int[n + 1];
		for (int i = 1; i <= m; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			map[a][b] = true;
			map[b][a] = true;
		}
		for (int i = 1; i <= n; i++) {
			dfs(i, false);
		}
		for (int i = 1; i <= n; i++) {
			System.out.print(visited[i] + " ");
		}
		System.out.println("");
		for (int i = 1; i <= n; i++) {
			for (int j = i+1; j <= n; j++) {
				if (map[i][j]) {
					if (visited[i] == visited[j]) {
						System.out.println("NO");
						System.exit(0);
					}
				}
			}
		}
		System.out.println("YES");

	}

	static void dfs(int v, boolean check) {

		if (visited[v] > 0)
			return;

		if (!check)
			visited[v] = 1;
		else
			visited[v] = 2;

		for (int i = 1; i <= n; i++) {
			if (map[v][i]) {
				dfs(i, !check);
			}
		}
	}
}
