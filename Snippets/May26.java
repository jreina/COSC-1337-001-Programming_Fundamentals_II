public class May26
{
    public static void main(String argv[])
    { 
        int ar[] = { 7, 5, 2, 8, 4, 9, 6 };

        for (int i=0; i<ar.length-1; i++)
        {
            for (int j=i+1; j<ar.length; j++)
            {
System.out.println("comparing ar[" + i + "] to ar[" + j + "]");
                if (ar[j] < ar[i])
                {
                    int tmp = ar[i];
                    ar[i] = ar[j];
                    ar[j] = tmp;
                }
            }
        }

        for (int i=0; i<ar.length; i++)
        {
            System.out.println("ar[" + i + "] = " + ar[i]);
        }
    }
}

