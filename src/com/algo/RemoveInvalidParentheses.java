package src.com.algo;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class RemoveInvalidParentheses {

    public static void main(String[] args) {
        
        String str = "()())()";
        //str = "(a)())()";
        //str = ")(";
        //str = "n";
        str = ")(f";


        //System.out.println(isValidString(str));

        //System.out.println(str);
        System.out.println(removeInvalidParentheses(str).toString());

        
    }

    public static boolean isParentheses(char c){

        boolean isPar = false;
        if(c == '(' || c == ')'){
            isPar = true;
        }
        return isPar;

    }

    public static boolean isValidChar(char c){

        boolean isChar = false;
        String CHARS = "abcdefghijklmnopqrstuvwxyz";

        if(CHARS.contains(String.valueOf(c))){
            isChar = true;
        }
        return isChar;

    }

    public static boolean isValidString(String str){
        boolean isValid = true;

        int cnt = 0;
        for(int i=0; i< str.length(); i++){
            if(str.charAt(i) == '('){
                cnt++;
            }else if(str.charAt(i) == ')'){
                cnt--;
            }else if( !"abcdefghijklmnopqrstuvwxyz".contains(String.valueOf(str.charAt(i))) ){
                return false;
            }
            if(cnt<0  ){
                return false;
            }
        }
        
        isValid = (cnt == 0);

        return isValid;
    }

    public static ArrayList<String> removeInvalidParentheses(String str){
        ArrayList<String> returnList = new ArrayList<String>();
        HashSet<String> list = new HashSet<String>();

        
        Queue<String> q = new LinkedList<String>();
        boolean found = false;
        
        q.add(str);
        list.add(str);
        while(!q.isEmpty()){

            str = q.peek(); q.remove(); 
            if (isValidString(str)){
            
                returnList.add(str);
                found = true; 
            } 
            if (found) 
                continue; 


            for(int i=0; i < str.length() && str.length() >=2 ; i++){

                if(!isParentheses(str.charAt(i))){
                    continue;
                }
                //Remove one character one by one
                String tmp = str.substring(0, i) + str.substring(i+1); 

                if(!list.contains(tmp)){
                    list.add(tmp);
                    q.add(tmp);
                }
                
            }
            
        }

        
        if(returnList.isEmpty()){
            
            returnList.add("");
            
        }
        return returnList;
    }
    
}
