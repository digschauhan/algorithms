package src.com;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class CommandExecutor {

    public static void main(String[] args) {
        CommandExecutor ce = new CommandExecutor();
        //ce.executeCommandsUsingRuntime();
        ce.executeUsingProcessBuilder();

    }

    public void executeUsingProcessBuilder(){
        ProcessBuilder pb = new ProcessBuilder();
        pb.command("bash", "-c", "ping -c 3 google.com");

        try{
            Process ps = pb.start();

            BufferedReader br = new BufferedReader(new InputStreamReader(ps.getInputStream()));

            String ln = null;
            while( (ln = br.readLine()) !=null){
                System.out.println(ln);
            }
            System.out.println(ps.waitFor());

        }catch(Exception e){
            System.out.println("Error : "+ e.getMessage());
        }

    }

    public void executeCommandsUsingRuntime(){
        try{
            Process proc = Runtime.getRuntime().exec("ls -l");

            BufferedReader br = new BufferedReader(new InputStreamReader(proc.getInputStream()));

            String ln = null;
            while( (ln = br.readLine()) !=null){
                System.out.println(ln);
            }
            System.out.println(proc.exitValue());

        }catch(Exception e){
            System.out.println("Error: " + e.getMessage());
        }
        
    }
    
}
