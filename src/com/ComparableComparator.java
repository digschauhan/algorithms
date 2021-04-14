package src.com;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Random;

import java.util.*;


public class ComparableComparator {

    public static Integer MAX_ELEMETS = 100000;

    class DataElement implements Comparable<DataElement>  {

        public int id;
        public int cnt;
        public Date lastUsed = new Date();
        
        public int key;
        public int value;

        @Override
        public int compareTo(DataElement o) {
            //System.out.println("CompareTo Called : " + o.toString());
            int cntComp = 0;
            if(this.value < o.value){
                cntComp = -1;
            }else if(this.value > o.value){
                cntComp = 1;
            }else{
                cntComp = 0;
            }
            return cntComp;
        }

        @Override
        public boolean equals(Object obj){
            //System.out.println(" equls called .." );
            if(this == obj) return true;
            if(obj == null) return false;
            if( !(obj instanceof DataElement)) return false;
            
            DataElement o = (DataElement) obj;
            return (Integer.compare(o.value, this.value) == 0);
            
        }
        @Override
        public int hashCode(){
            //System.out.println("hashcode called ....");
            return this.value;
        }

        @Override
        public String toString(){
            return "[ id = "+ this.id + " ] , [ Value : " + this.value + " ]";
        }
        
    }

    class Operations{
        boolean add=true;
        boolean sort = true;
        boolean print = true;

        public Operations(boolean add, boolean sort, boolean print){
            this.add = add;
            this.sort = sort;
            this.print = print;
        }
        @Override
        public String toString(){
            StringBuffer sb = new StringBuffer();
            sb.append(" Add : ").append(this.add).append(" | ");
            sb.append(" Sort : ").append(this.sort).append(" | ");
            sb.append(" Print : ").append(this.print);

            return sb.toString();
        }
        
    }
    public static void main(String[] args) {

        ArrayList<String> timeTaken = new ArrayList<String>();
        long start, end;
        ComparableComparator test = new ComparableComparator();
        Operations ops = test. new Operations(true, false, false);


        start = System.currentTimeMillis();
        checkWithTreeSet(ops);
        end = System.currentTimeMillis();
        timeTaken.add("------------------ Time taken - TreeSet : " + String.valueOf(end - start) );
        

        start = System.currentTimeMillis();
        checkWithArrayList(ops);
        end = System.currentTimeMillis();
        timeTaken.add("------------------ Time taken - ArrayList : " + String.valueOf(end - start));
        

        start = System.currentTimeMillis();
        checkWithLinkedList(ops);
        end = System.currentTimeMillis();
        timeTaken.add("------------------ Time taken - LinkedList : " + String.valueOf(end - start));
        

        start = System.currentTimeMillis();
        checkWithTreeMap(ops);
        end = System.currentTimeMillis();
        timeTaken.add("------------------ Time taken - TreeMap : " + String.valueOf(end - start));
        
        
        
        start = System.currentTimeMillis();
        checkWithHashMap(ops);
        end = System.currentTimeMillis();
        timeTaken.add("------------------ Time taken - HashMap : " + String.valueOf(end - start));
        

        System.out.println(ops.toString());
        for(String msg : timeTaken){
            System.out.println(msg);
        }

    }

    public static void checkWithLinkedList(Operations ops){
        ComparableComparator test = new ComparableComparator();

        // Use to sort elements while adding, it uses Comparator to do the sorting
        LinkedList<DataElement> linkedList = new LinkedList<DataElement>();

        DataElement el = test.new  DataElement();

        Random rand = new Random();
        
        if(ops.add){
            for(int i=0; i<MAX_ELEMETS;i++){
                el = test.new  DataElement();
                el.id = i;
                el.cnt = rand.nextInt(100);
                el.lastUsed = new Date();
                el.value = rand.nextInt(100);

                linkedList.add(el);
            }
        }
        if(ops.add && ops.sort){
            Collections.sort(linkedList);
        }
        
        if(ops.print){
            System.out.println("Printing Elements : ");
            for(DataElement d : linkedList){
                System.out.println(d.toString());
            }
        }

    }


