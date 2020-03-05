package algorithmJobs.level16;

import java.util.Scanner;

public class level16_1 {


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		long table[]=new long[n+1];
		long sum=0;
		
		for(int i=1;i<=3;i++) {
			sum+=table[i-1];
			table[i] = sum+1;
		}
		
		for(int i = 4; i<=n;i++) {
			for(int j = i-3; j<=i-1;j++)
				table[i]+=table[j];
			table[i]=table[i]%1000007;
		}
		System.out.println(table[n]);
		

	}

}
