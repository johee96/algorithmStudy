package algorithmJobs.level19;
//목수의 미로 탈출
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
public class level19_9 {
	static int visited[][][];
	static int map[][];
	static int n, m;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		map = new int[n][m];
		visited = new int[n][m][2];

		for (int i = 0; i < n; i++)
			for (int j = 0; j < m; j++)
				map[i][j] = sc.nextInt();

		find(n - 1, 0);

	}

	static void find(int a, int b) {
		int dx[] = { 0, 1, 0, -1 };
		int dy[] = { 1, 0, -1, 0 };

		Queue<node> q = new LinkedList();
		q.add(new node(a, b, 0));
		visited[a][b][0] = 1;
		while (!q.isEmpty()) {
			node tmp = q.poll();
			for (int i = 0; i < 4; i++) {
				int x = tmp.x + dx[i];
				int y = tmp.y + dy[i];
				int d = tmp.d;
				if ((x > -1 && x < n) && (y > -1 && y < m)) {
					if (map[x][y] == 1) {
						// 벽
						if (d == 0 && visited[x][y][d] == 0) {
							visited[x][y][1] = visited[tmp.x][tmp.y][d] + 1;
							q.add(new node(x, y, 1));
						}
					} else {
						// 벽 아님
						if (visited[x][y][d] == 0) {
							visited[x][y][d] = visited[tmp.x][tmp.y][d] + 1;
							q.add(new node(x, y, d));
						}
					}
				}
			}

		}
		int s1 = visited[0][m - 1][0];
		int s2 = visited[0][m - 1][1];
		if(s1==0)
			System.out.println(s2-1);
		else if(s2==0)
			System.out.println(s1-1);
		else
			System.out.println(Math.min(s1, s2)-1);
	}

	public static class node {
		int x, y, d;

		public node(int x, int y, int d) {
			this.x = x;
			this.y = y;
			this.d = d;
		}
	}
}
/*
 * 
 * 문제 아래와 같이 이동할 수 있는 길, 그리고 이동할 수 없는 벽으로 이루어진 크기 N x M 의 지도가 주어진다. 이 때, (N-1,
 * 0) 에서 출발하여 (0, M-1) 까지 도착하는 최단거리를 찾으려 한다. 그런데 목수는 도끼 하나를 갖고 있으며, 이 도끼를 이용하여
 * 벽을 깨부술 수 있다. 하지만 이 도끼는 내구성이 그렇게 좋지 않기 때문에, 벽을 최대 1개밖에 깰 수 없다. 목수가 출발점에서 도착점까지
 * 이동하기 위한 최단거리를 출력하는 프로그램을 작성하시오. 물론, 벽은 최대 1개까지 깰 수 있다. 아래 예제의 경우 ‘X’ 로 표시된 벽을
 * 깰 경우 거리 18만에 출발점에서 도착점으로 이동할 수 있다.
 * 
 * ec-20
 * 
 * 
 * 
 * 입력 첫째 줄에 지도의 세로 길이 N과 지도의 가로 길이 M이 주어진다. ( 1 ≤ N, M ≤ 1,000 ) 둘째 줄부터 지도의 정보가
 * 주어진다. 0은 이동할 수 있는 부분, 1은 이동할 수 없는 부분을 나타낸다.
 * 
 * 
 * 
 * 출력 목수가 (N-1, 0) 에서 출발하여 (0, M-1) 까지 이동하는 데 필요한 최단거리를 출력한다. 목수는 미로를 항상 탈출할 수
 * 있다고 가정한다.
 * 
 * 
 * 
 * 예제 입력 copy10 10 0 0 0 0 0 0 1 1 0 0 0 1 1 1 0 0 1 0 1 0 0 1 1 1 0 0 1 0 1 0 0
 * 0 0 0 0 0 0 0 1 0 0 0 1 1 1 1 0 0 1 0 0 0 0 0 0 0 1 1 0 0 0 0 1 1 1 0 1 1 0 0
 * 0 0 1 1 1 0 0 0 0 0 0 0 0 0 0 1 1 1 0 0 0 0 0 0 0 0 0 1 0 0 예제 출력 copy18
 * 
 * 
 * 예제 입력 copy10 10 0 0 0 0 0 0 1 1 0 0 0 1 1 1 0 0 1 1 1 0 0 1 1 1 0 0 1 1 1 0 0
 * 0 0 0 0 0 0 1 1 0 0 0 1 1 1 1 0 1 1 0 0 0 0 0 0 0 1 1 0 0 0 0 1 1 1 0 1 1 0 0
 * 0 0 1 1 1 0 0 1 0 0 0 0 0 0 0 1 1 1 1 1 0 0 0 0 0 0 0 1 0 0 예제 출력 copy22
 * 
 */