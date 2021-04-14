package src.com.algo;

import java.util.ArrayList;

public class MinStepInInfiniteGrid {

    public int coverPoints(ArrayList<Integer> A, ArrayList<Integer> B) {
        int x1=0, y1=0, x2=0, y2=0;
        int steps = 0;
        
        if(A.size()==1){
            return 0;
        }
        
        for(int i=0; i<A.size()-1; i++){
            
            x1=A.get(i);
            y1=B.get(i);
            
            x2=A.get(i+1);
            y2=B.get(i+1);

            steps = steps + ( Integer.max(Math.abs(x1-x2) , Math.abs(y1-y2) ) );
            
        }
        return steps;
    }
    
}