    public static void checkWithHashMap(Operations ops){
        ComparableComparator test = new ComparableComparator();

        // Use to sort elements while adding, it uses Comparator to do the sorting
        HashMap<DataElement, Integer> hashMap = new HashMap<DataElement,Integer>();

        DataElement el = test.new  DataElement();

        Random rand = new Random();
        
        if(ops.add){
            for(int i=0; i<MAX_ELEMETS;i++){
                el = test.new  DataElement();
                el.id = i;
                el.cnt = rand.nextInt(100);
                el.lastUsed = new Date();
                el.value = rand.nextInt(100);

                hashMap.put(el, 0);
            }
        }

        ArrayList<Map.Entry<DataElement, Integer>> mapList = new ArrayList<Map.Entry<DataElement,Integer>>(hashMap.entrySet());
        if(ops.add && ops.sort){
            // Sorting using Key , to sort it using value, just replace .getKey() with .getValue()
            Collections.sort(mapList, new Comparator<Map.Entry<DataElement, Integer>>(){
                public int compare(Map.Entry<DataElement, Integer> o1, Map.Entry<DataElement, Integer> o2 ){
                    return Integer.compare(o1.getKey().value , o2.getKey().value);
                }
            });
        }
        if(ops.print){
            System.out.println("Printing Elements : ");
            for(Map.Entry<DataElement, Integer> d : mapList){
                System.out.println(d.getKey().toString());
            }
        }
    }

    public static void checkWithTreeMap(Operations ops){
        ComparableComparator test = new ComparableComparator();

        // Use to sort elements while adding, it uses Comparator to do the sorting
        TreeMap<DataElement, Integer> treeMap = new TreeMap<DataElement,Integer>();

        DataElement el = test.new  DataElement();

        Random rand = new Random();
        
        if(ops.add){
            for(int i=0; i< MAX_ELEMETS;i++){
                el = test.new  DataElement();
                el.id = i;
                el.cnt = rand.nextInt(100);
                el.lastUsed = new Date();
                el.value = rand.nextInt(100);

                treeMap.put(el, 0);
            }
        }
        
        if(ops.print){
            System.out.println("Printing Elements : ");
            for(DataElement d : treeMap.keySet()){
                System.out.println(d.toString());
            }
        }
    }

    public static void checkWithArrayList(Operations ops){
        ComparableComparator test = new ComparableComparator();

        // Use to sort elements while adding, it uses Comparator to do the sorting
        ArrayList<DataElement> arrayList = new ArrayList<DataElement>();

        DataElement el = test.new  DataElement();

        Random rand = new Random();
        
        if(ops.add){
            for(int i=0; i<MAX_ELEMETS;i++){
                el = test.new  DataElement();
                el.id = i;
                el.cnt = rand.nextInt(100);
                el.lastUsed = new Date();
                el.value = rand.nextInt(100);

                arrayList.add(el);
            }
        }

        if(ops.add && ops.sort){
            Collections.sort(arrayList);
        }
        
        if(ops.print){
            System.out.println("Printing Elements : ");
            for(DataElement d: arrayList){
                System.out.println(d.toString());
            }
        }
    }

    public static void checkWithTreeSet(Operations ops){
        ComparableComparator test = new ComparableComparator();

        // Use to sort elements while adding, it uses Comparator to do the sorting
        TreeSet<DataElement> treeSet = new TreeSet<DataElement>();

        DataElement el = test.new  DataElement();

        Random rand = new Random();
        
        if(ops.add){
            for(int i=0; i<MAX_ELEMETS;i++){
                el = test.new  DataElement();
                el.id = i;
                el.cnt = rand.nextInt(100);
                el.lastUsed = new Date();
                el.value = rand.nextInt(100);

                treeSet.add(el);
            }
        }

        if(ops.print){
            System.out.println("Printing Elements : ");
            while(!treeSet.isEmpty()){
                System.out.println(treeSet.pollFirst());
            }
        }
    }
    
}
