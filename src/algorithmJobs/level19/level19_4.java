package algorithmJobs.level19;
//웜바이러스


import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class level19_4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		boolean map[][] = new boolean[n + 1][n + 1];
		for (int i = 0; i < m; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			map[a][b] = true;
			map[b][a] = true;
		}
		boolean visited[] = new boolean[n + 1];
		int count = 0;
		
		Queue<Integer> q = new LinkedList();
		q.add(1);
		visited[1] = true;
		while(!q.isEmpty()) {
			int tmp = q.poll();
			for(int i =2; i<=n;i++) {
				if(map[tmp][i] && !visited[i]) {
					visited[i] = true;
					q.add(i);
					count++;					
				}
			}
		}
		System.out.print(count);
	}

}
