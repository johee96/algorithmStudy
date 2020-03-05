package programmers.dfs_bfs;

public class network {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		networkSolution sol = new networkSolution();
		int numbers[][] = { { 1, 1, 0 }, { 1, 1, 0 }, { 0, 0, 1 } };
		int re = sol.solution(3, numbers);
		System.out.println(re);
	}

}

class networkSolution {
	static boolean visited[];

	public int solution(int n, int[][] computers) {
		int answer = 0;
		visited = new boolean[n];

		for (int i = 0; i < n; i++) {
			if (!visited[i]) {
				answer++;
				dfs(i, computers,n);
			}
		}
		return answer;
	}

	private void dfs(int v, int[][] computers,int n) {
		if(v >= n || visited[v])
			return;
		visited[v] = true;
		for(int i=0;i<n;i++) 
			if(computers[v][i] == 1)
				dfs(i,computers,n);
		
	}
}