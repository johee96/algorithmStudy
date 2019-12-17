package algorithmJobs.level17;

import java.util.Scanner;

public class level17_3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String a = sc.next();
		String b = sc.next();
		int count[][] = new int[a.length()+1][b.length()+1];

		for(int i=0;i<=a.length();i++)
			count[i][0] = i;
		for(int i=0;i<=b.length();i++)
			count[0][i]=i;
		
		for(int i=1;i<=a.length();i++) {
			for(int j=1;j<=b.length();j++) {
				if(a.charAt(i-1)==b.charAt(j-1))
					count[i][j] = count[i-1][j-1];
				else {
					count[i][j] = Math.min(count[i][j-1], count[i-1][j])+1;
				}
			}
		}
		
		System.out.print(count[a.length()][b.length()]);
	}

}

