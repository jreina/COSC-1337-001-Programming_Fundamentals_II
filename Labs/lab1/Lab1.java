public class Lab1
{
    static int[] primes;
    static int numPrimes;
    public static void main(String args[])
    {
        long start, end, mstime;
        start = System.currentTimeMillis();

        final int LIMIT=1000000;  // 1M took ~800 secs.
        numPrimes = 0;
        primes = new int[LIMIT];
        primes[0] = 2;

        for (int i=2; i<LIMIT; i++) {

            if (isPrime(i)) {
                System.out.println(i);
                numPrimes++;
            }
        }

        end = System.currentTimeMillis();

        mstime = end - start;

        System.out.println("#primes = " + numPrimes + ", mstime = " + mstime);
    }
    public static boolean isPrime(int candidate)
    {
        int maxValue = (int) Math.sqrt(candidate);
        for(int i = 0; primes[i] <= maxValue; i++)
        {
            if ((candidate % primes[i]) == 0) return false;
        }
        primes[numPrimes] = candidate;
        return true;
    }
}
