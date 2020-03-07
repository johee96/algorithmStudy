package baekjoon.binarysearch;

import java.util.Scanner;

public class B1300 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int low = 1;
        int high = k;
        int result = 0;

        while (true) {
            if (low > high) {
                break;
            }
            int mid = (low + high) / 2;
            int cnt = 0;
            for (int i = 1; i <= n; i++) {
                cnt += Math.min(mid / i,n);
            }

            if (cnt < k) {
                low = mid + 1;
            } else {
                result = mid;
                high = mid - 1;
            }
        }
        System.out.print(result);

    }
}
