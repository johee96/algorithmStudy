package baekjoon.week1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class B1181 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<String> data = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String value = sc.next();
            if (!data.contains(value))
                data.add(value);
        }
        Collections.sort(data, (o1, o2) -> {
            Integer v1 = o1.length();
            Integer v2 = o2.length();
            if (v1 == v2)
                return o1.compareTo(o2);
            return v1 - v2;
        });
        for (int i = 0; i < data.size(); i++) {
            System.out.println(data.get(i));
        }

    }
}

