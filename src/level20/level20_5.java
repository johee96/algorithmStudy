package level20;
//폭발물설치
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class level20_5 {
	static boolean map[][], check1[], check2[];
	static int n, m, k;
	static int order[];
	static int order_len = 1;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		check1 = new boolean[n + 1];
		check2 = new boolean[n + 1];
		map = new boolean[n + 1][n + 1];
		order = new int[n + 1];
		for (int i = 0; i < m; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			map[a][b] = true;
		}
		// 1. dfs
		for (int i = 1; i <= n; i++)
			if (!check1[i]) 
				dfs(i);
		
		// 빠져나오는 시간이 큰 노드 부터 순회.
		int group_cnt = 0;
		for (int i =n; i>0; i--) {
			int node = order[i];
			if (!check2[node]) {
				dfs2(node);
				group_cnt++;
			}

		}
		 System.out.print(group_cnt);
	}

	static void dfs(int v) {
		check1[v] = true;
		for (int i = 1; i <= n; i++)
			if (!check1[i] && map[v][i])
				dfs(i);

		order[order_len] = v;
		order_len++;

	}

	static void dfs2(int v) {
		check2[v] = true;
		for (int i = 1; i <= n; i++)
			if (!check2[i] && map[v][i])
				dfs2(i);

	}

}

/*
 * 
 문제
철수는 마을의 여러 건축물들을 폭파해달라는 요청을 받았다. 이에 건축물들을 하나씩 폭파하려 한다. 일반적으로, 하나의 건물을 폭파하기 위해서는 다이너마이트 하나가 필요하다고 하자. 철수의 마을에 있는 건축물들 사이에는 특별한 단방향 통로가 존재한다. 하나의 건축물을 폭파시킬 경우, 이 단방향 통로로 인하여 상황이 약간 복잡해지는데, 이는 건물 A에서 건물 B로 통로가 이어져 있을 경우, 건물 A를 폭파시키면 건물 B 역시 폭파된다는 것이다. 이유인 즉슨, 단방향 통로가 지하에 매설되어 있기 때문에, 지하의 통로가 무너지면서 건물 B가 함께 무너진다. 철수의 마을에 존재하는 건축물의 개수가 주어지고, 이 건축물들 사이의 단방향 통로가 주어질 때, 최소 몇 개의 다이너마이트가 있어야 모든 건축물을 폭파시킬 수 있는지를 구하는 프로그램을 작성하시오.

 

입력
첫째 줄에 건축물의 개수 N이 주어지고, 단방향 통로의 개수 M이 주어진다.( 2 ≤ N ≤ 1,000, 1 ≤ M ≤ 100,000 ) 둘째 줄부터 단방향 통로의 정보가 주어진다. 각 줄은 두 개의 숫자 a, b로 이루어져 있으며, 건축물 a에서 건축물 b로 향하는 단방향 통로가 존재한다는 의미이다. 각 정점의 번호는 1번부터 N번까지이다.

 

출력
모든 건축물을 폭파시키기 위해 필요한 최소의 다이너마이트 개수를 출력한다.

 

예제 입력
copy7 8
1 2
1 3
2 3
3 7
4 5
5 6
6 4
6 7
예제 출력
copy2
*/
