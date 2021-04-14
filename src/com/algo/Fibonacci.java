package src.com.algo;

import java.util.HashMap;

public class Fibonacci {

    public static void main(String[] args) {
        //System.out.println(fibo(6));
        
        System.out.println(fibo(50, new HashMap<Long, Long>()));
    
    }

    public static long fibo(long n, HashMap<Long, Long> memMap){
        
        if(memMap.get(n)!=null){
            return memMap.get(n).longValue();
        }
        if(n<=1){
            memMap.put(n, n);
            return n;
        }

        long fibo = fibo(n-1, memMap) + fibo(n-2, memMap);
        memMap.put(n, fibo);
        return fibo;

    }
    
}
