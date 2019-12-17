package algorithmJobs.level16;

import java.util.Scanner;

public class level16_7 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int data[] = new int[n + 1];
		int nsqrt = (int) Math.sqrt(n);

		if (n == nsqrt * nsqrt)
			data[n] = 1;
		else {
			for (int i = 1; i <= n; i++) {
				for (int j = 1; j <= (int) Math.sqrt(i); j++) {
					if (i == j * j)
						data[i] = 1;
					else if (data[i] > 0)
						data[i] = Math.min(data[i], data[j * j] + data[i - j * j]);
					else
						data[i] = data[j * j] + data[i - j * j];
				}
			}
		}
		System.out.println(data[n]);

	}

}
