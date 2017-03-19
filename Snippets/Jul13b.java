public class Jul13b
{
    public static void main(String args[])
    {
        int ar[][] = { { 1, 2, 3 }, { 4, 5 }, { 6, 7, 8, 9 } };

        for (int i=0; i<ar.length; i++)
        {
            for (int j=0; j<ar[i].length; j++)
            {
                System.out.println("ar[" + i + "][" + j + "] = " + ar[i][j]);
            }
        }
    }
}
