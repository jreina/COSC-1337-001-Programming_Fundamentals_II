// an example of what we should NOT do!!!

public class Exception7
{
    public static void main(String args[])
    {
        int ar[] = new int[10];

        for (int i=0; i<= ar.length; i++) {
            System.out.println("i = " + i);
            try {
                ar[i] = 0;
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("No problem!");
            }
        }
    }
}
