package src.com.algo;

public class KthHighest {

    public void printKthHighest(int[] nums, int n){

        int max=0;
        for(int i=0; i < nums.length; i++){
            max = Integer.max(max, nums[i]);
        }
    }
    public static void main(String[] args) {
        
    }
    
}
