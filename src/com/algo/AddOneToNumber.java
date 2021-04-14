package src.com.algo;

import java.util.ArrayList;
import java.util.Iterator;

public class AddOneToNumber {

    public ArrayList<Integer> plusOne(ArrayList<Integer> A) {
        
        ArrayList<Integer> temp = new ArrayList<Integer>();
        ArrayList<Integer> result = new ArrayList<Integer>();
        
        int digit=0, carry=0;
        
        for(int i = A.size()-1; i>=0; i--){
            
            digit = A.get(i);
            
            if(i == A.size()-1){
                digit = digit + 1;
                if(digit>9){
                    digit = 0;
                    carry = 1;
                    temp.add(digit);
                }else{
                    temp.add(digit);
                }
            }else{
                digit = digit + carry;
                
                if(digit>9){
                    digit = 0;
                    carry = 1;
                    temp.add(digit);
                }else{
                    temp.add(digit);
                    carry=0;
                }
                
            }
            
            
        }
        if(carry == 1){
            temp.add(carry);
        }
        
        for(int i = temp.size()-1; i>=0; i--){
            
            
            result.add(temp.get(i));
            
        }
        
        
        for(Iterator it = result.iterator() ; it.hasNext(); ){
            if( it.next().equals( Integer.valueOf(0)) ){
                it.remove();
            }else{
                break;
            }
        }
        
        
        return result;
        
    }
    
}
