package algorithmJobs.level10;

import java.util.Scanner;
import java.util.Arrays;

public class level10_1_3 {
	static int count[];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		count = new int[k];
		int value[] = new int[n];
		for (int i = 0; i < n; i++)
			value[i] = sc.nextInt();

		int key[] = new int[k];
		for (int i = 0; i < k; i++)
			key[i] = sc.nextInt();

		Arrays.sort(value);
		for (int i = 0; i < k; i++) {
			if (binarySearch(value, key[i], 0, value.length - 1) < 100000001)
				countfun(value,key[i],i);
			
		}
		

		for (int i = 0; i < count.length; i++)
			System.out.println(count[i]);

	}

	static long binarySearch(int value[], int target, int low, int high) {
		
		if (low > high)
			return 100000001;
		int mid = (low + high) / 2;
		if (target == value[mid])
			return target;
		if (target < value[mid])
			return binarySearch(value, target, low, mid - 1);
		else
			return binarySearch(value, target, mid + 1, high);
	}

	static void countfun(int value[], int target,int idx) {
		for(int i=0;i<value.length;i++) {
		  if(target<value[i])
				return;
			if(target == value[i])
				count[idx]++;
		}
	}
}