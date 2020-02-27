package etc;

public class Sort {
    public static void main(String[] args) {

        //69, 10, 30, 2, 16, 8, 31, 22
        int data[] = {66, 10, 1, 99, 5, 23, 2};

        QuickSort.quickSort(data, 0, data.length - 1);

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

}
