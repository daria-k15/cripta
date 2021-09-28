// import java.util.Random;
import java.util.Scanner;
public class Lab1{
    public static void main(String[] args){
        Scanner vvod = new Scanner(System.in);
        System.out.print("Enter number of task: \n");
        int n = vvod.nextInt();
        if (n == 1)
            zadanie1();
        else if (n == 2)
            zadanie2();
        // else if (n == 3)
        //     zadanie3();
		else if (n == 4)
			zadanie4();
		else if (n == 5)
			zadanie5();
		else if (n == 6)
			zadanie6();
		else if (n == 7)
			zadanie7();
        else
        {
            System.out.print("Invalid number\n");
        }
        vvod.close();
    }


    public static void zadanie1()
    {
        System.out.print("1st task\n");
        int x;
        int y;
        int col = 6;
        int i = 0;
        Scanner vvod = new Scanner(System.in);
        System.out.print("Enter a message\n");
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
                        encrypt_w[i] = (char)(word[i] + n + 32);
                    else
                        encrypt_w[i] = (char)(word[i] + n);
                }
            }
            else if (word[i] > 96 && word[i] < 123)
            {
                if (word[i] + n > 122)
                    encrypt_w[i] = (char)(word[i] + n - 26);
                else
				{
					if(word[i] + n < 97)
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
        System.out.print("2nd task\n");
        System.out.print("Enter a shift\n");
        int n = vvod_int.nextInt();
        System.out.print("Enter a message\n");
        String str = vvod_str.nextLine();
        System.out.printf("\n");
        str = encrypt_2(str, n);
        System.out.println(str);
        str = encrypt_2(str, -n);
        System.out.println(str);
        vvod_str.close();
        vvod_int.close();

    }

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
        int k1;
        int j1;
		int j = 0;
		i = 0;
		while (i < len)
		{
			k = i_found(word[i], array);
			j = j_found(word[i], array);
			k1 = i_found(word[i + 1], array);
			j1 = j_found(word[i + 1], array);
            System.out.println("k = " + k);
            System.out.println("j = " + j);
            System.out.println("k1 = " + k1);
            System.out.println("j1 = " + j1);
			if (k == 0 && j == 0)
                i++;
            // else if ((k == 0 && j == 0) && (k1 != 0 || j1 != 0))
            //     i++;
            else if (k > k1){
                if (j == 3 && j1 == 4){
                    word[i] = array[k][j + 1];
                    word[i + 1] = array[k1][0];
                    i+= 2;
                }
                else if ((j == 0 && k == 0) ||(j1 == 0 && k1 == 0))
                    i++;
                else{
                    word[i] = array[k][j + 2];
                    word[i + 1] = array[k1][j1 - 2];
                    i+= 2;
                }
            }
            else {
                if (j == 3 && j1 == 4){
                    word[i] = array[k][j + 1];
                    word[i + 1] = array[k1][0];
                    i+= 2;
                }
                else{
                word[i] = array[k][j + 2];
                word[i + 1] = array[k1][j1 - 2];
                i+= 2;}
                
            }
            System.out.printf("%c", word[i]);
            System.out.printf("%c", word[i+1]);
			// else if (j + 2 < 5)
			// 	word[i] = array[k][j + 2];
			// else
			// 	word[i] = array[k][j - 2];
			// i+= 2;
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
            // else if (j + 2 <= 4)
            //     word[i] = array[k][j + 2];
			else if (j - 2 > 0)
            word[i] = array[k][j - 2];
            else if (j - 2 == 0)
            word[i] = array[k][j - 2];
			else
            word[i] = array[k][j + 2];
			i++;
		}
		str = String.valueOf(word);
		return (str);
	}
    public static String lol(String str, char[][] array)
    {
        char[]word = new char[str.length()];
        int i = 0;
		int j = 0;
        // char[][] encr = new char[str.length()/2][2];
        while (i < str.length())
        {
			if (str.charAt(i) == ' ')
				i++;
			else{
            word[j] = str.charAt(i);
            j++;
			i++;
		}	
            
        }
        i = 0;
		str = String.valueOf(word);
        int k;
        int k1, j1;
		
       while (i < str.length() - 1)
	   {
		   k = i_found(word[i], array);
		   j = j_found(word[i], array);
		   k1 = i_found(word[i+1], array);
		   j1 = j_found(word[i+1], array);
		//    if ((k == 0 && j == 0) || (k1 == 0 && j1 == 0))
		   		// i++;
		  	if (j1 == j)
		   {
			   word[i] = array[k][j + 2];
			   word[i+1] = array[k1][j1+2];
			   i = i+2;
			}
			else
			{
				word[i] = array[k][j1];
				word[i + 1] = array[k1][j];
				i = i + 2;
			}
		}
			String res = String.valueOf(word);
			System.out.println(res);
			return(res);
    }
    
	public static String lol_d(String str, char[][] array, String val)
	{
		char[]word = new char[str.length()];
        int i = 0;
		// char[] kek = new char[val.length()];
		// while (i < val.length())
		// {
		// 	kek[i] = val.charAt(i);
		// 	i++;
		// }
		// i=0;
        while (i < str.length())
        {
            word[i] = str.charAt(i);
            i++;
            
        }
        i = 0;
        int k, j;
        int k1, j1;
       while (i < str.length() - 1)
	   {
		   k = i_found(word[i], array);
		   j = j_found(word[i], array);
		   k1 = i_found(word[i+1], array);
		   j1 = j_found(word[i+1], array);
		   if ((k == 0 && j == 0) || (k1 == 0 && j1 == 0))
		   		i++;
		   if (j1 == j)
		   {
			   word[i] = array[k][j - 2];
			   word[i+1] = array[k1][j1 - 2];
			   i = i + 2;
			}
			else
			{
				word[i] = array[k][j1];
				word[i + 1] = array[k1][j];
				i = i + 2;
			}
			}
			String res = String.valueOf(word);
			System.out.println(res);
			return (res);
	}

	public static void zadanie4(){
        Scanner vvod = new Scanner(System.in);
		System.out.println("4th task\n");
		System.out.println("Enter a message\n");
		String str = vvod.nextLine();
		String key = "cable";
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
        i = 0;
        while (i < 5)
        {
           int j = 0;
            while (j < 5)
            {
                System.out.printf("%c  ", array[i][j]);
                j++;
            }
            System.out.println();
            i++;
        }
		System.out.printf("len 1= %d\n", str.length());
		
		String encr = lol(str, array);
		System.out.printf("len 2= %d\n", encr.length());
		
		String dec = lol_d(encr, array, str);
		System.out.printf("len 3= %d\n", dec.length());

		vvod.close();
	}

	public static void zadanie5()
	{
		Scanner vvod_str = new Scanner(System.in);
        Scanner vvod_int = new Scanner(System.in);
        System.out.print("5th task\n");
        System.out.print("Enter a shift\n");
        int n = vvod_int.nextInt();
        System.out.print("Enter a message\n");
        String str = vvod_str.nextLine();
        System.out.printf("\n");
        str = encrypt_2(str, n);
        System.out.println(str);
        str = encrypt_2(str, -n);
        System.out.println(str);
        vvod_str.close();
        vvod_int.close();

	}

	public static void zadanie6()
	{
		System.out.println("6th task\n");
		String str = "Pbatenghyngvbaf! Vg'f n Pnrfne pvcure!";
		for (int i = 0; i < 26; i++)
		{
			str = encrypt_2(str, i);
			System.out.println(i + "." + str);
		}
	}

	public static void zadanie7(){
		Scanner vvod = new Scanner(System.in);
		System.out.println("Задание 7\n");
		System.out.println("Введите сообщение, которое нужно зашифровать\n");
		String str = vvod.nextLine();
		str = encrypt_2(str, 13);
		System.out.println(str);
		str = encrypt_2(str, -13);
		System.out.println(str);
		vvod.close();
	}

}