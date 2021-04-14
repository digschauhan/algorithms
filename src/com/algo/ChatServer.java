package src.com.algo;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Scanner;

public class ChatServer {

    public static Integer SERVER_PORT = 1010;
    static HashMap<Socket, Boolean> map = new HashMap<Socket, Boolean>();

    ServerSocket server = null;

    public ChatServer(Integer port){
        try{
            SERVER_PORT = port;
            server = new ServerSocket(SERVER_PORT);
        }catch(Exception e){
            System.out.println("Error preparing server : " + e.getMessage());
        }
        
    } 

    public void startServer(){
        try{
            System.out.println("Starting server ... , listen to port : " + SERVER_PORT);
            while(true){
                Socket soc = server.accept();
                System.out.println("New client connected !");
                new Thread(new HandleClient(soc)).start();

                

            }
        }catch(Exception e){
            System.out.println("Error : " + e.getMessage());
        }
    }
    

    class HandleClient implements Runnable{

        Socket client = null;

        public HandleClient(Socket soc){
            this.client = soc;
        }

        @Override
        public void run(){
            try{
                BufferedReader br = new BufferedReader( new InputStreamReader(client.getInputStream()) );
                PrintWriter pr = new PrintWriter(new OutputStreamWriter(client.getOutputStream()));

                pr.write("Hi there ! Thanks for connecting !");
                pr.flush();
                while(true){
                    System.out.println("Client : " + br.readLine());
                    Scanner read = new Scanner(System.in);
                    pr.write(read.nextLine());

                }
            }catch(Exception e){
                System.out.println("Error connecting client : " + e.getMessage());
            }
        }
    }


    public static void main(String[] args) {
        ChatServer cs = new ChatServer(1010);
        cs.startServer();
    }
    
}
