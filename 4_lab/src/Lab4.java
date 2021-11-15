import java.math.BigInteger;
import java.util.Scanner;
import java.util.Random;
public class Lab4 {
    public static void main(String[] args){
        Scanner vvod = new Scanner(System.in);
        Scanner vvod_str = new Scanner(System.in);
        System.out.println("Enter p");
        int p = vvod.nextInt();
        System.out.println("Enter q");
        int q = vvod.nextInt();
        int n = p * q;
        int phi = (p - 1) * (q - 1);
        int d = getD();
        System.out.println("d = " + d);
        int e = getE(phi, d);
        System.out.println("e = " + e);
        int[] openKey = {e, n};
        int[] closeKey = {d, n};
        System.out.println("Enter message");
        String message = vvod_str.nextLine();
        int len = message.length();
        BigInteger[] encRes = encrypt(message,openKey);
        System.out.println("Encrypted message");
        for (BigInteger num : encRes)
            System.out.print(num + " ");
        BigInteger[] decRes = decrypt(encRes, closeKey, len);
        System.out.println();
        System.out.println("Decrypted message");
        char[] toPrint = new char[len];
        for (int i = 0; i < len; i++)
             toPrint[i] = (char)(decRes[i].intValue());
        System.out.println(toPrint);
    }

    static BigInteger[] encrypt(String str, int[] openKey) {
        BigInteger[] res = new BigInteger[str.length()];
        int i = 0;
        while (i < str.length()) {
                BigInteger val = BigInteger.valueOf((str.charAt(i)));
                BigInteger tmp = val.pow(openKey[0]);
                res[i] = tmp.remainder(BigInteger.valueOf(openKey[1]));
            i++;
        }
        return (res);
    }

    static BigInteger[] decrypt(BigInteger[] encRes, int[] closeKey, int len){
        BigInteger[] res = new BigInteger[len];
        int i = 0;
        while (i < len){
            BigInteger tmp = encRes[i].pow(closeKey[0]);
            res[i] = tmp.remainder(BigInteger.valueOf(closeKey[1]));
            i++;
        }
        return (res);
    }

    static int isPrime(int nb) {
        int i = 2;
        if (nb < 2)
            return (0);
        while ((nb % i) != 0)
            i++;
        if (i == nb)
            return (1);
        return (0);
    }
    static int getD(){
        Random rand = new Random();
        int d = 1;
        while (isPrime(d) != 1)
            d = rand.nextInt(100);
        return (d);
    }
    static int getE(int phi, int d){
        int e = 1;
        for (int k = 2; k < 100; k++){
            if ((phi * k + 1) % d == 0){
                e = (phi * k + 1) / d;
                break ;
            }
        }
        return (e);
    }
}
