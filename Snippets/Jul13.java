public class Jul13
{
    public static void main(String args[])
    {
        int ar[][];

        ar = new int[2][3];

        ar[1][2] = 5;

        int c=1;


        for (int i=0; i<ar.length; i++)
        {
            for (int j=0; j<ar[i].length; j++)
            {
                ar[i][j] = c;
                c++;
            }
        }

        for (int i=0; i<ar.length; i++)
        {
            for (int j=0; j<ar[i].length; j++)
            {
                System.out.println("ar[" + i + "][" + j + "] = " + ar[i][j]);
            }
        }
    }
}
