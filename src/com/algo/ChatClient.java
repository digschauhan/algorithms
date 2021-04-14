package src.com.algo;

import java.io.*;
import java.net.*;
import java.util.Scanner;

public class ChatClient implements Runnable  {

    Socket soc = null;

    public ChatClient() {
        try{
            soc =  new Socket("127.0.0.1", ChatServer.SERVER_PORT);
            System.out.println("Connected to server ...");
        }catch(Exception e){
            System.out.println("Error : " + e.getMessage());
        }

    }    




	@Override
	public void run() {
        try{
            while(true){
                BufferedReader br = new BufferedReader(new InputStreamReader(soc.getInputStream()));
                System.out.println(br.readLine());

                PrintWriter pw = new PrintWriter(soc.getOutputStream());
                pw.println("Hello from client ....");
                pw.flush();
                
                Scanner read = new Scanner(System.in);
                pw.println(read.nextLine());
            }

        
        }catch(Exception e ){
            System.out.println("Error : " + e.getMessage());
        }
		
		
	}


    public static void main(String[] args) {
        
    }

    
}
