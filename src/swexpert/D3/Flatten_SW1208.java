package swexpert.D3;

import java.util.Arrays;
import java.util.Scanner;

public class Flatten_SW1208 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);

		for (int TC = 1; TC <= 10; TC++) {
			int dump = sc.nextInt();
			int box[] = new int[100];
			for(int i=0;i<100;i++)
				box[i] = sc.nextInt();
			
			for(int d=0;d<dump;d++) {
				Arrays.sort(box);
				box[0]++;
				box[99]--;
			}
			Arrays.sort(box);
			System.out.println("#"+TC+" "+(box[99]-box[0]));
			
		}
	}

}
