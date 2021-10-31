import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.bouncycastle.util.encoders.Hex;
import javax.crypto.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.Security;
public class Lab3 {
    static {
        Security.addProvider(new BouncyCastleProvider());
    }
    public static SecretKey generateSymmetricKey(String algo) throws
            NoSuchAlgorithmException
    {
        KeyGenerator kg = KeyGenerator.getInstance(algo);
        return kg.generateKey();
    }
    public static byte [] simpleSymmetricEncrype(Cipher cipher, SecretKey
            key, byte[] inputMas) throws InvalidKeyException, IllegalBlockSizeException,
            BadPaddingException
    {
        cipher.init(Cipher.ENCRYPT_MODE, key);
        return cipher.doFinal(inputMas);
    }
    public static byte [] simpleSymmetricDecrypt(Cipher cipher, SecretKey
            key, byte[] encryptMas) throws InvalidKeyException,
            IllegalBlockSizeException, BadPaddingException
    {
        cipher.init(Cipher.DECRYPT_MODE, key);
        return cipher.doFinal(encryptMas);
    }
    public static void main(String[] args) throws Exception
    {
        Path path = Paths.get("/home/heveline/Desktop/cripta/3_lab/text.txt");
        byte[] inputMessage= Files.readAllBytes(path);
        String masAlgos[] = {"GOST-28147", "AES", "DES", "BLOWFISH"};
        for(String algo : masAlgos)
        {
            Cipher cipher = Cipher.getInstance(algo, "BC");
            SecretKey key = generateSymmetricKey(algo);
            byte encMas[] = simpleSymmetricEncrype(cipher, key,
                    inputMessage);
            byte decMas[] = simpleSymmetricDecrypt(cipher, key,
                    encMas);
            System.out.println("Алгоритм: " + algo);
            System.out.println("Секретный ключ: 0x" + new
                    String(Hex.encode(key.getEncoded())));
            System.out.println("Зашифрованное сообщение - 0x" + new
                    String(Hex.encode(encMas)));
            System.out.println("Расшифрованное сообщение - " + new
                    String(decMas));
            System.out.println("----------------------");
        }
    }
}