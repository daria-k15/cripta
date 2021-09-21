import java.util.Scanner;
// import java.io.*;



public class Lab1{
    public static void main(String[] args){
        Scanner vvod = new Scanner(System.in);
        System.out.print("Введите номер задания: ");
        int n = vvod.nextInt();
        if (n == 1)
            zadanie1();
        else if (n == 2)
            zadanie2();
        // else if (n == 3)
        //     zadanie3();
        else
        {
            System.out.print("Invalid number\n");
        }
        vvod.close();
    }


    public static void zadanie1()
    {
        System.out.print("Задание 1\n");
        int x;
        int y;
        int col = 6;
        int i = 0;
        Scanner vvod = new Scanner(System.in);
        System.out.print("Введите сообщение, которое нужно зашифровать\n");
        String str = vvod.nextLine();
        int len = str.length();
        int line;
        if (len % col > 0)
            line = len / col + 1;
        else
            line = len / col;
        char[] word = new char[len];
        char[][] array = new char[col][line];
        while (i < len)
        {
            word[i] = str.charAt(i);
            i++;
        }
        i = 0;
        y = 0;
        while (y < line)
        {
            x = 0;
            while (x < col)
            {
                if (i < len)
                {
                    array[x][y] = word[i];
                    i++;
                }
                else
                    array[x][y] = ' ';
                x++;
            }
            y++;
        }
        i = 0;
        y = 0;
        while (y < line)
        {
            x = 0;
            while (x < col)
            {
                System.out.printf("%c ", array[x][y]);
                x++;
            }
            System.out.printf("\n");
            y++;
        }
        System.out.printf("\n");
        char [] new_arr = new char[col * line];
        x = 0;
        int x1 = 0;
        while (x < col)
        {
            y = line - 1;
            while (y >= 0)
            {
                new_arr[x1] = array[x][y];
                x1++;
                y--;
            }
            x++;
        }
        x1 = 0;
        while (x1 < line * col)
        {
            System.out.printf("%c", new_arr[x1]);
            x1++;
        }
        System.out.printf("\n");
        x1 = 0;
        x = 0;
        while (x < col)
        {
            y = line - 1;
            while (y >= 0)
            {
                array[x][y] = new_arr[x1];
                y--;
                x1++;
            }
            x++;
        }
        System.out.printf("\n");
        y = 0;
        while (y < line)
        {
            x = 0;
            while (x < col)
            {
                System.out.printf("%c ", array[x][y]);
                x++;
            }
            System.out.printf("\n");
            y++;
        }
        vvod.close();
    } 

    public static void zadanie2()
    {
        Scanner vvod_str = new Scanner(System.in);
        Scanner vvod_int = new Scanner(System.in);
        System.out.print("Задание 2\n");
        System.out.print("Введите сдвиг\n");
        int n = vvod_int.nextInt();
        System.out.print("Введите сообщение, которое нужно зашифровать\n");
        String str = vvod_str.nextLine();
        System.out.printf("\n");
        int i = 0;
        int len = str.length();
        char[] word = new char[len];
        while (i < len)
        {
            word[i] = str.charAt(i);
            i++;
        }
        char[] encrypt_w = new char[len];
        i = 0;
        while (i < len)
        {
            if (word[i] > 64 && word[i] < 91)
            {
                if (word[i] + n > 90)
                    encrypt_w[i] = (char)(65 + n - 1);
                else
                    encrypt_w[i] = (char)(word[i] + n - 1);
            }
            else if (word[i] > 96 && word[i] < 123)
            {
                if (word[i] + n > 123)
                    encrypt_w[i] = (char)(97 + n - 1);
                else
                    encrypt_w[i] = (char)(word[i] + n - 1);
            }
            else if (word[i] > 1071 && word[i] < 1104)
            {
                if (word[i] + n > 1104)
                    encrypt_w[i] = (char)(1071 + n - 1);
                else
                    encrypt_w[i] = (char)(word[i] + n - 1);
            }
            else if (word[i] > 1039 && word[i] < 1072)
            {
                if (word[i] + n > 1072)
                    encrypt_w[i] = (char)(1040 + n -1);
                else
                    encrypt_w[i] = (char)(word[i] + n - 1);
            }
            else
                encrypt_w[i] = (char)(word[i] + n - 1);
            i++;
        }
        i = 0;
        int code;
        while (i < len)
        {
            code = (int)word[i];
            System.out.printf("%d ", code);
            i++;
        }
        i = 0;
        while (i < len)
        {
            System.out.printf("%c", encrypt_w[i]);
            i++;
        }
        System.out.print("\n");
        System.out.printf("\n");
        i = 0;
        while (i < len)
        {
            if (encrypt_w[i] > 64 && encrypt_w[i] < 91)
            {
                if (encrypt_w[i] + n > 90)
                    word[i] = (char)(91 - n + 1);
                else
                    word[i] = (char)(encrypt_w[i] - n + 1);
            }
            else if (encrypt_w[i] > 96 && encrypt_w[i] < 123)
            {
                if (encrypt_w[i] + n > 122)
                    word[i] = (char)(123 - n + 1);
                else if (encrypt_w[i] - n < 97)
                {
                    System.out.printf("%d\n", encrypt_w[i] - n + 1);
                    word[i] = (char)(123 - ( 97 -( encrypt_w[i] - n + 1)));
                }
                else
                    word[i] = (char)(encrypt_w[i] - n + 1);
            }
            else if (encrypt_w[i] > 1071 && encrypt_w[i] < 1104)
            {
                if (encrypt_w[i] + n > 1104)
                    word[i] = (char)(1071 - n + 1);
                else
                    word[i] = (char)(encrypt_w[i] - n + 1);
            }
            else if (encrypt_w[i] > 1039 && word[i] < 1072)
            {
                if (encrypt_w[i] + n > 1072)
                    word[i] = (char)(1040 - n + 1);
                else
                    word[i] = (char)(encrypt_w[i] - n + 1);
            }
            else
                word[i] = (char)(encrypt_w[i] - n + 1);
            i++;
        }
        i = 0;
        while (i < len)
        {
            code = (int)word[i];
            System.out.printf("%d ", code);
            i++;
        }
        i = 0;
        while (i < len)
        {
            System.out.printf("%c", word[i]);
            i++;
        }
        vvod_str.close();
        vvod_int.close();

    }

    // public static void zadanie3()
    // {
    //     Scanner vvod = new Scanner(System.in);
    //     String str = vvod.nextLine();
    // }
}