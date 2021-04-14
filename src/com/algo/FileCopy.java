package src.com.algo;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;



public class FileCopy {

    public void moveFiles(String src, String dest){

        try{
            File srcLoc = new File(src);
            File destLoc = new File(dest);

            if(!destLoc.exists()){
                System.out.println(destLoc.mkdirs());
                
            }
            boolean hasAnyDirectory = false;

            for(File dir : srcLoc.listFiles()){
                
                if(dir.isDirectory()){
                    hasAnyDirectory = true;
                    moveFiles(dir.getAbsolutePath(), dest);
                }else{
                    if(!src.equals(dest)){
                        moveFile(dir.getAbsolutePath(), dest);
                    }
                    
                }
            }

            if(!hasAnyDirectory) return;

        }catch(Exception e){
            System.out.println("Error moving files: " + e.getMessage());
        }

        return ;
    }

    public boolean moveFile(String src, String dest){
        boolean isSuccess = false;

        FileInputStream fin = null;
        FileOutputStream fout = null;

        BufferedInputStream in = null;
        BufferedOutputStream out = null;

        try{
            System.out.println("Moving file : " + src);
            File srcFile = new File(src);
            File destFile = new File(dest + "/" + srcFile.getName());

            fin = new FileInputStream(srcFile);
            fout = new FileOutputStream(destFile);

            int buffSize = 1024 * 1024;

            in = new BufferedInputStream(fin, buffSize);
            out = new BufferedOutputStream(fout, buffSize);

            byte[] buff = new byte[buffSize];
            int len = 0;
            while((len = fin.read(buff)) >0){
                System.out.print(".");
                fout.write(buff, 0, len);
                fout.flush();
            }

            System.out.println("Successfully moved : " + src);
        }catch(Exception e){
            System.out.println("Error moving file: " + e.getMessage());
            e.printStackTrace();
            
        }finally{
            try{
                in.close();
                out.close();
            }catch(Exception e) {System.out.println(e.getMessage());};

        }
        return isSuccess;
    }

    public static void main(String[] args) {
    
        String src = "/Users/djaychauhan/OneDrive/Books";
        String dest = "/Users/djaychauhan/OneDrive/Books";

        //String src = "/Users/djaychauhan/OneDrive/Technical_Work/Algorithms/src/files";
        //String dest ="/Users/djaychauhan/OneDrive/Technical_Work/Algorithms/src/files/cp";

        FileCopy f = new FileCopy();
        f.moveFiles(src, dest);
    }
    
}
