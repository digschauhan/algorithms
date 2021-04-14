package src.com.algo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class FindDuplicateFiles {

    HashMap<String, ArrayList<String>> dupFiles = new HashMap<String, ArrayList<String>>();

    public List<List<String>> findDuplicate(String[] paths) {
        
        for(String path : paths){
            String[] pathElements = path.split(" ");
            String dirPath = null;
            

            if(pathElements.length >=2){
                dirPath = pathElements[0];

                ArrayList<String> fileList = null;

                
                for(int i=1;i<pathElements.length;i++){
                    String file = pathElements[i];
                    String fName = file.substring(0, file.indexOf("("));
                    String fContent = file.substring(file.indexOf("("));

                    if(dupFiles.containsKey(fContent)){
                        fileList = dupFiles.get(fContent);
                    }else{
                        fileList = new ArrayList<String>();
                    }
                    fileList.add(dirPath +"/"+ fName);
                    dupFiles.put(fContent, fileList);
                }
            }

        }

        List<List<String>> returnList = new ArrayList<>();

        for(String key : dupFiles.keySet()){
            ArrayList<String> val = dupFiles.get(key);
            
            if(val.size()>1){
                returnList.add(val);
            }
        }
        
        return returnList;
    }


    public static void main(String[] args) {
        //Input: paths = ["root/a 1.txt(abcd) 2.txt(efgh)","root/c 3.txt(abcd)","root/c/d 4.txt(efgh)","root 4.txt(efgh)"]
        //Output: [["root/a/2.txt","root/c/d/4.txt","root/4.txt"],["root/a/1.txt","root/c/3.txt"]]

        String[] arr = {"root/a 1.txt(abcd) 2.txt(efgh)","root/c 3.txt(abcd)","root/c/d 4.txt(efgh)","root 4.txt(efgh)"};
        FindDuplicateFiles fd = new FindDuplicateFiles();

        System.out.println(fd.findDuplicate(arr));

    }
    
}
