package algorithmJobs.level19;
//전염병
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class level19_8 {
	static boolean visited[];
	static int n;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		int m = sc.nextInt();

		visited = new boolean[n + 1];
		bfs(m);
	}

	static void bfs(int v) {
		Queue<Integer> q = new LinkedList();
		q.add(v);
		visited[v] = true;
		int count = 1;
		while (!q.isEmpty()) {
			int tmp = q.poll();
			int m = tmp * 2;
			int d = (int) tmp / 3;
			if (m > 0 && m <= n) {
				if (!visited[m]) {
					visited[m] = true;
					q.add(m);
					count++;
				}
			}
			if (d > 0 && d <= n) {
				if (!visited[d]) {
					visited[d] = true;
					q.add(d);
					count++;
				}
			}
		}
		System.out.println(n - count);
	}

}
