package algorithmJobs.level17;

import java.util.Scanner;

public class level17_4 {
	public static void main(String[] args) {

		// Please Enter Your Code Here
		Scanner sc = new Scanner(System.in);
		String a = sc.next();
		int size = a.length();
		int count[][] = new int[size][size];

		for (int i = size - 1; i >= 0; i--) {
			for (int j = i; j < size; j++) {
				if (i == j) {
					count[i][j] = 0;
				}else {
					if(a.charAt(i) == a.charAt(j)) {
						count[i][j]=count[i+1][j-1];
					}else {
						count[i][j] = Math.min(count[i][j-1],count[i+1][j]) + 1;
					}
				}
			}
		}
		System.out.print(count[0][size-1]);

	}
}
