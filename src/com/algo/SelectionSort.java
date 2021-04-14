package src.com.algo;


public class SelectionSort {

    public static void main(String[] args) {
        long startTime = System.nanoTime();

        int[] usArr = {30, 4, 28, 100, 78, 65, 23, 38, 2, 7, 76, 56, 29};
        // Expected result : 2 , 4 , 7 , 23 , 28 , 29 , 30 , 38 , 56 , 65 , 76 , 78 , 100

        Utils.printArray(usArr);
        Utils.printArray(selectionSort(usArr));

        long endTime = System.nanoTime();
        System.out.println("\nTime Taken : " + (endTime - startTime) + " nano seconds");

    }

    static int[] selectionSort(int[] usArr){
        
        int i = 0, j=0, min_ind=0;
        int len = usArr.length;

        for(; i < (len -1) ; i++){
            
            for(j=i+1 , min_ind = i;  j<len; j++){
                if(usArr[j] < usArr[min_ind]){
                    min_ind = j;
                }

            }
            if(usArr[i] != usArr[min_ind]){
                int t = usArr[i];
                usArr[i] = usArr[min_ind];
                usArr[min_ind] = t;
            }
        }
        
        return usArr;
    }

}
