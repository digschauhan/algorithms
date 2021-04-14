package src.com.algo;

import java.util.Arrays;
import java.util.LinkedList;

public class MergeIntervals {

    public int[][] merge(int[][] intervals) {
     
        int compWith=0, newLen=1;

        LinkedList<int[]> list = new LinkedList();
        
        Arrays.sort(intervals, (a,b)->Integer.compare(a[0], b[0]) );

        list.add(intervals[0]);
        for(int i=1; i<intervals.length ; i++){

            if( intervals[i][0] <= list.getLast()[1] ){
                //Overlap
                list.getLast()[1] = Math.max(intervals[i][1], list.getLast()[1]);
            }else{
                //No overlap
                list.addLast(intervals[i]);
            }
        }

             
 
        return list.toArray(new int[list.size()][]);
    }

    public static void main(String[] args) {

        //int[][] arr = {{1,3},{2,6},{8,10},{15,18}};
        //int[][] arr = {{1,4},{0,0}};
        int[][] arr = {{2,3},{4,5},{6,7},{8,9},{1,10}};

        MergeIntervals mi = new MergeIntervals();

        int[][] retArr = mi.merge(arr);
        for(int i=0; i< retArr.length;i++){
            System.out.println(retArr[i][0] + "," + retArr[i][1]);
        }
        
    }
    
}
