import java.io.*;

public class Exception2
{
    public static int inputWholeNumber()
    {
        BufferedReader input = new BufferedReader
                              (new InputStreamReader(System.in));
        String str = "-1";
        int n;

        System.out.print("enter a whole number:  ");
        try {
            str = input.readLine();
        } catch (IOException e) {
            System.out.println("IO Exception.");
        } 

        n = Integer.parseInt(str);

        return n;
    }

    public static void main(String argv[])
    {
        int myint;

        while (true) {
            myint = inputWholeNumber();
            System.out.println("myint = " + myint);
        }
    }
}
