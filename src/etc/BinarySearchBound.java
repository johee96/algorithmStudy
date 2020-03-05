package etc;

public class BinarySearchBound {
    public static void main(String[] args) {

    }

    public static int lowerBound(int data[], int value) {
        int low = 0;
        int high = data.length;
        int mid = 0;
        while (low < high) {
            mid = (low + high) / 2;
            if (value <= data[mid]) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    public static int upperBound(int data[], int value) {
        int low = 0;
        int high = data.length;
        int mid = 0;
        while (low < high) {
            mid = (low + high) / 2;
            if (value >= data[mid]) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }
}
