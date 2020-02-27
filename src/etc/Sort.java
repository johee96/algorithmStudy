package etc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Sort {
    public static void main(String[] args) {

        //69, 10, 30, 2, 16, 8, 31, 22
        int data[] = {66, 10, 1, 99, 5, 23, 2};

        RadixSort.radixSort(data);

        for (int i = 0; i < data.length; i++) {
            System.out.println("data[" + i + "] : " + data[i]);
        }

    }

    public static void SelectionSort(int data[]) {
        int min;
        int tmp;
        for (int i = 0; i < data.length - 1; i++) {
            min = i;
            for (int j = i + 1; j < data.length; j++) {
                if (data[j] < data[min]) {
                    min = j;
                }
            }
            if (data[min] < data[i]) {
                tmp = data[i];
                data[i] = data[min];
                data[min] = tmp;
            }
        }
    }

    public static void InsertionSort(int data[]) {
        int tmp;
        int j = 0;
        for (int i = 1; i < data.length; i++) {
            tmp = data[i];
            for (j = i - 1; j >= 0 && data[j] > tmp; j--) {
                data[j + 1] = data[j];
            }
            data[j + 1] = tmp;
        }
    }


    public static void BubbleSort(int data[]) {
        int tmp;
        for (int i = data.length - 1; i >= 0; i--) {
            for (int j = 0; j < i; j++) {
                if (data[j] > data[j + 1]) {
                    tmp = data[j];
                    data[j] = data[j + 1];
                    data[j + 1] = tmp;
                }
            }
        }
    }

    public static class QuickSort {
        public static void quickSort(int data[], int low, int high) {
            if (low >= high) {
                return;
            }
            int mid = partition(data, low, high);
            quickSort(data, low, mid - 1);
            quickSort(data, mid, high);
        }

        static int partition(int data[], int low, int high) {
            int pivot = data[(low + high) / 2];
            while (low <= high) {
                while (data[low] < pivot) low++;
                while (data[high] > pivot) high--;

                if (low <= high) {
                    swap(data, low, high);
                    low++;
                    high--;
                }
            }
            return low;
        }

        static void swap(int data[], int a, int b) {
            int tmp = data[a];
            data[a] = data[b];
            data[b] = tmp;
        }
    }

    public static class Merge {
        public static void mergeSort(int data[], int low, int high) {
            if (low >= high) {
                return;
            }
            int mid = (low + high) / 2;
            mergeSort(data, low, mid);
            mergeSort(data, mid + 1, high);
            merge(data, low, mid, high);
        }

        public static void merge(int data[], int low, int mid, int high) {
            int[] tmp = new int[data.length];
            int l = low;   // 첫 번째 부분집합의 시작 위치
            int h = mid + 1;  // 두 번째 부분집합의 시작 위치
            int idx = low;   // 배열 tmp 정렬된 원소를 저장할 인덱스
            while (l <= mid && h <= high) {
                if (data[l] <= data[h]) {
                    tmp[idx] = data[l];
                    l++;
                } else {
                    tmp[idx] = data[h];
                    h++;
                }
                idx++;
            }
            if (l > mid) {
                for (int i = h; i <= high; i++, idx++) {
                    tmp[idx] = data[i];
                }
            } else {
                for (int i = l; i <= mid; i++, idx++) {
                    tmp[idx] = data[i];
                }
            }
            for (int i = low; i <= high; i++) {
                data[i] = tmp[i];
            }
        }
    }

    public static class HeapSort {
        private static void heapify(int arr[], int length, int i) {
            int left = 2 * i + 1;
            int right = 2 * i + 2;
            int temp, largest = i;
            if (left < length && arr[left] > arr[largest]) {
                largest = left;
            }
            if (right < length && arr[right] > arr[largest]) {
                largest = right;
            }
            if (largest != i) {
                temp = arr[i];
                arr[i] = arr[largest];
                arr[largest] = temp;
                heapify(arr, length, largest);
            }
        }

        private static void heapSort(int arr[]) {
            int i, temp;
            int length = arr.length;
            for (i = length / 2 - 1; i >= 0; i--) {
                heapify(arr, length, i);
            }
            for (i = length - 1; i >= 0; i--) {
                temp = arr[0];
                arr[0] = arr[i];
                arr[i] = temp;
                heapify(arr, i, 0);
            }
        }
    }

    public static class RadixSort {
        public static void radixSort(int[] data) {
            int maxSize = getMaxSize(data);
            ArrayList<Queue> bucket = new ArrayList<>();
            int powed = 1;
            for(int i=0;i<10;i++) {
                bucket.add(new LinkedList());
            }
            for(int i=0;i<maxSize;i++){
                for(int j=0;j<data.length;j++){ //각 자리수에 맞는 인덱스의 버킷에 넣는다.
                    bucket.get((data[j]/powed)%10).offer(data[j]);
                }

                //버킷에서 뺀다.
                for(int j=0, idx=0;j<data.length;){
                    while(!bucket.get(idx).isEmpty()){
                        data[j++] = (int) bucket.get(idx).poll();
                    }
                    idx++;
                }
                powed *=10;
            }
        }
        public static int getMaxSize(int[] arr) {
            int maxSize = 0;
            for (int i = 0; i < arr.length; i++) {
                int tmp = (int) Math.log10(arr[i]) + 1;
                if (tmp > maxSize)
                    maxSize = tmp;
            }
            return maxSize;
        }
    }
}
