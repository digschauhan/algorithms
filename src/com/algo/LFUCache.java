package src.com.algo;

import java.util.Date;
import java.util.HashMap;
import java.util.TreeSet;

public class LFUCache {

    
    HashMap<Integer, DataElement> cacheMap = new HashMap<Integer, DataElement>();
    TreeSet<DataElement> usageTracker = new TreeSet<DataElement>();
    long seq =1;

    int capacity = 0;
    int inUseCapacity=0;
    

    public LFUCache(int capacity) {
        this.capacity = capacity;
    }
    
    public int get(int key) {
        int retValue = -1;
        if(cacheMap.containsKey(key)){
            DataElement de = cacheMap.get(key);
            retValue = de.value;

            de.cnt++;
            de.lastUsed = System.currentTimeMillis() + seq++;
            de.key = key;
            cacheMap.put(key, de);
            usageTracker.add(de);
        }
        return retValue;
    }
    
    public void put(int key, int value) {

        DataElement de = null;

        if(capacity < 1) return;

        if(cacheMap.containsKey(key)){
            de = cacheMap.get(key);
            de.cnt++;
            de.lastUsed = System.currentTimeMillis() + seq++;
            de.key = key;
            de.value = value;
            cacheMap.put(key, de);
            usageTracker.add(de);
        }else{
            if(capacity < cacheMap.entrySet().size() + 1 ){
                de = getLeastFrequentlyUsed();
                cacheMap.remove(de.key);
            }
            de = new DataElement(1, System.currentTimeMillis() + seq++, key, value);
            cacheMap.put(key, de);
            usageTracker.add(de);
         }
    }

    public DataElement getLeastFrequentlyUsed(){
        usageTracker = new TreeSet<DataElement>(cacheMap.values());

        return usageTracker.pollFirst();
    }




    class DataElement implements Comparable<DataElement>{

        int cnt;
        long lastUsed = 0;
        int key;
        int value;

        public DataElement(int cnt, long lastUsed, int key, int value){
            this.cnt = cnt;
            this.lastUsed = lastUsed;
            this.key = key;
            this.value = value;
        }

        @Override
        public int compareTo(DataElement o) {
            int cntComp = Integer.compare(this.cnt, o.cnt);
            if(cntComp == 0){
                
                return Long.compare(this.lastUsed, o.lastUsed);
                
            }

            return cntComp;
        }
        
        @Override
        public boolean equals(Object obj){
            System.out.println(" equls called .." );
            if(this == obj) return true;
            if(obj == null) return false;
            if( !(obj instanceof DataElement)) return false;
            
            DataElement o = (DataElement) obj;
            return (Integer.compare(o.value, this.value) == 0);
            
        }
        @Override
        public int hashCode(){
            System.out.println("hashcode called ....");
            return this.value;
        }
    }
    
}
