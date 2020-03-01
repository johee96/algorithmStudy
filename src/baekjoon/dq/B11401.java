package baekjoon.dq;

import java.util.Scanner;

public class B11401 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        long p = 1000000007;

        long[] fac = new long[n+ 1];
        fac[0] = 1;
        fac[1] = 1;
        //fac data 구하기
        for (int i = 2; i <=n; i++) {
            fac[i] = (fac[i - 1] * i) % p;
        }

        //분모 구하기
        long denominator = (fac[k] * fac[n-k]) % p;

        // denominatorK(분모의 K-2 제곱 구하기)
        long idx = p - 2;
        long denominatorK = 1;
        while (idx > 0) {
            //홀수이면
            if (idx % 2 == 1) {
                denominatorK *= denominator;
                denominatorK %= p;
            }
            denominator = (denominator * denominator) % p;
            idx /= 2;
        }
        long result = ((fac[n] % p) * (denominatorK % p)) % p;
        System.out.print(result);

    }
}
