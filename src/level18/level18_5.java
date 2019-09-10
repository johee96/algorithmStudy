package level18;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class level18_5 {
	static boolean visited[][];
	static int n;
	static int map[][];
	static int count;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		map = new int[n][n];
		visited = new boolean[n][n];

		for (int i = 0; i < n; i++) {
			String a = sc.next();
		
			for (int j = 0; j < a.length(); j++) {
				map[i][j] = Integer.parseInt((String) a.subSequence(j, j+1));
			}
		}
		ArrayList<Integer> c =new ArrayList<Integer>();
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (map[i][j] == 1) {
					count = 0;
					dfs(i, j);
					if(count>0)
						c.add(count);
				}
			}
		}
		System.out.println(c.size());
		Collections.sort(c);
		for(int i=0;i<c.size();i++)
			System.out.println(c.get(i));
	}

	static void dfs(int a, int b) {
		int dx[] = { 0, 1, 0, -1 };
		int dy[] = { 1, 0, -1, 0 };
		if (visited[a][b])
			return;
		visited[a][b] = true;
		count++;

		for (int i = 0; i < 4; i++) {
			int x = a + dx[i];
			int y = b + dy[i];
			if ((x > -1 && x < n) && (y > -1 && y < n) && map[x][y] == 1)
				dfs(x, y);
		
		}

	}
}

/*


*DFS
- 스택을 이용하여 그래프를 순회함
- 스택 =  선행관계
  : 나를 먼저 방문하고 그 다음으로 인접한 노드를 차례로 방문
     (단, 방문해던 노드는 방문하지 않음)
- 과정
  DFS(V, Visited)  //v는 시작점, visited는 방문한 노드기록
   1. v를 방문했다고 처리한다.
   2. v와 인접한 모든 w에 대하여 다음을 반복
   3. 만약 w를 방문하지 않았다면, DFS(w,visited)  //w는 이웃
   5. 방문순서 반환
 구현: 재귀함수 -> 스택사용



*/