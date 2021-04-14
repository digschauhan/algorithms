package src.com.algo;

public class Palindrome {

    public boolean isPalindrome(String s) {
        boolean isPalindrome = true;

        String pal = s;
        pal = pal.replaceAll("[^a-zA-Z]", "").toLowerCase();

        for(int i=0, j=pal.length()-1; i<=j; i++, j--){
            if(pal.charAt(i) != pal.charAt(j)){
                isPalindrome = false;
            }
        }
        //System.out.println(pal);
        return isPalindrome;
    }

    public static void main(String[] args) {
        Palindrome p = new Palindrome();
        System.out.println(p.isPalindrome("abcakdhuba"));
        
        String s = "abcdcba";
        StringBuilder sb = new StringBuilder(s);
        
        System.out.println(sb.reverse().toString().equals(s));

        
    }
    
}
