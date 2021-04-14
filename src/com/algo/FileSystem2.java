package src.com.algo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class FileSystem2 {

    class Dir {
        HashMap<String, String> fileList = new HashMap<String, String>();
        HashMap<String, Dir> dirList = new HashMap<String, Dir>();

    }
    Dir root = new Dir();

    public FileSystem2() {

    }
    
    public List<String> ls(String path) {

        List<String> returnList = new ArrayList<String>();

        String[] pathItems = path.split("/");
        Dir tempNode = this.root;

        if(pathItems.length>1){
        
            
            for(String fname : pathItems){

                if(fname.isEmpty()) continue;

                
                if(tempNode.dirList.containsKey(fname)){
                    tempNode = tempNode.dirList.get(fname);
                }
            }

            String fName = pathItems[ pathItems.length -1];

            if(tempNode.fileList.containsKey(fName)){
                returnList.add(fName);
            }else{
                returnList.addAll(tempNode.dirList.keySet());
                returnList.addAll(tempNode.fileList.keySet());
            }
        }else{
            returnList.addAll(tempNode.dirList.keySet());
            returnList.addAll(tempNode.fileList.keySet());
        }
        Collections.sort(returnList);

        return returnList;
    }
    
    public void mkdir(String path) {
        
        String[] pathItems = path.split("/");

        Dir tempNode = this.root;
        for(String fname : pathItems){
            
            if(fname.isEmpty()) continue;

            if(!tempNode.dirList.containsKey(fname)){
                Dir newDir = new Dir();
                tempNode.dirList.put(fname, newDir);
                tempNode = newDir;
            }else{
                tempNode = tempNode.dirList.get(fname);
            }
            
        }
             

    }
    
    public void addContentToFile(String path, String content) {
        
        String[] pathItems = path.split("/");

        Dir tempNode = this.root;
        
        for(String fname : pathItems){

            if(fname.isEmpty()) continue;

            if(tempNode.dirList.containsKey(fname)){
                tempNode = tempNode.dirList.get(fname);
            }
        }
        String tempContent = null;
        String fName = pathItems[ pathItems.length -1];

        if(tempNode.fileList.containsKey(fName)){
            tempContent = tempNode.fileList.get(fName);
            tempNode.fileList.put(fName, tempContent + content);

        }else{
            tempNode.fileList.put(fName, content);
        }

        
    }
    
    public String readContentFromFile(String path) {
        
        String[] pathItems = path.split("/");

        Dir tempNode = this.root;
        String returnValue = null;

        for(String fname : pathItems){

            if(fname.isEmpty()) continue;

            if(tempNode.dirList.containsKey(fname)){
                tempNode = tempNode.dirList.get(fname);
            }
        }
        
        String fName = pathItems[ pathItems.length -1];

        if(tempNode.fileList.containsKey(fName)){
            returnValue= tempNode.fileList.get(fName);
        }

        return returnValue;
    }

    public static void main(String[] args) {
        String s = "/a/b/c/d/e";

        /* String[] arr = "/".split("/");
        for(String t : arr){
            System.out.println(t);
        } */
        FileSystem2 fs = new FileSystem2();
        //System.out.println(fs.ls("/"));

        //fs.mkdir(s);
        fs.mkdir("/aa");
        //fs.mkdir("/aa/bb");
        //System.out.println(fs.ls("/"));

        fs.addContentToFile("/a/myfile", "Hello there");
        System.out.println(fs.readContentFromFile("/a/myfile"));
        System.out.println(fs.ls("/a/myfile"));

        //fs.addContentToFile("/a/myfile", "Hello there again ");
        //System.out.println(fs.readContentFromFile("/a/myfile"));
 

    }
    
}
