package src.com.algo;

public class Reader4 {

    private String file = "";
    private int pointer = 0; 

    public Reader4(String file){
        this.file = file;
    }

    int read4(char[] buf4){
        int readCnt = 0;


        String readString = null;

        if(pointer + 4 < file.length()){
            readString = file.substring(pointer, pointer + 4);
            System.arraycopy(readString.toCharArray(), 0, buf4, 0, readString.length());
            pointer = pointer + 4;
           
        }else if(file.length() - pointer > 0 ){
            int endIdx = file.length() - pointer;
            
            readString = file.substring(pointer, pointer + endIdx);
            System.arraycopy(readString.toCharArray(), 0, buf4, 0, readString.length());

            pointer = pointer + endIdx;
        }

        if( readString!=null && readString.length() >0){
            readCnt = readString.length();
        }
        
        
        
        return readCnt;
    }

    public static void main(String[] args) {
        Reader4 reader = new Reader4("abc");

        char[] buff = new char[4];
        int readCnt = reader.read4(buff);
        System.out.println("Red:  " + readCnt + " : " + String.valueOf(buff));

        buff = new char[4];
        readCnt = reader.read4(buff);
        System.out.println("Red:  " + readCnt + " : " + String.valueOf(buff));

        for(int i=1; i<=15 ; i++){
            System.out.println("i = " + i + ",  Mod : " + i%4  + "  ,  " + (int) i/4);
        }
        
        //System.out.println(4%4);
        //System.out.println(4%4);

    }
}
