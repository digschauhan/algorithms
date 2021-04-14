package src.com.algo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.TreeSet;

public class ContiLargestArrSum {

    public static void main(String[] args) {
        ArrayList<Integer> l = new ArrayList<Integer>();
        l.add(-400);
        l.add(-500);
        l.add(-1);
        l.add(0);

        Integer[] arr = new Integer[l.size()];

        l.toArray(arr);
        
        //System.out.println(Collections.max(l)); 
        
        for(Iterator it = l.iterator(); it.hasNext();){
            if(it.next().equals( Integer.valueOf(0))){
                System.out.println("Zero value..");
            }
        }
    }


    public int maxSubArray(final ArrayList<Integer> A) {
        int max=Integer.MIN_VALUE;
        
        int sum=0;
        
        
        if(A == null || A.size() == 0){
            return 0;
            
        }else if(A.size() == 1){
                return A.get(0);
        }
        
        
        
        if (Collections.max(A) < 0){
            return Collections.max(A);
        }
        
        
        for(int val : A){
            
                sum += val;
                
                sum = Integer.max(sum, val);
                
                max = Integer.max(max, sum);
        }
        return max;
    
    }
}

