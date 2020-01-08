package swexpert.D5;

import java.util.ArrayList;
import java.util.Scanner;

public class 수정이의타일자르기_SW1812 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();
        for (int t = 1; t <= tc; t++) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            ArrayList<Integer> dataN = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                int v = sc.nextInt();
                if (!dataN.contains(v))
                    dataN.add(v);
                else {
                    dataN.remove(Integer.valueOf(v));
                    dataN.add(v + 1);
                }
            }
            int nSum = dataNSum(dataN);
            int mSum = dataMSum(m);
            int result = check(nSum, mSum);

            System.out.println("#"+t+" "+result);


        }
    }

    private static int dataNSum(ArrayList<Integer> dataN) {
        int dataNSum = 0;
        for (int i = 0; i < dataN.size(); i++)
            dataNSum += dataN.get(i);
        System.out.println("dataNsum: "+dataNSum);
        return dataNSum;
    }

    private static int dataMSum(int m) {
        int sum = 0;
        while (m > 1) {

            int index = 1;
            int tmp = m;
            while (true) {
                if (tmp < Math.pow(2, index))
                    break;
                index++;
            }

            sum += index-1;
            m -= Math.pow(2, index);

        }
        System.out.println("dataMSum: "+sum);

        return sum;
    }

    private static int check(int nSum, int mSum) {
        int result = 1;
        while (true) {
            if (nSum <= mSum * result)
                break;
            result++;
        }

        System.out.println("result: "+result);

        return result;
    }
}
