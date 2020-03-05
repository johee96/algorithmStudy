package algorithmJobs.level15;

//합병정렬
import java.util.Scanner;

public class level15_1_2 {
	static int data[];
	static int temp[];

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		data = new int[n];
		temp = new int[n];

		for (int i = 0; i < n; i++)
			data[i] = sc.nextInt();
		sort(0, n - 1);
		for (int i = 0; i < n; i++)
			System.out.print(data[i] + " ");
	}

	public static void sort(int start, int end) {
		if (start >= end)
			return;

		int mid = (start + end) / 2;
		sort(start, mid);
		sort(mid + 1, end);

		merge(start, mid, end);

	}

	public static void merge(int start, int mid, int end) {
		int l = start;
		int r = mid + 1;

		int idx = start;

		while (l <= mid && r <= end) {
			if (data[l] < data[r]) {
				temp[idx] = data[l];
				l++;
			} else {
				temp[idx] = data[r];
				r++;
			}
			idx++;
		}

		if (l > mid) {
			for (; r <= end; r++) {
				temp[idx] = data[r];
				idx++;
			}
		} else {
			for (; l <= mid; l++) {
				temp[idx] = data[l];
				idx++;
			}

		}

		for (int i = start; i <= end; i++)
			data[i] = temp[i];

	}

}
