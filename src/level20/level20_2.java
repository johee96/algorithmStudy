package level20;

import java.util.Scanner;

public class level20_2 {
	static int n;
	static int map[][];

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		int m = sc.nextInt();
		map = new int[n + 1][n + 1];
		for (int i = 0; i < m; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			int c = sc.nextInt();
			if(map[a][b]==0) {
				map[a][b] = c;
				map[b][a] = c;
			}else {	//이웃하는 두 정점에 간선이 하나 이상일 수 있다. 
				map[a][b] = Math.min(map[a][b], c);
				map[b][a] = Math.min(map[b][a], c);
			}
		}
		int a = sc.nextInt();
		int b = sc.nextInt();

		int sa = dijkstral(1, a);
		int ab = dijkstral(a, b);
		int be = dijkstral(b, n);

		int sb = dijkstral(1, b);
		int ba = dijkstral(b, a);
		int ae = dijkstral(a, n);
		
		int re = 0;

		if (sb > 0 && ba > 0 && ae > 0) {
			re = sb + ba + ae;
		}
		if (sa > 0 && ab > 0 && be > 0) {
			if (re > 0)
				re = Math.min(re, sa + ab + be);
		}

		System.out.println(re);

	}

	static int dijkstral(int s, int e) {
		boolean visited[] = new boolean[n + 1];
		int dist[] = new int[n + 1];
		for (int i = 1; i < n + 1; i++)
			dist[i] = Integer.MAX_VALUE;

		dist[s] = 0;
		visited[s] = true;

		for (int i = 1; i < 1 + n; i++)
			if (!visited[i] && map[s][i] != 0)
				dist[i] = map[s][i];

		for (int k = 0; k < n - 1; k++) {
			int min = Integer.MAX_VALUE;
			int min_idx = -1;

			// 최소값찾기
			for (int j = 1; j < n + 1; j++) {
				if (!visited[j] && dist[j] != Integer.MAX_VALUE) {
					if (dist[j] < min) {
						min = dist[j];
						min_idx = j;
					}
				}
			}

			visited[min_idx] = true;
			
			for (int j = 1; j < n + 1; j++) {
				if (!visited[j] && map[min_idx][j] != 0) {
					if (dist[j] > map[min_idx][j] + dist[min_idx])
						dist[j] = map[min_idx][j] + dist[min_idx];
				}
			}
			
			if (visited[e])
				return dist[e];
		}
		return -1;
	}

}
