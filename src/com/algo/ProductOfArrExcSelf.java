package src.com.algo;

import java.util.HashMap;

public class ProductOfArrExcSelf {

    HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

    public int[] productExceptSelf(int[] nums) {
        
        int zeros = 0;

        int product = Integer.MIN_VALUE;

        for(int i=0; i < nums.length; i++){
            if(nums[i] == 0){
                zeros++;
            }else{
                if(product == Integer.MIN_VALUE){
                    product = nums[i];
                }else{
                    product = product * nums[i];
                }
                
            }
            
        }

        System.out.print("Product :" +  product);

        int[] prod = new int[nums.length];
        for(int i=0; i < nums.length; i++){
            if(nums[i]==0){
                prod[i] =  (product==Integer.MIN_VALUE? 0 : (zeros>1? 0 :product) );
            }else{
                if(zeros > 0){
                    prod[i] =  0;
                }else{
                    prod[i] = product / nums[i];
                }
                
            }
            
        }

        return prod;
    }

    public static void main(String[] args) {
        // Input: nums = [1,2,3,4]
        // Output: [24,12,8,6]
        
        //Input: nums = [-1,1,0,-3,3]
        //Output: [0,0,9,0,0]        


        //int[] nums = {1, 2, 3, 4};
        int[] nums = {-1, 1, 0, -3, 3};

        ProductOfArrExcSelf p = new ProductOfArrExcSelf();

        for(int i : p.productExceptSelf(nums)) System.out.println(i + ", ");

    }
    
}
