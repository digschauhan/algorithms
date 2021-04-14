package src.com.algo;

import java.util.Comparator;

public class AlienDictionary {


    public boolean isAlienSorted(String[] words, String order) {

        StringComparator strComp = new StringComparator(order);

        for(int i=0; i<words.length - 1; i++){
            if(strComp.compare(words[i], words[i+1]) > 0){
                return false;
            }
        }

        return true;
        
    }


    class StringComparator implements Comparator<String>{

        String charOrder;

        public StringComparator(String order){
            charOrder = order;
        }

        public int compare(String a, String b){
            char[] aChars = a.toCharArray();
            char[] bChars = b.toCharArray();
            
            if(a!= null && a.equals(b)){
                return 0;
            }

            for(int i=0; i< Integer.min(aChars.length, bChars.length); i++){
                int diff = charOrder.indexOf(aChars[i]) - charOrder.indexOf(bChars[i]);

                if(diff < 0 ){
                    return diff;
                }else if(diff>0){
                    return diff;
                }
            }
            if(a.length() == b.length()){
                return 0;
            }else{
                return a.length() - b.length();
            }

        }
    }

    public static void main(String[] args) {
        //Input: words = ["hello","leetcode"], order = "hlabcdefgijkmnopqrstuvwxyz"
        //Output: true

        //Input: words = ["word","world","row"], order = "worldabcefghijkmnpqstuvxyz"
        //Output: false

        //String[] words = {"hello", "leetcode"};
        //String order = "hlabcdefgijkmnopqrstuvwxyz";

        //String[] words = {"word", "world", "row"};
        //String order = "worldabcefghijkmnpqstuvxyz";


        //Input: words = ["apple","app"], order = "abcdefghijklmnopqrstuvwxyz"


        String[] words = {"apple", "app"};
        String order = "abcdefghijklmnopqrstuvwxyz";

        AlienDictionary ad = new AlienDictionary();

        

        System.out.println(ad.isAlienSorted(words, order));

        //System.out.println(new Integer(20).compareTo(new Integer(15)));


    }
    
}
