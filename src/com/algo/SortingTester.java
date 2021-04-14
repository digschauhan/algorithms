package src.com.algo;

import java.util.ArrayList;
import java.util.Collections;

public class SortingTester {

    public static void main(String[] args) {
      
        int[] usArr = {30, 4, 28, 100, 78, 65, 23, 38, 2, 7, 76, 56, 29, 50, 88, 10};
        // Expected result : 2, 4, 7, 10, 23, 28, 29, 30, 38, 50, 56, 65, 76, 78, 88, 100

        SortingTester tester = new SortingTester();
        //tester.testSelectionSort(usArr);
        
        tester.testQuickSort(usArr);

    }

    public int[] testSelectionSort(int[] usArr){

        System.out.println("Sorting using Selection Sort ....\n");
        Utils.printArray(usArr);

        long startTime = System.nanoTime();
        int[] sortedArr = SelectionSort.selectionSort(usArr);
        long endTime = System.nanoTime();

        Utils.printArray(sortedArr);
       
        System.out.println("\nTime Taken : " + (endTime - startTime) + " nano seconds");

        return sortedArr;

    }

    public int[] testQuickSort(int[] usArr){
        System.out.println("Sorting using Quick Sort ....\n");
        long startTime = System.nanoTime();
        int[] sortedArr = QuickSort.quickSort(usArr, 0 , usArr.length -1);
        long endTime = System.nanoTime();

        Utils.printArray(sortedArr);
       
        System.out.println("\nTime Taken : " + (endTime - startTime) + " nano seconds");

        return sortedArr;

    }
    
}
