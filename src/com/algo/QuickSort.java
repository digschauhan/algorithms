package src.com.algo;

public class QuickSort {
    
    public static void main(String[] args) {
        int[] usArr = {30, 4, 28, 100, 78, 65, 23, 38, 2, 7, 76, 56, 29};
        // Expected result : 2 , 4 , 7 , 23 , 28 , 29 , 30 , 38 , 56 , 65 , 76 , 78 , 100
        
        //int[] usArr = {85, 24, 63, 45, 17, 31, 96, 50};

        int len = usArr.length;
        Utils.printArray(quickSort(usArr, 0, len-1));
    }

    public static int[] quickSort(int[] arr, int startInd, int endInd){

        if(startInd <= endInd){
            int placeInd=startInd, cnt = startInd, pivotInd = endInd;

            for( ; cnt <= endInd ; cnt++ ){
                if(arr[cnt]<= arr[pivotInd]){
                    int t = arr[placeInd];
                    arr[placeInd] = arr[cnt];
                    arr[cnt] = t;
                    placeInd++;
                }
            }
            
            placeInd--;
            
            quickSort(arr, startInd, placeInd-1);
            quickSort(arr, placeInd+1, endInd);
        }
        return arr;
    }
}
