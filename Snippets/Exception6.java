import java.io.*;

public class Exception6
{
    public static int inputWholeNumber() throws IOException
    {
        BufferedReader input = new BufferedReader
                              (new InputStreamReader(System.in));
        String str = "";
        int n;

        System.out.print("enter a whole number:  ");
        str = input.readLine();

        n = Integer.parseInt(str);

        if (n < 0) {
            throw new NumberFormatException("Not a WHOLE NUMBER");
        }

        System.out.println("Bottom of inputWholeNumber!");
        return n;
    }

    public static void main(String argv[])
    {
        int myint;

        while (true) {
            try {
                myint = inputWholeNumber();
            } catch (Exception e) {
                if (e.getMessage() != null)
                    System.out.println("message = " + e.getMessage());
                myint = -1;
            }
            System.out.println("myint = " + myint);
        }
    }
}
