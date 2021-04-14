package src.com.algo;

public class CanConstruct {

    public static void main(String[] args) {
        String s = "sample abc text abcdef";
        String search = "abcdef";

        System.out.println(s.substring(0, s.indexOf("sample abc text abcdef")));

        String[] arr = {"ab", "abc", "cd", "def", "abcd"};
        System.out.println(canConstruct(search, arr));

    }

    public static boolean canConstruct(String str, String[] arr){
        boolean result = false;

        if(str.isEmpty()){
            return true;
        }

        for(String s : arr){
            String concStr = null;
            if(str.startsWith(s)){
                concStr = str.substring(s.length());
                result = canConstruct(concStr, arr);
            }
            if(str.endsWith(s)){
                concStr = str.substring(0, str.indexOf(str) );
                result = canConstruct(concStr, arr);
            }
            if(result){
                return true;
            }
            //System.out.println("str: "+ str + " , s:" + s + " , concStr : " + concStr + " , result : " + result);

        }
        return result;
    }
    
}
