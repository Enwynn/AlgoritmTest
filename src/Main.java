
import java.util.Random;


public class Main {

    public static void main(String[] args) {

        //  1 million int elements in an int array, range between 0-1000.
        QuickSort qs = new QuickSort();
        qs.sort();

        //  1 million int elements in an comparable array, range between 0-1000.
        MAW_quicksort maw_qs = new MAW_quicksort();
        maw_qs.sort();

    }
}
