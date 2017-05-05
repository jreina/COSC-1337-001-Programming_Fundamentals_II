public class Lab3
{
    public static void main(String argv[])
    {
        final int MAX = 1000000;
        
        // Reference variable to hold number of numPrimes
        int numPrimes = 0;
        
        // New up a bool array. We need the last index to be equal to MAX, so we add 1
        boolean prime[] = new boolean[MAX + 1];
        
        // Set all positions to true (except 0 and 1)
        for(int i = 2; i < prime.length; i++) prime[i] = true;
        
        // Loop through all values
        for(int i = 2; i < prime.length; i++)
        {
            // Check if i has been sieved
            if(prime[i])
            {
                // Increment numPrimes and knock out multiples if not
                numPrimes++;
                for(int j = i * 2; j < prime.length; j += i)
                {
                    prime[j] = false;
                }
            }
        }
        
        // Loop through all values again
        for(int i = 2; i < prime.length; i++)
        {
            // Print out numPrimes
            if(prime[i]) System.out.println(i);
        }
        
        // Print out the number of numPrimes
        System.out.println(numPrimes);
    }
}