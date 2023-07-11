package HomeWork2;

public class binHeap {
    public static void main(String[] args) {

        int arr[] = { 1, 14, 11, 5, 16, 7, 13, 9, 3, 12 };
        printArray(arr);
        sort(arr);
        printArray(arr);

    }

    public static void sort(int arr[]) {
        int n = arr.length;

        for (int i = n / 2 - 1; i >= 0; i--)
            heapify(arr, n, i);

        for (int i = n - 1; i >= 0; i--) {
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            heapify(arr, i, 0);
        }
    }

    public static void heapify(int arr[], int n, int i) {
        int pivot = i; 
        int l = 2 * i + 1; 
        int r = 2 * i + 2; 

        if (l < n && arr[l] > arr[pivot])
            pivot = l;

        if (r < n && arr[r] > arr[pivot])
            pivot = r;

        if (pivot != i) {
            int swap = arr[i];
            arr[i] = arr[pivot];
            arr[pivot] = swap;
            heapify(arr, n, pivot);
        }
    }

    public static void printArray(int arr[]) {
        int n = arr.length;
        for (int i = 0; i < n; ++i)
            System.out.print(arr[i] + " ");
        System.out.println();
    }
}