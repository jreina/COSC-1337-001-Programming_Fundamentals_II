public class Jun14
{
    public static void main(String args[])
    {
        String str = "hello world goodbye";
                  //  0123456789012345678
                  //       i     j

        int len = "hello".length();
        System.out.println("len = " + len);

        len = "".length();
        System.out.println("len = " + len);

        //System.out.println("this is the quote mark: \" ");

        int i, j;

        i = str.indexOf(' ');
        System.out.println("i = " + i);

        String token1;

        token1 = str.substring(0, i);
        System.out.println("token1 = [" + token1 + "]");

        String token2;

        j = str.indexOf(' ', i+1);

        token2 = str.substring(i+1, j);
        System.out.println("token2 = [" + token2 + "]");

        String token3;

        j = str.indexOf(' ', i+1);

        token3 = str.substring(j+1);
        System.out.println("token3 = [" + token3 + "]");
    }
}
