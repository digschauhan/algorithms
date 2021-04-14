package src.com.algo;

import java.util.HashMap;

public class GridTraveller {

    public static void main(String[] args) {
        System.out.println(getTravellerPaths(18,18, new HashMap<String, Integer>()));
    }

    public static int getTravellerPaths(int m, int n, HashMap<String, Integer> memMap){

        if(memMap.containsKey(m+","+n)){
            return memMap.get(m+","+n);
        }
        if(m==1 && n==1){
            return 1;
        }
        if(m==0 || n==0){
            return 0;
        }

        int cnt = getTravellerPaths(m-1, n, memMap) + getTravellerPaths(m, n-1, memMap);
        memMap.put(m+","+n , cnt);

        return cnt;
    }
    
}
