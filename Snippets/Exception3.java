import java.io.*;

public class Exception3
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
            System.out.println("IO Exception.  Try again");
        } 

        try {
            System.out.println("before parseInt");
            n = Integer.parseInt(str);
            System.out.println("after parseInt");
        } catch (NumberFormatException e) {
            System.out.println("Non Integer input.  Try again");
            //return -1;
            n = -1;
        }

        System.out.println("bottom of inputWholeNumber, returning " + n);
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
