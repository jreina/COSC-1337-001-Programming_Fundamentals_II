import java.io.*;

public class Jul18
{
    public static void main(String args[]) throws java.io.IOException
    {
        InputStreamReader reader = new InputStreamReader(System.in);

        int ten, one;

        ten = reader.read();

        ten = ten - 48;

        System.out.println("ten " + ten);

        one = reader.read();

        one = one - 48;

        System.out.println("one " + one);

        //String s = "" + (char) ten + (char) one;
        //System.out.println("The Number = " + s);

        int n;

        reader.read();   // skip over the comma!

        n = 10*ten + one;
        System.out.println("n = " + n);

        for (int i=0; i<n; i++)
        {
            char c = (char) reader.read();
            System.out.println(c);
        }
    }
}
