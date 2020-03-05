package algorithmJobs.level20;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class level20_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		boolean map[][] = new boolean[n][n];
		int dist[]= new int[n];
		boolean visited[]= new boolean[n];
		for(int i=0;i<m;i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			map[a][b] = true;
			map[b][a] = true;
		}
		int s= sc.nextInt();
		int e= sc.nextInt();
		

		Queue<Integer> q = new LinkedList();
		q.add(s);
		dist[s] = 0;
		visited[s] = true;
		
		while(!q.isEmpty()) {
			int tmp = q.poll();
			
			for(int i=0;i<n;i++) {
				if(!visited[i] && map[tmp][i]) {
					dist[i] = dist[tmp]+1;
					q.add(i);
					visited[i] = true;
				}
			}
		}
		System.out.println(dist[e]);

	}

}
