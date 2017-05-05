public class Lab2
{
    public static void main(String argv[])
    {
        final int MAX = 1000000;
        int ar[] = { 999999, 7, 5, 2, 8, 6, 30, 1, 2, 4, 9, 6 };
        int sorted[] = new int[ar.length];
        int minIndex;
        
        for(int i = 0; i < ar.length; i++)
        {
            minIndex = 0;
            for(int j = 0; j < ar.length; j++)
            {
                if(ar[j] < ar[minIndex])
                {
                    minIndex = j;
                }
            }
            sorted[i] = ar[minIndex];
            ar[minIndex] = MAX;
        }
        
        // print sorted array:
        for (int i=0; i<sorted.length; i++)
        {
            System.out.println("sorted[" + i + "] = " + sorted[i]);
        }
    }
}