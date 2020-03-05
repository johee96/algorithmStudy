package algorithmJobs.level16;
import java.util.Scanner;

public class level16_5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		long btnr[] = new long[n];
		long btng[] = new long[n];
		long btnb[] = new long[n];
		
		for(int i=0;i<n;i++) {
			int r = sc.nextInt();
			int g = sc.nextInt();
			int b = sc.nextInt();
			if(i==0) {
				btnr[i] = r;
				btng[i] = g;
				btnb[i] = b;
			}else {
				btnr[i] = r +Math.max(btng[i-1], btnb[i-1]);
				btng[i] = g +Math.max(btnr[i-1], btnb[i-1]);
				btnb[i] = b +Math.max(btng[i-1], btnr[i-1]);				
			}
						
		}
		long max = Math.max(btnr[n-1], btng[n-1]);
		max = Math.max(btnb[n-1], max);
		System.out.println(max);
		
	}
}
