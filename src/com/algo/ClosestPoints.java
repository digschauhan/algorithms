package src.com.algo;

import java.util.ArrayList;
import java.util.Collections;

public class ClosestPoints {

    
    public int[][] kClosest(int[][] points, int k) {
        ArrayList<PointDistance> list = new ArrayList<PointDistance>();

        for(int i=0; i< points.length; i++){
            list.add(new PointDistance(points[i]));
        }

        Collections.sort(list);

        int[][] retArr = new int[k][2];
        for(int i=0; i<k; i++){
            retArr[i] = list.get(i).point;
        }
        return retArr;
        
    }

    class PointDistance implements Comparable<PointDistance>{
        int[] point;
        double distance=0;

        public PointDistance(int[] points){
            this.point = points;
            distance = Math.sqrt( (0-point[0]) * (0-point[0] ) + (0-point[1]) * (0-point[1]) );
        }


        @Override
        public int compareTo(PointDistance o) {
            
            if(this.distance == o.distance) return 0;

            if(this.distance < o.distance){
                return -1;
            }else{
                return 1;
            }
            

        }
    }


    public static void main(String[] args) {
        //Input: points = [[1,3],[-2,2]], k = 1
        // Output: [[-2,2]]

        int[][] arr = {{1,3},{-2,2}};
        int k = 1;

        ClosestPoints cp = new ClosestPoints();
        
        int[][] rep = cp.kClosest(arr, k);

        for(int i=0; i< rep.length; i++){
            System.out.println(rep[i][0] + " , " + rep[i][1]);
        }

    }
    
}
