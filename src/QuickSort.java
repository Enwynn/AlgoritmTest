

/*
Link: https://www.geeksforgeeks.org/quick-sort/
This quicksort algorithm is from GeeksforGeeks.(Slightly modified)
 */

import java.util.Random;

public class QuickSort<AnyType extends Comparable<? super AnyType>> {

    int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = (low - 1); // index of smaller element
        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i++;

                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1;
    }


    void sorting(int arr[], int low, int high) {
        if (low < high) {

            int pi = partition(arr, low, high);

            sorting(arr, low, pi - 1);
            sorting(arr, pi + 1, high);
        }
    }

    void sort() {

        Random random = new Random();
        int[] intArray = new int[1000000];
        int n = intArray.length;

        for (int i = 0; i < n; i++) {
            intArray[i] = random.nextInt(1000);
        }

        long startTime = System.nanoTime();
        sorting(intArray, 0, n - 1);
        long endTime = System.nanoTime();
        long duration = (endTime - startTime);
        double elapsedTimeInSecond = (double) duration / 1_000_000_000;
        System.out.println("The Quicksort algorithm successfully sorted the array.");
        System.out.println("QuickSort took: " + elapsedTimeInSecond + " seconds.");
    }


}


