package level17;

import java.util.Scanner;

public class level17_1 {


	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int map[][] = new int[n][m];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				int v = sc.nextInt();
				if(i==0 && j==0)
					map[0][0] =v;
				else if(i==0){
					map[0][j] = map[0][j-1] + v;
				}else if(j==0) {
					map[i][0] = map[i-1][0] + v;
				}else {
					map[i][j] = Math.max(map[i][j-1], map[i-1][j])+v;					
				}
			}
		}
		System.out.println(map[n-1][m-1]);
	}

}
