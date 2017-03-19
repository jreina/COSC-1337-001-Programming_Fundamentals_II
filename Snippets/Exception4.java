import java.io.*;

public class Exception4
{
    public static int inputWholeNumber()
    {
        BufferedReader input = new BufferedReader
                              (new InputStreamReader(System.in));
        String str = "";
        int n;

        System.out.print("enter a whole number:  ");
        try {
            str = input.readLine();
        } catch (IOException e) {
            System.out.println("IO Exception.  Try again");
        } 

        try {
            n = Integer.parseInt(str);
        } catch (NumberFormatException e) {
            System.out.println("Non Integer input.  Try again");
            return -1;
        }

        if (n < 0) {
            throw new NumberFormatException("Not a Whole Number");
            // note:  this is an unchecked exception - not caught 
            // by compiler!
        }

        System.out.println("THE END of inputWholeNumber");

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
