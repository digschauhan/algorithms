package src.com.algo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Hashtable;
import java.util.List;


class FileSystem {

    public static enum FileType {
        FILE,
        DIRECTORY
    };

    class FileItem{
        private String name;
        private FileType type;
        String content = null;

        
        public FileItem(String fName, FileType fType){
            this.name = fName;
            this.type = fType;
        }

        public void setContent(String data){
            this.content = data;
        }
        public String getContent(){
            return this.content;
        }

        public String toString(){
            return this.name;
        }

    }

    Hashtable<String, ArrayList<FileItem>> memFS = new Hashtable<String, ArrayList<FileItem>>();

    public FileSystem() {
        memFS.put("/", new ArrayList<FileItem>());
    }
    
    public List<String> ls(String path) {

        List<String> retList = new ArrayList<String>();

        if(memFS.containsKey(path)){
            for(FileItem f : memFS.get(path)){
                retList.add(f.name);
            }
        }else{
            String parent = path.substring(0, path.lastIndexOf("/"));
            String fName = path.substring(path.lastIndexOf("/")+1);

            if(memFS.containsKey(parent)){
                for(FileItem f : memFS.get(parent)){
                    if(FileType.FILE == f.type && f.name.equals(fName)){
                        retList.add(f.name);
                    }
                    
                }
            }
        }
        Collections.sort(retList);
        return retList;
    }
    
    public void mkdir(String path) {
        
        try{
           
            String sPath = path;
            memFS.put(path, new ArrayList<FileItem>());

            while(sPath.lastIndexOf("/")>=0 && !memFS.containsKey(sPath)){
                String dirName = sPath.substring(sPath.lastIndexOf("/")+1);
                
                sPath = sPath.substring(0, sPath.lastIndexOf("/"));
                
                String key = sPath;
                if(sPath.isEmpty()){
                    key = "/";
                }

                ArrayList<FileItem> fObjs = null; 
                FileItem fItem = new FileItem(dirName, FileType.DIRECTORY);
                if(!memFS.containsKey(key)){
                    fObjs = new ArrayList<FileItem>(); 
                    fObjs.add(fItem);
                    memFS.put(key, fObjs);
                }else{
                    fObjs = memFS.get(key);
                    fObjs.add(fItem);
                }

            }

            System.out.println("Directory created : " + path);
        }catch(Exception e){
            System.out.println("Error creating directory : " + e.getMessage());
        }
        

    }
    
    public void addContentToFile(String filePath, String content) {
        String fileName = filePath.substring(filePath.lastIndexOf("/")+1);
        String location = filePath.substring(0, (filePath.lastIndexOf("/")==0? 1:filePath.lastIndexOf("/")) );

        if(!memFS.containsKey(location)){
            mkdir(location);
        }


        ArrayList<FileItem> list = memFS.get(location);
        for(FileItem f : list){
            if(fileName.equals(f.name) && f.type == FileType.FILE){
                f.setContent( f.getContent() + content);
                break;
            }
        }

        FileItem file = new FileItem(fileName , FileType.FILE );
        file.setContent(content);
        list.add(file);

        
        
    }
    
    public String readContentFromFile(String filePath) {
        
        String fileName = filePath.substring(filePath.lastIndexOf("/")+1);
        String location = filePath.substring(0, (filePath.lastIndexOf("/")==0? 1:filePath.lastIndexOf("/")) );
        String fData = null;
        
        
        if(memFS.containsKey(location)){
            ArrayList<FileItem> list = memFS.get(location);
            for(FileItem f : list){
                if(fileName.equals(f.name) && f.type == FileType.FILE){
                    fData = f.getContent();
                    break;
                }
            }

        }

        return fData;
    }

    public static void main(String[] args) {
        FileSystem fs = new FileSystem();
        
        //fs.mkdir("/a/b/c/d/e");
        //fs.mkdir("/a/b/c/d/e");
        System.out.println(fs.ls("/"));

        //fs.addContentToFile("/abc", "Abc file content");

        //System.out.println(fs.ls("/"));
        //System.out.println(fs.readContentFromFile("/abc"));
       
        // ["/ojvselag"],["/ojvselag/brkn"]
        fs.mkdir("/ojvselag");
        fs.mkdir("/ojvselag/brkn");
        fs.mkdir("/ojvselag/xtr");
        System.out.println(fs.ls("/"));

        //fs.addContentToFile("/a/b/c/d", "Hello");
        //System.out.println(fs.ls("/a/b/c"));

        //System.out.println(fs.readContentFromFile("/a/b/c/d"));
        


        
    }
}

/**
 * ["FileSystem","ls","ls","mkdir","        mkdir",         "ls","  addContentToFile","ls","                    readContentFromFile",   "readContentFromFile"]
[[],["/"],["/"],            ["/ojvselag"],["/ojvselag/brkn"],["/"],["/ojvselag/ttaao","wsilehhu"],["/ojvselag"],    ["/ojvselag/ttaao"],["/ojvselag/ttaao"]]
 */