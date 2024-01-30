import java.util.Scanner;

public class Task_3 {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }
        sort(arr);

        for (int i : arr) {
            System.out.print(i + " ");
        }
        scn.close();
    }
    public static void sort(int[] arr) {

        sort(arr, 0, arr.length - 1);
    }
    private static void sort(int[] arr, int start, int end) {
        if (start < end) {
            int middle = (start + end) / 2;
            sort(arr, start, middle);
            sort(arr, middle + 1, end);

            merge(arr, start, end, middle);
        }
    }
    public static void merge(int[] arr, int start, int end, int middle) {
        int leftSize = middle - start + 1;
        int rightSize = end - middle;

        int[] left = new int[leftSize];
        int[] right = new int[rightSize];

        for (int i = 0; i < leftSize; i++) {
            left[i] = arr[start + i];
        }
        for (int j = 0; j < rightSize; j++) {
            right[j] = arr[middle + 1 + j];
        }

        int i = 0, j = 0, k = start;
        while (i < leftSize && j < rightSize) {
            if (left[i] <= right[j]) {
                arr[k++] = left[i++];
            } else {
                arr[k++] = right[j++];
            }
        }

        while (i < leftSize) {
            arr[k++] = left[i++];
        }

        while (j < rightSize) {
            arr[k++] = right[j++];
        }
    }
}
