package baekjoon.week6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class B1181 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        ArrayList<String> data = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String v = br.readLine();
            if (!data.contains(v))
                data.add(v);
        }
        Collections.sort(data, (o1, o2) -> {
            if (o1.length() == o2.length()) {
                return o1.compareTo(o2);
            }
            return o1.length() - o2.length();
        });

        for (int i = 0; i < data.size(); i++) {
            System.out.println(data.get(i));
        }
    }
}

/*
//todo 정리하기
- 중복제거는 set을 사용하는 것이 훨씬 빠르다.
public class Main {
    public static void main(String[] args) { Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Set<String> setData = new HashSet<>();
        for (int i = 0; i < n; i++) {
            String value = sc.next();
            setData.add(value);
        }
        ArrayList<String> data = new ArrayList<>(setData);

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


 */