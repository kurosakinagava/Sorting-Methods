import java.util.Scanner;

public class Task_1 {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] array = new int[n];

        for (int i = 0; i < n; i++) {
            array[i] = scn.nextInt();
        }
        quickSort(array, 0, n - 1);
        for (int i : array) {
            System.out.print(i + " ");
        }
    }
    private static void quickSort(int[] arr, int start, int end) {
        if (start < end) {
            int divideIndex = partition(arr, start, end);
            quickSort(arr, start, divideIndex - 1);
            quickSort(arr, divideIndex + 1, end);
        }
    }
    private static int partition(int[] arr, int start, int end) {
        int pivot = arr[start];
        int leftIndex = start + 1;
        int rightIndex = end;

        while (leftIndex <= rightIndex) {
            while (leftIndex <= rightIndex && arr[leftIndex] <= pivot) {
                leftIndex++;
            }

            while (leftIndex <= rightIndex && arr[rightIndex] > pivot) {
                rightIndex--;
            }

            if (leftIndex <= rightIndex) {
                int temp = arr[leftIndex];
                arr[leftIndex] = arr[rightIndex];
                arr[rightIndex] = temp;
            }
        }
        int temp = arr[start];
        arr[start] = arr[rightIndex];
        arr[rightIndex] = temp;

        return rightIndex;
    }
}
