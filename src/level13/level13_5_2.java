package level13;


import java.util.ArrayList;
import java.util.Scanner;

public class level13_5_2 {

	public static int dep = -1;
	public static ArrayList<Integer>[] data;


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int r = sc.nextInt();
	

		data = new ArrayList[n];
		for (int i = 0; i < n; i++)
			data[i] = new ArrayList<Integer>();

		for (int i = 0; i < n - 1; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();

			data[a].add(b);
			data[b].add(a);
		}
		getD(r, 0, r);

		System.out.println(dep);
	}

	public static void getD(int cur, int d, int p) {
		//System.out.println("cur : "+cur+" d: "+d+" p: "+p);
		if (d > dep)
			dep = d;

		for (int i = 0; i < data[cur].size(); i++) {
			int value = data[cur].get(i);
			if (value != p)
				getD(value, d + 1, cur);
		}

	}

}

/*
문제
트리의 높이는 루트로부터 가장 멀리 떨어진 노드와의 거리로 정의된다. 예를 들어, 아래의 트리에서 0번 노드가 루트라고 하면, 7번 노드까지의 거리가 가장 멀고, 그 거리는 3이다. 따라서 이 트리의 높이는 3이 된다.

alt text

트리가 주어질 때, 그 트리의 높이를 출력하는 프로그램을 작성하시오.

 

입력
첫 번째 줄에 트리의 노드 개수 n, 그리고 루트노드의 번호 r이 주어진다. ( 1 ≤ n ≤ 100, 0 ≤ r ≤ n - 1 ) 두 번째 줄부터 트리의 간선 정보가 주어진다. 각 줄은 2개의 숫자 a, b로 이루어지며, 이는 a번 노드와 b번 노드가 연결되어 있다는 뜻이다. 각 노드의 번호는 0 ~ n-1까지 존재한다. 또한, 연결이 되지않은 노드는 없다.  

출력
트리의 높이를 출력한다.

 

예제 입력
8 0
0 1
0 2
1 3
1 4
1 5
2 6
6 7
예제 출력
3
*/