package level16;

import java.util.Scanner;

public class level16_2 {
	static long area[][];

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int q = sc.nextInt();
		
		area = new long[n][m];
		
		for(int i=0;i<n;i++) {
			long sum=0;
			for(int j=0;j<m;j++) {
				long a = sc.nextLong();
				sum+=a;
				if(i>0)
					area[i][j]=sum+area[i-1][j];
				else area[i][j]=sum;
			}
		}
		for(int i=0;i<q;i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			int c = sc.nextInt();
			int d = sc.nextInt();
			
			long result=0;
			if(a>0 && b>0)
				result = area[c][d] - area[c][b-1]-area[a-1][d]+area[a-1][b-1];
			else if(a==0 && b==0) {
				result = area[c][d];
			}
			else if(b==0) {
				result = area[c][d] -area[a-1][d];
			}else if(a==0) {
				result = area[c][d] - area[c][b-1];
			}
			
			
			System.out.println(result);
			
			
			
		}
		
	}


}
