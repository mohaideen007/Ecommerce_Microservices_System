import java.beans.Encoder;
import java.util.Base64;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;

public class classy {
    public static void main(String[] args) throws Exception {
        


        KeyGenerator keygen=KeyGenerator.getInstance("HmacSHA256");
        SecretKey key=keygen.generateKey();
        String k=Base64.getEncoder().encodeToString(key.getEncoded());

        System.out.println(k);


    }
}
