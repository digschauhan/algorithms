package src.com;

import java.net.URI;
import java.net.URL;
import java.net.http.*;
import java.io.*;

public class URLAndNetworking {

    public static void main(String[] args) {

        URLAndNetworking test = new URLAndNetworking();

        test.tryHttpClient();
        

    }


    public void tryHttpClient(){

        try{
       
            HttpClient client = HttpClient.newHttpClient();

            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create("https://www.google.com/"))
                    .GET() // GET is default
                    .build();

            HttpResponse<String> response = client.send(request,
                    HttpResponse.BodyHandlers.ofString());

            System.out.println(response.body());

        }catch(Exception e){

        }
    }

    public void tryURLAndStreaming(){
        BufferedReader br = null;
        try{
            URL url = new URL("https://google.com");

            br = new BufferedReader(new InputStreamReader(url.openStream()));
            String ln=null;

            while( (ln = br.readLine()) !=null){
                System.out.println(ln.replaceAll("<[^>]*>", ""));
            }
        }catch(Exception e){
            System.out.println("Error : " + e.getMessage());
        }finally{
            try{
                if(br!=null) br.close();
            }catch(Exception e){}
        }
    }
    
}
