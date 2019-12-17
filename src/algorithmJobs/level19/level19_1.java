package algorithmJobs.level19;
//깊이우선탐색과 너비우선탐색

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class level19_1 {
	static boolean visited[];
	static boolean map[][];
	static int n;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		int m = sc.nextInt();
		map = new boolean[n][n];
		visited = new boolean[n];
		for (int i = 0; i < m; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();

			map[a][b] = true;
			map[b][a] = true;

		}
		dfs(0);
		for (int i = 0; i < n; i++)
			visited[i] = false;
		System.out.println("");

		bfs(0);
	}

	static void dfs(int v) {
		if (visited[v])
			return;

		visited[v] = true;
		System.out.print(v + " ");
		for (int i = 0; i < n; i++) {
			if (map[v][i]) {
				dfs(i);
			}
		}

	}

	static void bfs(int v) {
		Queue<Integer> q = new LinkedList();
		q.add(v);
		visited[v] = true;
		
		while(!q.isEmpty()){
			int tmp = q.poll();
			System.out.print(tmp+" ");
			
			for(int i=1;i<n;i++) {
				if(map[tmp][i] && !visited[i]) {
					visited[i]=true;
					q.add(i);
				}
			}
			
		}
	}

}
