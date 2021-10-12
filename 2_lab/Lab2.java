import java.util.Scanner;

public class Lab2{
    public static void main(String[] args){
        Scanner vvod = new Scanner(System.in);
        System.out.println("Enter number of task: ");
        int n = vvod.nextInt();
        if (n == 1)
            zadanie1();
        else
            System.out.println("Invalid number!");
    }
    vvod.close();
}

public static String encrypt_1 (String str, String pkey)
{
    byte encrypt[] = str.getBytes();
    byte key[] = pkey.getBytes();
    byte res[] = new byte[pkey.length()];
    for(int i = 0; i < str.length(); i++){
        res[i] = (byte)(str[i] ^ key[i % key.length()]);
    }
    return (String.valueOf(res));
}
public static void zadanie1(){
    System.out.println("-----1st task----");
    Scanner vvod = new Scanner();
    System.out.println("Enter ")
    System.out.println("Enter message to encrypt");
    String str = vvod.nextLine();
    System.out.println("Enter the message key");
    String pkey = vvod.nextLine();
    str = encrypt_1(str, key);
    System.out.println(str);
}