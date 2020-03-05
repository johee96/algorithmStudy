package baekjoon.binarysearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class B10816 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] dataA = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            dataA[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(dataA);
        StringBuilder sb = new StringBuilder();
        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            int value = Integer.parseInt(st.nextToken());
            int result = find(dataA, 0, dataA.length - 1, value);
            sb.append(result + " ");
        }
        System.out.print(sb.toString());

    }

    static int find(int[] data, int start, int end, int target) {
        int result = 0;
        if (start > end)
            return 0;

        int mid = (start + end) / 2;
        if (target < data[mid]) {
            return find(data, start, mid - 1, target);
        } else if (target > data[mid]) {
            return find(data, mid + 1, end, target);
        } else {
            result += 1;
            result += find(data, start, mid - 1, target);
            result += find(data, mid + 1, end, target);

        }

        return result;
    }

    /* 풀이 방법 2.
        public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        TreeMap<Integer, Integer> dataA = new TreeMap<Integer, Integer>(); //key를 기준으로 정렬을 해주는 map이다.
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int value = Integer.parseInt(st.nextToken());
            if (!dataA.containsKey(value))
                dataA.put(value, 1);
            else
                dataA.put(value, dataA.get(value) + 1);
        }

        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
           int value = Integer.parseInt(st.nextToken());
            if (!dataA.containsKey(value))
                System.out.print(0+" ");
            else
                System.out.print(dataA.get(value)+" ");
        }
    }
     */

}
