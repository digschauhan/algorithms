package src.com.algo;

import java.util.*;

public class SubArraySumK {

    public int subarraySum(int[] nums, int k) {
        
        int sum = 0, cnt =0 ;
        int[] sumArr = new int[nums.length + 1];
        sumArr[0]=1;

        for(int i=0; i<nums.length; i++){
            sum = sum + nums[i];
            sumArr[i+1] = sum;
        }
        for(int i=0; i<sumArr.length;i++){

        }
        return cnt;
    }

    public int subarraySumCorrectOne(int[] nums, int k) {
        int count = 0, sum = 0;
        HashMap < Integer, Integer > map = new HashMap < > ();
        map.put(0, 1);
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (map.containsKey(sum - k))
                count += map.get(sum - k);
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return count;
    }

    public static void main(String[] args) {
        //Input: nums = [1,1,1], k = 2
        //Output: 2

        //[1,2,1,2,1] k=3 , output = 4

        int[] nums = {-1,-1,1};
        int k = 0;
        //SubArraySumK sa = new SubArraySumK();
        //System.out.println(sa.subarraySum(nums, k));
        System.out.println(25* Math.random());
    }
    

    // public int subarraySum(int[] nums, int k) {
    //     ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>(k+1);
    //     list.addAll(null);

    //     list.add(0, new ArrayList<Integer>());
    //     for(int i=0; i<=k; i++){
    //         for(int j=0;j<nums.length;j++){
    //             if(list.get(i) !=null){
    //                 if(i+j < k+1){
    //                     list.get(i).add(nums[j]);
    //                     list.add(i+j, list.get(i));
    //                 }
                    
    //             }
    //         }
    //     }


    // }
}
