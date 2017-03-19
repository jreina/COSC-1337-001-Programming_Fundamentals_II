import java.io.*;

// an example of what we should NOT do!!!

public class Exception8
{
    public static void main(String args[])
    {
        try {


            // body of main method goes here!

throw new IOException("this is a test");



        } catch (Exception e) {
            System.out.println("No problem!");
        }
    }
}
