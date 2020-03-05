package algorithmJobs.level17;
import java.util.Scanner;
public class level17_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int data[] = new int[n];
		int max = -1;
		for (int i = 0; i < n; i++) {
			int v = sc.nextInt();
			if (i == 0)
				data[0] = v;
			else
				data[i] = Math.max(v, data[i - 1] + v);

			if (max < data[i])
				max = data[i];

		}
		System.out.print(max);
	}

}
