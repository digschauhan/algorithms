package src.com.algo;

import java.util.ArrayList;

public class MaxAbsoluteDiff {

    public int maxArr(ArrayList<Integer> A) {
        
        int max1 = Integer.MIN_VALUE;
        int max2 = Integer.MIN_VALUE;
        int min1 = Integer.MAX_VALUE;
        int min2 = Integer.MAX_VALUE;
        
        int size = A.size();
        int ans = 0;
        
        for(int i=0; i<size ; i++){
            
            max1 = Integer.max(max1, A.get(i) + i);
            max2 = Integer.max(max2, A.get(i) - i );
            min1 = Integer.min(min1, A.get(i) + i );
            min2 = Integer.min(min2, A.get(i) - i );
            
            
        }
        
        ans = Integer.max(ans, max1 - min1);
        ans = Integer.max(ans, max2 - min2);
        
        return ans;
    }

    
}
