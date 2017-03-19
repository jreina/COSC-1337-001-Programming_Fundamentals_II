import java.io.*;

public class Exception1
{
    public static int inputWholeNumber() throws IOException
    {
        BufferedReader input = new BufferedReader
                              (new InputStreamReader(System.in));
        String str;
        int n;

        System.out.print("enter a whole number:  ");
        str = input.readLine();

        n = Integer.parseInt(str);

        return n;
    }

    public static void main(String argv[]) throws IOException
    {
        int myint;

        while (true) {
            myint = inputWholeNumber();
            System.out.println("myint = " + myint);
        }
    }
}
