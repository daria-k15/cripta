import java.util.Scanner;
import java.io.*;


// public int lentgh();

public class Lab1{
    public static void main(String[] args){
        Scanner vvod = new Scanner(System.in);
        System.out.print("Введите номер задания: ");
        int n = vvod.nextInt();
        if (n == 1)
            zadanie1();
    }

    public static void zadanie1()
    {
        int x;
        int y;
        int col = 5;
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
        // System.out.printf("%d\n", len);
        // System.out.printf("%d\n", line);
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
                System.out.printf("%c", array[x][y]);
                x++;
            }
            System.out.printf("\n");
            y++;
        }
        System.out.printf("\n");
        x = 0;
        while (x < col)
        {
            y = line - 1;
            while (y >= 0)
            {
                System.out.printf("%c ", array[x][y]);
                y--;
            }
            System.out.printf("\n");
            x++;
        }
    } 
}