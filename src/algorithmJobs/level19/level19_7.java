package algorithmJobs.level19;

//이상한계산기
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class level19_7 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int visited[] = new int[99999];

		Queue<Integer> q = new LinkedList();
		q.add(1);
		visited[1] = 1;
		//int count = 0;

		while (!q.isEmpty()) {
			
			int tmp = q.poll();
			int m = tmp * 2;
			if (m > 0 && m <= 99999) {
				if (visited[m] == 0) {
					visited[m] = visited[tmp]+1 ;
					q.add(m);
				} else
					visited[m] = Math.min(visited[m], visited[tmp]+1 );
				if(n==m)
					break;
			}

			int d = (int) tmp / 3;
			if (d > 0 && d <= 99999) {
				if (visited[d] == 0) {
					visited[d] = visited[tmp]+1;
					q.add(d);
				} else
					visited[d] = Math.min(visited[d],  visited[tmp]+1);
				if(n==d)
					break;
			}

		}
		System.out.println(visited[n]-1);

	}

}
