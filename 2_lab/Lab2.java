import java.util.Scanner;
import java.util.Random;

public class Lab2{
    public static void main(String[] args){
        Scanner vvod = new Scanner(System.in);
        System.out.println("Enter number of task: ");
        int n = vvod.nextInt();
        if (n == 1)
            task1();
        else if (n == 2)
            task2();
        else if (n == 3)
            task3();
        else
            System.out.println("Invalid number!");
        vvod.close();
    }

    public static byte[] encrypt_1 (String str, String pkey)
    {
        byte[] encrypt = str.getBytes();
        byte[] key = pkey.getBytes();
        byte[] res = new byte[str.length()];
        for(int i = 0; i < encrypt.length; i++){
            res[i] = (byte)(encrypt[i] ^ key[i%key.length]);
        }
        return ((res));
    }

    public static String decrypt_1(byte[] pText, String pkey){
        byte[] res = new byte[pText.length];
        byte[] key = pkey.getBytes();
        
        for (int i = 0; i < pText.length; i++){
            res[i] = (byte) (pText[i] ^ key[i % key.length]);
        }
        return new String (res);
    }
    public static void task1(){
        System.out.println("-----1st task----");
        Scanner vvod = new Scanner(System.in);
        System.out.println("Enter message to encrypt");
        String str = vvod.nextLine();
        System.out.println("Enter the message key");
        String pkey = vvod.nextLine();
        byte[] enc = encrypt_1(str, pkey);
        System.out.println("Encrypted message: " + enc);
        String dec = decrypt_1(enc, pkey);
        System.out.println("Decrypted message: " + dec);
        vvod.close();
    }

    public static void task2(){
        System.out.println("-----2nd task----");
        Scanner vvod = new Scanner(System.in);
        System.out.println("Enter message to encrypt");
        String str = vvod.nextLine();
        char[] enc = str.toCharArray();
        char[] key = new char[enc.length];
        char[] res = new char[enc.length];
        Random ran = new Random();
        for (int i = 0; i < enc.length; i++){
            key[i] = (char)(ran.nextInt(20));
            res[i] = (char)(enc[i] ^ key[i]);
        }
        System.out.println("Encrypted message: " + String.valueOf(res));
        char[] dec = new char[enc.length];
        for (int i = 0; i < enc.length;i++){
            dec[i] = (char)(res[i] ^ key[i]);
        }
        System.out.println("Decrypted message: " + String.valueOf(dec));
        vvod.close();
    }

    public static int bitsInNumber(int n) {
        int res = 0;
        while (n > 0) {
            n >>= 1;
            res++;
        }
        return res;
    }

    public static String binar(int n) {
        int i = bitsInNumber(n) + 1;
        int bit;
        String res = "";
        while ( --i >= 0 ){
            bit = (n & (1 << i)) == 0 ? 0 : 1;
            res+=bit;
        }
        return (res);
    }

    public static void task3(){
        Random ran = new Random();
        System.out.println("-----3rd task-----");
        Scanner vvod = new Scanner(System.in);
        System.out.println("Enter message to encrypt");
        String str = vvod.nextLine();
        String[] arr = str.split(" ");
        int n = 0;
        String lol = "";
        String[] des = new String[arr.length];
        int[] key = new int[arr.length];
        int[] res = new int[arr.length];
        for (int i = 0; i < arr.length; i++){
            String tmp = arr[i];
            for (int j = tmp.length() - 1, k=1; j >= 0; j--, k*=2){
                n += (tmp.charAt(j) - '0') * k;
            }
            key[i] = ran.nextInt(20);
            res[i] = (char)(n ^ key[i]);
            des[i] = binar(res[i]);
            n = 0;
        }
        for (String word : des){
            lol += word + " ";
        }
        System.out.println("Encrypted message: " + lol);
        lol = "";
        for (int i = 0; i < arr.length; i++){
            String tmp = des[i];
            for (int j = tmp.length() - 1, k=1; j >= 0; j--, k*=2){
                n += (tmp.charAt(j) - '0') * k;
            }
            // key[i] = ran.nextInt(10);
            res[i] = (char)(n ^ key[i]);
            des[i] = binar(res[i]);
            n = 0;
        }
        for (String word : des){
            lol += word + " ";
        }
        System.out.println("Encrypted message: " + lol);
        vvod.close();
    }

}