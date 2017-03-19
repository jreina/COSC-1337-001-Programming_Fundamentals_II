// find all primes < 1M using BRUTE FORCE, checking
// ALL whole numbers less than square root as possible
// factors of 'n'

public class May24b
{

    public static boolean isPrime(int n)
    {
        int limit = n/2;
        for (int i=2; i<limit; i++) {
            if ((n%i) == 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String args[])
    {
        int c=0;
        long start, end, mstime;

        final int LIMIT=1000000;  // 1M took ~800 secs.

        start = System.currentTimeMillis();

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
