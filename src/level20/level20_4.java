package level20;

import java.util.Scanner;

//scc 
public class level20_4 {

	static boolean map[][];
	static boolean reversemap[][];
	static boolean check[], check2[];
	static int n;
	static int time[];
	static int clock = 1;
	static int order_len = 1;
	static int order[];

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		int m = sc.nextInt();

		map = new boolean[n + 1][n + 1];
		reversemap = new boolean[n + 1][n + 1];
		check = new boolean[n + 1];
		check2 = new boolean[n + 1];
		time = new int[n + 1];
		order = new int[n + 1];

		for (int i = 0; i < m; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			map[a][b] = true;
			reversemap[b][a] = true;
		}

		// 1.DFS를 하면서 빠져나오는 순서대로 시간을 기록
		for (int i = 1; i <=n; i++)
			if (!check[i])
				get_time(i);

		// 2. 뒤집은 그래프에 대해서 빠져나오는 시간이 큰 노드부터 순회.
		// 이 때 만나는 노드들은 다 같은 그룹임.
		int group_cnt = 0;
		for (int i = n; i > 0; i--) {
			int node = order[i];
			if (!check2[node]) {
				get_my_group(node);
				group_cnt++;
			}
		}
		System.out.println(group_cnt);

	}

	// 빠져나오는 시간을 기록
	static void get_time(int node) {
		check[node] = true;
		for (int i = 1; i <= n; i++)
			if (!check[i] && map[node][i])
				get_time(i);

		time[node] = clock;
		clock++;
		order[order_len] = node;
		order_len++;
	}

	// 거꾸로된 그래프에서, node에서부터 DFS
	static void get_my_group(int node) {
		check2[node] = true;
		for (int i = 1; i <= n; i++)
			if (!check2[i] &&reversemap[node][i])
				get_my_group(i);
	}

}


/*
 * 풀이
	- SCC(Strongly Connected Component) : 연결되어 있는 그래프들로 나누는 것 (그래프에 그룹이 몇 개 있나)
	- 코사라주 알고리즘 사용
	- 구현
		1. 어떤 정점부터 시작해서 DFS를 하면서 빠져나오는 시간을 기록함 : 시간을 사용해서 방문 순서를 정한다.
		2. 그래프의 간선을 뒤집는다.
		3. 빠져나온 시간이 큰 것부터 DFS 순회시작
		4. 그룹을 알 수 있다.
			- DFS를 하면 부모-자식 관계가 파악이 된다.	즉, 어떤 정점에서 시작하면 그 정점 하위에 있는 것들은 다 방문이 가능(상위는 못 감)
			- 뒤집는 이유 : 메타그래프의 맨 끝 노드를 파악하기 위해서 
*/