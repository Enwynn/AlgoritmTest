import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Random;

public class ListsToSort {
    Random random = new Random();
    int[] intArray = new int[1000000];
    LinkedList<Integer> intList = new LinkedList<Integer>();


    public ListsToSort(int[] intArray, List<Integer> intList) {
    initListWithLargeCollection();
    }

    private void initListWithLargeCollection() {
        int n = intArray.length;
        for(int i = 0; i < n; i++) {
            int temp = random.nextInt(10000);
            intArray[i] = temp;
            intList.add(temp);
        }
        }


}
