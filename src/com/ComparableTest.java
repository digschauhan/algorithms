package src.com;

import java.util.Date;
import java.util.HashMap;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;

public class ComparableTest {

    class DataElement implements Comparable<DataElement>{

        public int cnt;
        public Date lastUsed = new Date();
        
        public int key;
        public int value;

        @Override
        public int compareTo(DataElement o) {
            int cntComp = Integer.compare(this.cnt, o.cnt);
            if(cntComp == 0){
                if(lastUsed.before(o.lastUsed)){
                    cntComp = -1;
                }else{
                    cntComp = 1;
                }
                
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
    public static void main(String[] args) {

        ComparableTest test = new ComparableTest();
        TreeSet<DataElement> list = new TreeSet<DataElement>();
        TreeMap<DataElement, Integer> map = new TreeMap<DataElement,Integer>();
        HashMap<DataElement, Integer> hMap = new HashMap<DataElement, Integer>();
        


        DataElement el = test.new  DataElement();
        el.cnt = 100;
        el.lastUsed = new Date();
        el.value = 100;
        list.add(el);
        map.put(el, 100);


        el = test.new  DataElement();
        el.cnt = 15;
        el.lastUsed = new Date();
        el.value = 15;
        list.add(el);
        map.put(el, 15);

        el = test.new  DataElement();
        el.cnt = 35;
        el.lastUsed = new Date();
        el.value = 35;
        list.add(el);
        map.put(el, 35);

       
        for(DataElement e : list ){
            System.out.println(e.value);
        }

        System.out.println("--------" + map.firstKey().value);
        System.out.println("--------" + map.lastKey().value);
        ;
        for(DataElement e : map.keySet() ){
            System.out.println(e.value);
        }
        //System.out.println(list.pollFirst().value);

        /* for(DataElement e : list ){
            System.out.println(e.value);
        } */

        System.out.println(("--------"));
        el = test.new  DataElement();
        el.cnt = 35;
        el.lastUsed = new Date();
        el.value = 35;

        DataElement el2 = test.new  DataElement();
        el2.cnt = 35;
        el2.lastUsed = new Date();
        el2.value = 35;
        
        //System.out.println(el.equals(el2));
        map.put(el, 35);
        System.out.println(map.containsKey(el));

        el.cnt = 25;
        hMap.put(el, 35);
        System.out.println(hMap.containsKey(el));

        System.out.println(hMap.entrySet().size());
        long d1 = new Date().getTime();
        System.out.println(d1);

        long d2 = new Date().getTime();;
        System.out.println(d2);
        new Date().getTime();

        System.out.println(Long.compare(d1, d2));


    }
    
}
