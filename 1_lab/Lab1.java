<<<<<<< HEAD
import java.util.Scanner;
import java.io.*;
=======
// import java.util.Random;
import java.util.Scanner;

>>>>>>> 37fa1f4bd51d4862dcda14c7a39eb97adb5e3b0d

public class Lab1{
    public static void main(String[] args){
        Scanner vvod = new Scanner(System.in);
<<<<<<< HEAD
        System.out.print("Введите номер задания: ");
        int n = vvod.nextInt();
        if (n == 1)
            zadanie1();
        else
            System.out.print("Invalid number\n");
            return ;
=======
        System.out.print("Введите номер задания: \n");
        int n = vvod.nextInt();
        if (n == 1)
            zadanie1();
        else if (n == 2)
            zadanie2();
        // else if (n == 3)
        //     zadanie3();
		else if (n == 4)
			zadanie4();
		else if (n == 7)
			zadanie7();
        else
        {
            System.out.print("Invalid number\n");
        }
        vvod.close();
>>>>>>> 37fa1f4bd51d4862dcda14c7a39eb97adb5e3b0d
    }


    public static void zadanie1()
    {
<<<<<<< HEAD
=======
        System.out.print("Задание 1\n");
>>>>>>> 37fa1f4bd51d4862dcda14c7a39eb97adb5e3b0d
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
<<<<<<< HEAD
    } 
=======
        vvod.close();
    } 

    public static String encrypt_2(String str, int n)
    {
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
                    encrypt_w[i] = (char)(word[i] + n - 26);
                else
                {
                    if (word[i] + n < 65)
                        encrypt_w[i] = (char)(word[i] + n + 26);
                    else
                        encrypt_w[i] = (char)(word[i] + n);
                }
            }
            else if (word[i] > 96 && word[i] < 123)
            {
                if (word[i] + n > 123)
                    encrypt_w[i] = (char)(word[i] + n - 26);
                else
				{
					if(word[i] + n < 97)
						encrypt_w[i] = (char)(word[i] + n + 26);
					else
						encrypt_w[i] = (char)(word[i] + n);
				}
            }
            else if (word[i] > 1071 && word[i] < 1104)
            {
                if (word[i] + n > 1103)
                    encrypt_w[i] = (char)(word[i] + n - 32);
                else
				{
					if(word[i] + n < 1072)
                    	encrypt_w[i] = (char)(word[i] + n + 32);
					else
						encrypt_w[i] = (char)(word[i] + n);
				}
            }
            else if (word[i] > 1039 && word[i] < 1072)
            {
                if (word[i] + n > 1071)
                    encrypt_w[i] = (char)(word[i] + n - 32);
                else
				{
					if (word[i] < 1039)
                    	encrypt_w[i] = (char)(word[i] + n + 32);
					else
						encrypt_w[i] = (char)(word[i] + n);
				}
            }
            else
                encrypt_w[i] = word[i];
            i++;
        }
        str = String.valueOf(encrypt_w);
        return (str);
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
        str = encrypt_2(str, n);
        System.out.println(str);
        str = encrypt_2(str, -n);
        System.out.println(str);
        vvod_str.close();
        vvod_int.close();

    }

	// public static String encrypte_3(String str)
	// {
	// 	String res = "";
    //     int i = 0;
    //     int len = str.length();
    //     // char[] word = new char[len];
    //     // while (i < len)
    //     // {
    //     //     word[i] = str.charAt(i);
    //     //     i++;
    //     // }
    //     // char[] encrypt_w = new char[len];
    //     // i = 0;
    //     Random k = new Random();
	// 	// byte[] byte = new byte[];
	// 	while (i < len)
	// 	{
	// 		if(str == " ")
	// 			res += 256 * k.nextInt(1) + 4;
	// 		else
	// 		{
	// 			byte[] byte = Encoding.GetEncoding(1251).GetBytes(str.substring(i, 1));
				
	// 		}
	// 	}        
	// }
	
    // public static void zadanie3()
    // {
    //     Scanner vvod = new Scanner(System.in);
    //     System.out.print("Задание 3\n");
    //     System.out.print("Введите сообщение, которое нужно зашифровать\n");
    //     String str = vvod.nextLine();
    //     encrypt_3(str);
	// 	vvod.close();
    // }

		static int check(String str, char a)
		{
			char[] array = new char[str.length()];
			int i = 0;
			while (i < str.length())
			{
				array[i] = str.charAt(i);
				i++;
			}
			i = 0;
			while (i < str.length())
			{
				if (a == array[i])
					return (1);
				i++;
			}
			return (0);
		}
	
		public static int j_found(char ch, char[][] array)
		{
			int i = 0;
			while (i < 5)
			{
				int j = 0;
				while (j < 5)
				{
					if (array[i][j] == ch)
						return (j);
					j++;
				}
				i++;
			}
			return (0);
		}
	
	public static int i_found(char ch, char[][] array)
	{
		int i = 0;
		while (i < 5)
		{
			int j = 0;
			while (j < 5)
			{
				if (array[i][j] == ch)
					return (i);
				j++;
			}
			i++;
		}
		return (0);
	}
	public static String encrypt_4(String str, char[][] array, int len)
	{
		char[] word = new char[str.length()];
		int i = 0;
		// int len = str.length();
		while (i < len)
		{
			word[i] = str.charAt(i);
			i++;
		}
		i = 0;
		int k = 0;
		int j = 0;
		i = 0;
		while (i < len)
		{
			k = i_found(word[i], array);
			j = j_found(word[i], array);
			if (k == 0 && j == 0)
				word[i] = ' ';
			else if (j + 2 < 5)
				word[i] = array[k][j + 2];
			else
				word[i] = array[k][j - 2];
			i++;
		}
		str = String.valueOf(word);
		return (str);
	}

	public static String decrypt_4(String str, char[][] array, int len)
	{
		char[] word = new char[str.length()];
		int i = 0;
		while (i < len)
		{
			word[i] = str.charAt(i);
			i++;
		}
		i = 0;
		int k = 0;
		int j = 0;
		i = 0;
		while (i < len)
		{
			k = i_found(word[i], array);
			j = j_found(word[i], array);
			if (k == 0 && j == 0)
				word[i] = ' ';
			else if (j - 2 > 0)
				word[i] = array[k][j - 2];
			else
				word[i] = array[k][j + 2];
			i++;
		}
		str = String.valueOf(word);
		return (str);
	}

	public static void zadanie4(){
		Scanner vvod = new Scanner(System.in);
		System.out.println("Задание 4\n");
		System.out.println("Введите сообщение, которое нужно зашифровать\n");
		String str = vvod.nextLine();
		String key = "table";
		int len = str.length();
		// static int flag;
		char[][] array = new char[5][5];
		int i = 0;
		while (i < key.length())
		{
			array[0][i] = key.charAt(i);
			i++;
		}
		i = 1;
		char ch = 'a';
		while (i  < 5)
		{
			int j = 0;
			while (j < 5)
			{
				if (ch == 'j')
				{
					ch++;
					j--;
				}
				else if (check(key, ch) == 0)
				{
					array[i][j] = ch;
					ch++;
				}
				else if (check(key, ch) == 1)
				{
					j--;
				ch++;
				}
				j++;
			}
			i++;
		}
		// if (str.length() % 2 == 0)
		str = encrypt_4(str, array, len);
		System.out.println(str);
		// System.out.println(flag);
		str = decrypt_4(str, array, len);
		System.out.println(str);
		// else
		// 	System.out.println("Even sentence\n");
		// i = 0;
		// while (i < 5)
		// {
		// 	int j = 0;
		// 	while (j < 5)
		// 	{
		// 		System.out.printf("%c  ", array[i][j]);
		// 		j++;
		// 	}
		// 	System.out.printf("\n");
		// 	i++;
		// }
		vvod.close();
	}

	public static void zadanie7(){
		Scanner vvod = new Scanner(System.in);
		System.out.println("Задание 7\n");
		System.out.println("Введите сообщение, которое нужно зашифровать\n");
		String str = vvod.nextLine();
		str = encrypt_2(str, 13);
		// str = encrypte_2(str, 13);
		System.out.println(str);
		str = encrypt_2(str, -13);
		System.out.println(str);
		vvod.close();
	}

>>>>>>> 37fa1f4bd51d4862dcda14c7a39eb97adb5e3b0d
}