package algorithmJobs.level18;

import java.util.Scanner;

public class level18_4 {
	static int n;
	static boolean visited[];
	static boolean map[][];

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		int m = sc.nextInt();
		map = new boolean[n + 1][n + 1];
		visited = new boolean[n + 1];
		for (int i = 1; i <= m; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			map[a][b] = true;
			map[b][a] = true;
		}
		dfs(1);

		int count = 0;
		for(int i=1;i<=n;i++)
			if(visited[i])
				count++;
		System.out.println(count-1);

	}

	static void dfs(int v) {
		if (visited[v]) 
			return;
		
		visited[v] = true;
		for (int i = 1; i <= n; i++) {
			if (map[v][i]) {
				dfs(i);
			
			}
		}

	}

}
