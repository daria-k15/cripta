import java.util.Scanner;
import java.io.*;

public class Lab1{
    public static void main(String[] args){
        Scanner vvod = new Scanner(System.in);
        System.out.print("Введите номер задания: ");
        int n = vvod.nextInt();
        if (n == 1)
            zadanie1();
        else
            System.out.print("Invalid number\n");
            return ;
    }


    public static void zadanie1()
    {
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
    } 
}