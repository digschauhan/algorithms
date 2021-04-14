package src.com.algo;

public class MergeSort {

    public static void main(String[] args) {
        int[] usArr = {30, 4, 28, 100, 78, 65, 23, 38, 2, 7, 76, 56, 29};
        // Expected result : 2 , 4 , 7 , 23 , 28 , 29 , 30 , 38 , 56 , 65 , 76 , 78 , 100
        
        //int[] usArr = {85, 24, 63, 45, 17, 31, 96, 50};
        Utils.printArray(usArr);

        int len = usArr.length;
        Utils.printArray(mergeSort(usArr, 0, len-1));
    }

    public static int[] mergeSort(int[] arr, int low, int high){
        int mid = (low + high)/2;

        if(low<high){

            int[] lArr = new int[(mid - low) + 1];
            int[] rArr = new int[(high - (mid+1) ) + 1];

            System.arraycopy(arr, low, lArr, 0, lArr.length);
            System.arraycopy(arr, mid+1, rArr, 0, rArr.length);
            
            lArr = mergeSort(lArr, 0, lArr.length-1);
            rArr = mergeSort(rArr, 0, rArr.length-1);
            arr = merge(lArr, rArr);
        }

        return arr;
    }
    public static int[] merge(int[] lArr, int[] rArr ){

        int[] arr = new int[lArr.length+rArr.length];

        int i=0,j=0;
        for(int ind=0 ; i<lArr.length || j<rArr.length; ind++){
            if( i<lArr.length && j<rArr.length){
                if(lArr[i]<rArr[j]){
                    arr[ind] = lArr[i];
                    i++;
                }else{
                    arr[ind] = rArr[j];
                    j++;
                }
                
            }else if(i < lArr.length && j >= rArr.length){
                arr[ind] = lArr[i];
                i++;
            }else if(j < rArr.length && i >= lArr.length){
                arr[ind] = rArr[j];
                j++;
            }
        }
        return arr;
    }
    
}
