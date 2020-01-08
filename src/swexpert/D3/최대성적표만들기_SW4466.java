package swexpert.D3;

import java.util.Arrays;
import java.util.Scanner;

public class 최대성적표만들기_SW4466 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();
        for(int t=1;t<=tc;t++){
            int n = sc.nextInt();
            int k = sc.nextInt();
            int map[]= new int[n];
            for(int i=0;i<n;i++)
                map[i] = sc.nextInt();
            Arrays.sort(map);
            int max = 0;
            for(int i=n-1;i>=n-k;i--)
                max+=map[i];
            System.out.println("#"+t+" "+max);
        }
    }
}
