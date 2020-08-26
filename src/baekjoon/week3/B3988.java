package baekjoon.week3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.StringTokenizer;
public class B3988 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] data = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            data[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(data);

        Deque<DataGap> deque = new ArrayDeque<>(); // 데이터 차이 값을 넣을 큐
        int dataGapUnit = n - k - 1;         //데이터 차이 값을 넣을 큐에서 슬라이딩 할 데이터 개수(범위)
        //슬라이딩 할 데이터 개수(범위)는 n(전체)-k(제거)-1(데이터의 차이를 넣을 것이기 떼문에 개수 하나 줄음)
        int result = data[n - 1] - data[0];

        for (int i = 0; i < n - 1; i++) {
            DataGap d = new DataGap(i, data[i + 1] - data[i]);
            //최소값을 구하는 범위(i-dataGapUnit)를 넘었을 때, 오래된 것 제거하기
            if (!deque.isEmpty() && deque.peekFirst().startIdx <= i - dataGapUnit) {
                deque.removeFirst();
            }

            //새로 들어온 차이 값보다 더 큰 차이값이 있으면 제거 -> 그 범위에서의 최소값을 구할 때 제거된 값은 최소값이 될 수 없으니까
            while (!deque.isEmpty() && deque.peekLast().value > d.value) {
                deque.removeLast();
            }
            deque.addLast(d);

            if (i + 1 >= dataGapUnit) {
                int M = data[i + 1] - data[i + 1 - dataGapUnit];
                result = Math.min(result, deque.peekFirst().value + M);
            }
        }
        System.out.println(result);
    }

    //DataGap은 시작 인덱스(i)와 차이 값으로 구성되어있다.
    private static class DataGap {
        int startIdx;       //data[i]와 data[i+1]가 있을 때 앞에 있는 data의 인덱스가 startIdx
        int value;          //data[i]와 data[i+1의 차이가 value

        public DataGap(int startIdx, int value) {
            this.startIdx = startIdx;
            this.value = value;
        }
    }
}
/*
tc
5 2
0 2 3 9999 10000

5 2
-3 -2 3 8 6
 */