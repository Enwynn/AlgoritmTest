
import java.util.Random;

/*
The sorting algorithm: https://users.cs.fiu.edu/~weiss/dsj2/code/Sort.java
The quicksort methods are originally written by Mark Allen Weiss.(Slightly modified)
 */

public class MAW_quicksort {
    private static final int CUTOFF = 10;

    public void initQuicksort( Comparable [ ] a ) { quicksort( a, 0, a.length - 1 ); }

    public final void swapReferences( Object [ ] a, int index1, int index2 ) {
        Object tmp = a[ index1 ];
        a[ index1 ] = a[ index2 ];
        a[ index2 ] = tmp;
    }

    private void quicksort( Comparable [ ] a, int low, int high ) {
        if (low + CUTOFF > high)
            insertionSort(a, low, high);
        else {
            // Sort low, middle, high
            int middle = (low + high) / 2;
            if (a[middle].compareTo(a[low]) < 0)
                swapReferences(a, low, middle);
            if (a[high].compareTo(a[low]) < 0)
                swapReferences(a, low, high);
            if (a[high].compareTo(a[middle]) < 0)
                swapReferences(a, middle, high);

            // Place pivot at position high - 1
            swapReferences(a, middle, high - 1);
            Comparable pivot = a[high - 1];

            // Begin partitioning
            int i, j;
            for (i = low, j = high - 1; ; ) {
                while (a[++i].compareTo(pivot) < 0) ;
                while (pivot.compareTo(a[--j]) < 0) ;
                if (i >= j)
                    break;
                swapReferences(a, i, j);
            }

            // Restore pivot
            swapReferences(a, i, high - 1);

            quicksort(a, low, i - 1);    // Sort small elements
            quicksort(a, i + 1, high);   // Sort large elements
        }
    }

    private void insertionSort( Comparable [ ] a, int low, int high )
    {
        for( int p = low + 1; p <= high; p++ )
        {
            Comparable tmp = a[ p ];
            int j;

            for( j = p; j > low && tmp.compareTo( a[ j - 1 ] ) < 0; j-- )
                a[ j ] = a[ j - 1 ];
            a[ j ] = tmp;
        }
    }

    void sort() {

        Random random = new Random();
        Comparable[] intArray = new Comparable[1000000];
        int n = intArray.length;

        for (int i = 0; i < n; i++) {
            intArray[i] = random.nextInt(1000);
        }

        long startTime = System.nanoTime();
        initQuicksort(intArray);
        long endTime = System.nanoTime();
        long duration = (endTime - startTime);
        double elapsedTimeInSecond = (double) duration / 1_000_000_000;
        System.out.println("The MAW_Quicksort algorithm successfully sorted the array.");
        System.out.println("QuickSort took: " + elapsedTimeInSecond + " seconds." + "\n");
    }


}












