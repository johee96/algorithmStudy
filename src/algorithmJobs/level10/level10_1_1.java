package algorithmJobs.level10;

import java.util.Scanner;

public class level10_1_1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		int value[] = new int[n];
		int key[] = new int[k];
		for (int i = 0; i < n; i++)
			value[i] = sc.nextInt();
		for (int i = 0; i < k; i++)

			key[i] = sc.nextInt();

		for (int i = 0; i < k; i++) {
			int v = binarySearch(value, key[i], 0, value.length - 1);

			if (v > -1)
				System.out.println("YES");
			else
				System.out.println("NO");
		}

	}

	static int binarySearch(int value[], int target, int low, int high) {

		if (low > high)
			return -1;

		int mid = (low + high) / 2;
		if (value[mid] == target)
			return mid;

		if (value[mid] < target)
			return binarySearch(value, target, mid + 1, high);
		else
			return binarySearch(value, target, low, mid - 1);

	}

}