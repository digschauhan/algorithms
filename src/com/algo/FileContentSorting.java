package src.com.algo;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class FileContentSorting {

    ArrayList<String> lines = new ArrayList<String>();
    
    public void sortFileContentInNewFile(String path){
        File file = new File(path);
        for(File f : file.listFiles()){
            FileReader fr = null;
            BufferedReader in = null;
            try{
                in = new BufferedReader(new FileReader(f.getAbsolutePath()));
                String line = null;
                while( ( line = in.readLine() ) != null){
                    lines.add(line);
                }
            }catch(Exception e){
                System.out.println("Error : " + e.getMessage());
            }finally{
                try{
                    if(fr!=null) fr.close();
                }catch(Exception e){
                    System.out.println("Could not close file : " + e.getMessage());
                }
                
            }
        }

        Collections.sort(lines);
        FileWriter fw = null;
        PrintWriter out = null;

        try{

            fw = new FileWriter(path + "/sorted.txt");
            out = new PrintWriter(fw);

            for(String ln : lines){
                out.println(ln);
            }
        
        }catch(Exception e){
            System.out.println("Error : " + e.getMessage());
        }finally{
            try{
                if(out!=null) out.close();
            }catch(Exception e){}
        }
    }

    public static void main(String[] args) {
        FileContentSorting fs = new FileContentSorting();

        String path = "/Users/djaychauhan/OneDrive/Technical_Work/Algorithms/src/files";
        fs.sortFileContentInNewFile(path);


        File file = new File(path);
        System.out.println(file.getAbsolutePath());
        System.out.println(file.listFiles());
    }
    
}
