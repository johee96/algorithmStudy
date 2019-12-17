package algorithmJobs.level20;
//파티

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class level20_3 {
	static int n, m, k;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		k = sc.nextInt();
		int map[][] = new int[n + 1][n + 1];

		int map2[][] = new int[n + 1][n + 1];
		for (int j = 0; j < m; j++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			int c = sc.nextInt();
			map[a][b] = c;
			map2[b][a] = c;
		}
		int sum = dijkstra(k, map);

		sum += dijkstra(k, map2);
		System.out.print(sum);
	}

	public static int dijkstra(int s, int map[][]) {
		int dist[] = new int[n + 1];
		int sum = 0;
		// 초기화
		for (int i = 1; i < n + 1; i++)
			dist[i] = Integer.MAX_VALUE;
		dist[s] = 0;
		Queue<Integer> q = new LinkedList();
		q.add(s);
		while (!q.isEmpty()) {
			int tmp = q.poll();
			for (int j = 1; j < n + 1; j++) {
				if (map[tmp][j] != 0 && dist[j] > map[tmp][j] + dist[tmp]) {
					dist[j] = map[tmp][j] + dist[tmp];
					q.add(j);
				}

			}
		}
		for (int i = 1; i < n + 1; i++)
			if (dist[i] != Integer.MAX_VALUE) {
				sum += dist[i];
			}
		return sum;
	}
}
