package algorithmJobs.level19;
//이분그래프판별
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class level19_3 {

	static int visited[];
	static boolean map[][];
	static int n;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		int m = sc.nextInt();
		map = new boolean[n+1][n+1];
		visited = new int[n+1];
		for (int i = 1; i <= m; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			map[a][b] = true;
			map[b][a] = true;
		}
		bfs(1);
		System.out.println("Yes");
	}

	static void bfs(int v) {
		Queue<Integer> q = new LinkedList();
		q.add(v);
		visited[v] = 1;
		while (!q.isEmpty()) {
			int tmp = q.poll();
			for (int i = 2; i <= n; i++) {
				if (map[tmp][i] && visited[i] == 0) {
					if (visited[tmp]==2)
						visited[i] = 1;
					else
						visited[i] = 2;
 
					q.add(i);
				}
				if (map[tmp][i] && visited[i] > 0 && visited[i] == visited[tmp]) {
					System.out.println("No");
					System.exit(0);
				}

			}
		}
	}
}