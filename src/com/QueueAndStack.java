package src.com;

import java.util.*;

public class QueueAndStack {

    public static Integer MAX_ELEMETS = 10;
   

    public static void tryStack(){
        Stack<MyDataElement> stk = new Stack<MyDataElement>();

        MyDataElement el = null;
        Random rand = new Random();

        for(int i=0; i<MAX_ELEMETS;i++){
            el = new MyDataElement();
            el.id = i;
            el.cnt = rand.nextInt(100);
            el.lastUsed = new Date();
            el.value = rand.nextInt(100);

            stk.push(el);
        }

        System.out.println("Printing elements ...");
        while(!stk.isEmpty()){
            System.out.println(stk.pop());
        }

    }

    public static void tryQueue(){
        ArrayDeque<MyDataElement> que = new ArrayDeque<MyDataElement>();

        
        MyDataElement el = null;
        Random rand = new Random();

        for(int i=0; i<MAX_ELEMETS;i++){
            el = new MyDataElement();
            el.id = i;
            el.cnt = rand.nextInt(100);
            el.lastUsed = new Date();
            el.value = rand.nextInt(100);

            que.add(el);

            
        }

        System.out.println("Printing elements ...");
        while(!que.isEmpty()){
            System.out.println(que.poll().toString());
        }

    }
    public static void tryPriorityQueue(){

        PriorityQueue<MyDataElement> pQue = new PriorityQueue<MyDataElement>();
        MyDataElement el = null;
        Random rand = new Random();

        for(int i=0; i<MAX_ELEMETS;i++){
            el = new MyDataElement();
            el.id = i;
            el.cnt = rand.nextInt(100);
            el.lastUsed = new Date();
            el.value = rand.nextInt(100);
            pQue.add(el);
        }

        System.out.println("Printing elements ...");
        while(!pQue.isEmpty()){
            System.out.println(pQue.poll().toString());
        }

    }

    public static void main(String[] args) {
        //tryQueue();
        //tryPriorityQueue();
        tryStack();
    }
    
}
