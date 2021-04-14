package src.com.algo;

public class ReaderSolution extends Reader4{

    public ReaderSolution(String file){
        super(file);
    }

    private StringBuffer fBuff = new StringBuffer();
    private boolean isEndOfFile = false;

    public int read(char[] buf, int n) {

        if(isEndOfFile){
            return 0;
        }
        

        int loopCnt = 0;
        if(n%4 == 0){
            loopCnt = n/4;
        }else{
            loopCnt = n/4 + 1;
        }

        for(int i=0; i<loopCnt; i++){
            char[] tempBuff = new char[4];
            int readCnt = read4(tempBuff);

            if(readCnt>0) fBuff.append( String.valueOf(tempBuff).trim() );

            if(readCnt<4){
                break;
            }
        }


        int len = (fBuff.length()>=n? n : fBuff.length());
        String retData = fBuff.substring(0, len);
        System.arraycopy(retData.toCharArray(), 0, buf, 0, retData.length());

        if(fBuff.length() > n){
            fBuff =  new StringBuffer(fBuff.substring(n));
        }else{
            fBuff =  new StringBuffer();
        }
    

        return retData.length();
    }

    public static void main(String[] args) {

        //String file = "abcdefghijk";
        String file = "abc";
        ReaderSolution sol = new ReaderSolution(file);

        int n = 1;
        char[] buff = new char[n];

        System.out.println(sol.read(buff, n));
        System.out.println(String.valueOf(buff));

        n = 2;
        buff = new char[n];

        System.out.println(sol.read(buff, n));
        System.out.println(String.valueOf(buff));

        n = 1;
        buff = new char[n];

        System.out.println(sol.read(buff, n));
        System.out.println(String.valueOf(buff));

        // buff = new char[4];
        // buff[0] = 'a';
        // System.out.println(String.valueOf(buff).trim().length());


    }
    
}
