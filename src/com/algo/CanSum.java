package src.com.algo;

import java.util.HashMap;

public class CanSum {

    public static void main(String[] args) {
        //int[] arr = {2, 3};
        int[] arr = {7, 14};
        //int[] arr = {5, 3, 4, 7};

        System.out.println(canSum(700, arr, new HashMap<Integer, Boolean>()));
    }

    public static boolean canSum(int num, int[] arr, HashMap<Integer,Boolean> memMap){
        
        boolean result=false;
        if(num==0){
            return true;
        }
        if(num<0){
            return false;
        }
        if(memMap.containsKey(num)){
            return memMap.get(num);
        }

        for(int val : arr){
            int diff = num - val;
            result = canSum(diff, arr, memMap);

            memMap.put(num, result);
            if(result){
                return result;
            }

        }
        memMap.put(num, result);
        return result;
    }
    
}
