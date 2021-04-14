package src.com.algo;

import java.util.ArrayList;
import java.util.HashMap;

public class HowSum {

    public static void main(String[] args) {
        //int[] arr = {2, 3};
        //int[] arr = {7, 14};
        int[] arr = {5, 3, 4, 7};

        ArrayList<Integer> list = howSum(7, arr, new HashMap<Integer, ArrayList<Integer>>());
        //System.out.println(list.toArray());
        

        for(Integer i : list ){
            System.out.println(i);
        }
        
    }

    public static ArrayList<Integer> howSum(int num, int[] arr, HashMap<Integer,ArrayList<Integer>> memMap){
        
        ArrayList<Integer> result= null;
        if(num==0){
            return new ArrayList<Integer>();
        }
        if(num<0){
            return null;
        }
        if(memMap.containsKey(num)){
            return memMap.get(num);
        }

        for(int val : arr){
            int diff = num - val;

            result = howSum(diff, arr, memMap);
            
            if(result!=null){
                memMap.put(num, result);
                result.add(val);
                return result;
            }

        }
        memMap.put(num, result);
        return result;
    }
    
}
