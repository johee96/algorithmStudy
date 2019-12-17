package algorithmJobs.level16;
import java.util.Scanner;

public class level16_6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int data[] = new int[n+1];
		
		for(int i=1;i<=n;i++)
			data[i] = i;
		if(n>3) {
			for(int i = 4;i<=n;i++) {
				data[i] = (data[i-1] +data[i-2])%1000007;
			}			
			
		}
		System.out.println(data[n]);
	}
}
