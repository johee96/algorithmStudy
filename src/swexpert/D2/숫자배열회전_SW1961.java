package swexpert.D2;

import java.util.Scanner;

public class 숫자배열회전_SW1961 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		for (int t = 1; t <= tc; t++) {
			int n = sc.nextInt();
			int map[][] = new int[n][n];
			for (int i = 0; i < n; i++)
				for (int j = 0; j < n; j++)
					map[i][j] = sc.nextInt();

			int map90[][] = rotation(map, n);
			int map180[][] = rotation(map90, n);
			int map270[][] = rotation(map180, n);
			System.out.println("#" + t);

			printMap(map90, map180, map270, n);
		}

	}

	private static int[][] rotation(int map[][], int n) {
		int rotationMap[][] = new int[n][n];
		for (int i = 0; i < n; i++)
			for (int j = 0; j < n; j++)
				rotationMap[i][j] = map[n - 1 - j][i];
		return rotationMap;

	}

	// 행렬출력
	private static void printMap(int[][] map90, int[][] map180, int[][] map270, int n) {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				System.out.print(map90[i][j]);
			}
			System.out.print(" ");
			for (int j = 0; j < n; j++) {
				System.out.print(map180[i][j]);
			}
			System.out.print(" ");

			for (int j = 0; j < n; j++) {
				System.out.print(map270[i][j]);
			}
			System.out.println(" ");
		}

	}
}
