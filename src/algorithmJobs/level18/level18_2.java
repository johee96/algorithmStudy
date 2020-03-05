package algorithmJobs.level18;

import java.util.Scanner;

public class level18_2 {
	static boolean map[][];
	static int visited[]; 
	static int n;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		int m = sc.nextInt();
		map = new boolean[n][n];
		visited = new int[n];
		for (int i = 0; i < m; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			map[a][b] = true;
			map[b][a] = true;
		}
		dfs(0, false);

		System.out.println("YES");
	}

	static void dfs(int v, boolean check) {
		if (visited[v] > 0) {
					return;
		}
		if (!check)
			visited[v] = 1;
		else
			visited[v] = 2;

		for (int i = 0; i < n; i++) {
			if (map[v][i]) {
				if (visited[i] == visited[v]) {
					System.out.println("NO");
					System.exit(0);
				}

				dfs(i, !check);
			}
		}
	}
}
