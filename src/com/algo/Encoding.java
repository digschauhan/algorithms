package src.com.algo;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class Encoding {

    public static void main(String[] args) {
        String text = "DJayChauhan";

        String encoded = Base64.getEncoder().encodeToString(text.getBytes());
        //System.out.println(encoded);

        String decoded = Base64.getDecoder().decode(encoded).toString();

        //System.out.println(decoded);


        MessageDigest digest;
        try {
            digest = MessageDigest.getInstance("SHA-256");
            byte[] encodedhash = digest.digest(text.getBytes(StandardCharsets.UTF_8));
            System.out.println(toHexString(encodedhash));

        } catch (NoSuchAlgorithmException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
    }

    public static String toHexString(byte[] hash)
    {
        // Convert byte array into signum representation 
        BigInteger number = new BigInteger(1, hash); 
        //System.out.println(number);
        
        // Convert message digest into hex value 
        StringBuilder hexString = new StringBuilder(number.toString(16)); 
  
        // Pad with leading zeros
        while (hexString.length() < 32){ 
            hexString.insert(0, '0'); 
        } 
  
        return hexString.toString(); 
    }
    
}
