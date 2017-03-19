// find all primes < 1M using "The Sieve of Eratosthenes"

// example of sqrt method:  int root = (int) Math.sqrt(n);

public class Lab3start
{

    public static boolean ar[];

    public static void init(int n)
    {
        // put 'yo code here!
    }


    public static boolean isPrime(int n)
    {
        return ar[n];
    }

    public static void main(String args[])
    {
        int c=0;
        long start, end, mstime;

        final int LIMIT=1000000;

        start = System.currentTimeMillis();

        init(LIMIT);

        for (int i=2; i<LIMIT; i++) {
            if (isPrime(i)) {
                System.out.println(i);
                c++;
            }
        }

        end = System.currentTimeMillis();

        mstime = end - start;

        System.out.println("#primes = " + c + ", mstime = " + mstime);
    }
}
