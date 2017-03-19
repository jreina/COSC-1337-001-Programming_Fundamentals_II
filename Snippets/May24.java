import java.io.*;

public class May24
{

    public static boolean isPrime(int n)
    {
        for (int i=2; i<n; i++) {
            if ((n%i) == 0) {
                System.out.println(n + " is divisible by " + i);
                return false;
            }
        }
        return true;
    }

    public static void main(String args[]) throws IOException
    {
        String str;

        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            System.out.println("enter a whole number or \"quit\":");
            str = input.readLine();

            if (str.equals("quit")) break;

            if (isPrime(Integer.parseInt(str))) {
                System.out.println("IS PRIME");
            } else {
                System.out.println("is NOT prime");
            }
        }
    }
}
