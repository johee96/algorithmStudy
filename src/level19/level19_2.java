package level19;
//2색칠하기
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class level19_2 {

	static int visited[];
	static boolean map[][];
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
		bfs(0);
		System.out.println("YES");
	}

	static void bfs(int v) {
		Queue<Integer> q = new LinkedList();
		q.add(v);
		visited[v] = 1;
		boolean color = false; // 0은 방문안함 1은t, 2는f

		while (!q.isEmpty()) {
			int tmp = q.poll();
			for (int i = 1; i < n; i++) {
				if (map[tmp][i] && visited[i] == 0) {
					if (visited[tmp]==2)
						visited[i] = 1;
					else
						visited[i] = 2;
 
					q.add(i);
				}
				if (map[tmp][i] && visited[i] > 0 && visited[i] == visited[tmp]) {
					System.out.println("NO");
					System.exit(0);
				}

			}
			color = !color;
		}
	}
}