package baekjoon.week6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B2751 {
    static int n;
    static int[] data;
    static int[] tmp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        data = new int[n];
        data = new int[n];
        for (int i = 0; i < n; i++) {
            data[i] = Integer.parseInt(br.readLine());
        }
        mergeSort();

        for (int i = 0; i < n; i++) {
            System.out.println(data[i]);
        }
    }

    private static void mergeSort() {
        partition(0, n - 1);
    }

    private static void partition(int start, int end) {
        if (start >= end)
            return;
        int mid = (start + end) / 2;

        partition(start, mid);
        partition(mid + 1, end);
        merge(start, mid, end);
    }

    private static void merge(int start, int mid, int end) {
        int idx = start;
        int low = start;
        int high = mid + 1;

        //새로운 배열 tmp에 정렬해서 넣는다.
        while (low <= mid && high <= end) {
            if (data[low] <= data[high]) {
                tmp[idx] = data[low];
                low++;
            } else {
                tmp[idx] = data[high];
                high++;
            }
            idx++;
        }
        //남는 부분 처리하기
        while (low <= mid) {
            tmp[idx] = data[low];
            low++;
            idx++;
        }

        while (high <= end) {
            tmp[idx] = data[high];
            high++;
            idx++;
        }

        for (int i = start; i <= end; i++)
            data[i] = tmp[i];
    }



    /* todo 정리하
    병합 정렬을 할 때, merge를 수행할 때마다 배열의 전체 크기, 혹은 right만큼을 할당하고 해제하기를 반복하면 안 됩니다.
    크기가 N인 메모리를 할당하는 것은 O(N) 시간이 걸리고, merge가 O(N)번 호출되기 때문에 총 시간복잡도가 O(N^2)이 됩니다.
    이를 해결하기 위한 방법으로는, 복사를 하기 위한 큰 배열 하나를 미리 할당해두고 계속 사용
     */

    /*
    퀵 정렬은 최악의 경우 O(N^2)입니다.
    평균 시간복잡도는 O(NlogN)이지만, 평범하게 구현한 퀵 정렬은 매우 단순한 방법으로 최악의 케이스의 시간복잡도인 O(N^2)을 만들 수 있습니다.
    단순히 이미 정렬이나 역정렬된 상태로만 입력이 주어져도 퀵 정렬이 감당할 수 없습니다.
     */
    private static void quickSort(int start, int end) {
        int left = start;
        int right = end;
        int pivot = (start + end) / 2;

        while (left <= right) {
            while (data[pivot] > data[left])
                left++;

            while (data[pivot] < data[right])
                right--;

            //swap
            if (left <= right) {
                int tmp = data[left];
                data[left] = data[right];
                data[right] = tmp;

                left++;
                right--;
            }

            if (left < end) {
                quickSort(left, end);
            }

            if (right > start) {
                quickSort(start, right);
            }
        }
    }


}
