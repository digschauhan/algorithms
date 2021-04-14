package src.com;

import java.util.*;


public class MyDataElement implements Comparable<MyDataElement>  {

    public int id;
    public int cnt;
    public Date lastUsed = new Date();
    
    public int key;
    public int value;

    @Override
    public int compareTo(MyDataElement o) {
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
        System.out.println(" equls called .." );
        if(this == obj) return true;
        if(obj == null) return false;
        if( !(obj instanceof MyDataElement)) return false;
        
        MyDataElement o = (MyDataElement) obj;
        return (Integer.compare(o.value, this.value) == 0);
        
    }
    @Override
    public int hashCode(){
        System.out.println("hashcode called ....");
        return this.value;
    }

    @Override
    public String toString(){
        return "[ id = "+ this.id + " ] , [ Value : " + this.value + " ]";
    }
    
}
