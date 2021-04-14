package src.com.algo;

import java.util.ArrayList;
import java.util.HashMap;

public class BestSum {

    public static void main(String[] args) {
        //int[] arr = {2, 3, 5};
        //int[] arr = {7, 14};
        //int[] arr = {5, 3, 4, 7};
        int[] arr = {1, 2, 5, 25};

        int n = 28;
        ArrayList<Integer>[] mem = new ArrayList[n+1];

        //ArrayList<Integer> list = bestSum(28, arr, new HashMap<Integer, ArrayList<Integer>>());
        ArrayList<Integer> list = bestSum(n, arr, mem);
        //System.out.println(list.toArray());
        System.out.println(list.toString());

        //TODO : memoism not working , need to find bug and fix it
        
        
    }

    public static ArrayList<Integer> bestSum(int num, int[] arr, ArrayList<Integer>[] memMap){
        
        if(num==0){
            return new ArrayList<Integer>();
        }
        if(num<0){
            return null;
        }
        if(memMap[num]!=null){
            //System.out.println("found : " + num + "  : " + memMap.get(num).toString());
            return memMap[num];
        }


        //ArrayList<Integer> bestResult= new ArrayList<Integer>();
        ArrayList<Integer> bestResult= null;

        for(int val : arr){

            int diff = num - val;

            ArrayList<Integer> result = bestSum(diff, arr, memMap);
            
            if(result!=null){
                result.add(val);

                //System.out.println(result.size());
                if(bestResult == null || result.size() < bestResult.size()){
                    
                    //System.out.println(diff+ " =>> " + result.toString() + " vs " + (bestResult!=null?bestResult.toString():"null"));
                    bestResult = result;
                    
                }
                            
            }

        }
        
        memMap[num] = bestResult;
        //System.out.println(bestResult.toString());
        return bestResult;
    }
    
}
