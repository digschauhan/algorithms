package src.com.algo;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class RemoveInvalidParentheses2 {

    private static String CHARS = "abcdefghijklmnopqrstuvwxyz";

    public static void main(String[] args) {
        String s = ")()))))))())((()j)j))q()k)()()((d))()w((z()(())uh)";

        //Expected output:  "()()((()j)j)q()k()()((d))()w(z()(())uh)"
        //                   ()()((()j)j)q()k()()((d))()w(z()(())uh)

        //minRemoveToMakeValid(s);

        System.out.println(minRemNewFunc(s));
       
    }

    public static String minRemNewFunc(String S){
        char[] ans = S.toCharArray();
        int len = S.length(), stIx = 0, i = 0, j = 0;
        int[] stack = new int[len+1];
        for (; i < len; i++){
            if (ans[i] == ')'){
                if (stIx > 0){ 
                    stIx--;
                }else {
                    ans[i] = '_';
                }
            } else if (ans[i] == '(') {
                stack[stIx++] = i;
            }

        }
        for (i = 0, stack[stIx] = -1, stIx = 0; j < len; j++){
            if (j == stack[stIx]){ 
                stIx++;
            }else if (ans[j] != '_') {
                ans[i++] = ans[j];
            }
        }
        
        return new String(ans, 0, i);

    }
    
    
    
}
