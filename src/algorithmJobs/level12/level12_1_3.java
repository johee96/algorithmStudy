package algorithmJobs.level12;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class level12_1_3 {

	static int n;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		int m = sc.nextInt();
		int count = p(m);
		 System.out.println(n - count);
	}

	static int p(int m) {
		boolean visited[] = new boolean[n+1];
		Queue<Integer> q = new LinkedList<>();
		q.add(m);
		visited[m] = true;
		int value = m;
		int count = 0;
		while (!q.isEmpty()) {
			count++;

			value = q.poll();
		//	System.out.println("v" + value);
			int v1 = value * 2;
			int v2 = value / 3;

			if (v1 > 0 && v1 <= n) {
				if (!visited[v1]) {
					q.add(v1);
					visited[v1] = true;
				}
			}

			if (v2 > 0 && v2 <= n) {
				if (!visited[v2]) {
					q.add(v2);
					visited[v2] = true;
				}
			}

		}
		return count;

	}

}

/*
문제
철수네 마을에는 갑자기 전염병이 유행하기 시작하였다. 이 전염병은 전염이 매우 강해서, 이웃한 마을끼리는 전염되는 것을 피할 수 없다.
철수네 마을은 1번부터 N번까지 번호가 매겨져 있다. 철수네 마을의 구조는 꽤나 복잡한데, i번 마을에서 출발하면 i * 2 번 마을에 갈 수 있고, 또한 i / 3(i를 3으로 나눈 몫) 번째 마을에도 갈 수 있다. 전염병은 사람에 의하여 옮는 것으로 알려져 있다. 따라서 i번 마을에 전염병이 돌게 되면, i * 2 번 마을과 i / 3(i를 3으로 나눈 몫) 번 마을 역시 전염병이 돌게 된다.
K번 마을이 가장 처음으로 전염병이 돌기 시작했을 때, 전염병이 돌지 않는 마을의 개수를 구하는 프로그램을 작성하시오.

 

입력
첫째 줄에 전체 마을의 개수 N과, 처음으로 전염병이 돌기 시작한 마을 번호 K가 주어진다. ( 1 ≤ N, K ≤ 100,000 )  

출력
전염병이 돌지 않는 마을의 개수를 출력한다.
*/