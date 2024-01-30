import java.util.Scanner;

public class Task_4 {
    public static void heapSort(int[] arr, int n) {
        for (int i = n/2 - 1; i >= 0; i--) {
            heapify(arr, n, i);
        }

        for (int i = n - 1; i >= 0; i--) {
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
            heapify(arr, i, 0);
        }
    }

    public static void heapify(int[] arr, int n, int i) {
        int largest = i;
        int l = 2 * i + 1;
        int r = 2 * i + 2;

        if ((l < n) && arr[l] > arr[largest]) largest = l;
        if ((r < n) && arr[r] > arr[largest]) largest = r;

        if (largest != i) {
            int temp = arr[i];
            arr[i] = arr[largest];
            arr[largest] = temp;
            heapify(arr, n, largest);
        }
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] array = new int[n];

        for (int i = 0; i < n; i++) {
            array[i] = scn.nextInt();
        }
        heapSort(array, array.length);

        for (int i : array) {
            System.out.print(i + " ");
        }
    }
}

