package level13;


import java.util.ArrayList;
import java.util.Scanner;

public class level13_5_3 {

	public static ArrayList<Integer>[] data;
	public static int[] parent;
	public static int[] depth;
	public static int dist = 0;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int x = sc.nextInt();
		int y = sc.nextInt();

		parent = new int[n];
		depth = new int[n];

		data = new ArrayList[n];
		for (int i = 0; i < data.length; i++)
			data[i] = new ArrayList<Integer>();

		for (int i = 0; i < n - 1; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();

			data[a].add(b);
			data[b].add(a);
		}

		dfs(0, 0, 0);
		cal(x, y);
	}

	public static void dfs(int cur, int dep, int par) {
		depth[cur] = dep;
		parent[cur] = par;

		for (int i = 0; i < data[cur].size(); i++) {
			int value = data[cur].get(i);
			if (value != par)
				dfs(value, dep + 1, cur);
		}
	}

	public static void cal(int a, int b) {
		int prea = depth[a];
		int preb = depth[b];

		int adep = depth[a];
		int bdep = depth[b];

		while (adep > bdep) {
			a = parent[a];
			adep--;
		}
		while (adep < bdep) {
			b = parent[b];
			bdep--;
		}
		while (a != b) {
			a = parent[a];
			b = parent[b];
		}

		dist = (prea - depth[a]) + (preb - depth[b]);

		System.out.println(dist);
	}

}

/*
문제
트리가 주어지고, 두 노드 X, Y가 주어질 때, 이 두 노드 사이의 거리를 출력하는 프로그램을 작성하시오. 트리에서는 두 노드를 잇는 경로가 유일하기 때문에, 정답은 항상 유일하다는 것을 참고한다. 예를 들어, 다음과 같은 트리에서 노드 3, 노드 6 사이의 거리는 4이다.

alt text

 

입력
첫 번째 줄에 트리의 노드 개수 n, 두 노드 X, Y의 번호가 주어진다. ( 0 ≤ X, Y ≤ n < 1000 ) 두 번째 줄부터 트리의 간선 정보가 주어진다. 각 줄은 2개의 숫자 a, b로 이루어지며, 이는 노드 a가 노드 b의 부모노드라는 것을 의미한다. 루트는 노드 0이라고 가정한다.  

출력
두 노드 X, Y 사이의 거리를 출력한다.

 

예제 입력
copy11 3 6
0 1
0 2
1 3
1 4
1 5
2 6
2 10
6 7
6 8
6 9
예제 출력
copy4
*/