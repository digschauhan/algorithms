package src.files;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class SortFileContent {

    ArrayList<String> lines = new ArrayList<String>();


    public void sortFile(String file){

        BufferedReader br = null;
        try{
            File f = new File(file);
        
            br = new BufferedReader(new FileReader(f));

            String s = null;
            while((s = br.readLine()) !=null ){
                lines.add(s);
            }

            Collections.sort(lines);

            for(String ln : lines){
                System.out.println(ln);
            }
            
        
        }catch(Exception e){
            System.out.println("Error : "+ e.getMessage());
        }finally{
            try{
                br.close();
            }catch(Exception e){}
        }
        


    }

    public static void main(String[] args) {
        String fileName = "/Users/djaychauhan/OneDrive/Technical_Work/Algorithms/src/files/note.txt";

        SortFileContent sf = new SortFileContent();
        sf.sortFile(fileName);
        
    }
    
}
