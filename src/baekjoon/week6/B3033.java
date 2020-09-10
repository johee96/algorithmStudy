package baekjoon.week6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class B3033 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(br.readLine());
        int maxLen = 0;
        String value = br.readLine();
        String[] str = new String[size];

        for (int i = 0; i < size; i++) {
            str[i] = value.substring(i, size);
        }
        Arrays.sort(str);
        for (int i = 0; i < size - 1; i++) {
            if (str[i + 1].length() >= str[i].length()
                    && str[i + 1].substring(0, str[i].length()).equals(str[i]))
                maxLen = Math.max(maxLen, str[i].length());

        }
        System.out.print(maxLen);
    }
}


/*
package baekjoon.week6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;

public class B3033 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(br.readLine());
        int maxLen = 0;
        String value = br.readLine();
        String[] str = new String[size];

        for (int i = 0; i < size; i++) {
            str[i] = value.substring(i, size);
        }
        Arrays.sort(str);
        for (int i = 0; i < size - 1; i++) {
            if (str[i + 1].length() >= str[i].length()
                    && str[i + 1].substring(0, str[i].length()).equals(str[i]))
                maxLen = Math.max(maxLen, str[i].length());

        }
        System.out.print(maxLen);
    }
}

 */