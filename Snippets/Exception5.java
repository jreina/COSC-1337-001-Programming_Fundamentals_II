import java.io.*;

public class Exception5
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
            throw new NumberFormatException("not a WHOLE NUMBER");
        }

        System.out.println("Bottom of inputWholeNumber!");
        return n;
    }

    public static void main(String argv[])
    {
        int myint;

        while (true) {
            try {
System.out.println("BEFORE inputWholeNumber");
                myint = inputWholeNumber();
System.out.println("AFTER inputWholeNumber");
            } catch (NumberFormatException e) {
                System.out.println("Number Format Error");
                if (e.getMessage() != null)
                    System.out.println("message = " + e.getMessage());
                myint = -1;
            } catch (IOException e) {
                System.out.println("IOException");
                myint = -1;
            }
            System.out.println("myint = " + myint);
        }
    }
}
