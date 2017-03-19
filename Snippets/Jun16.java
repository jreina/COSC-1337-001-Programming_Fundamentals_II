import java.util.*;

public class Jun16
{
    public static void main(String argv[])
    {
        String str;

    //1)
        str = "Hello world";
        StringTokenizer stok= new StringTokenizer(str);
        
        System.out.println(str);

        while (stok.hasMoreTokens())
        {
            System.out.println("#tokens = " + stok.countTokens());
            System.out.println("token: [" + stok.nextToken() + "]");
        }
        System.out.println("#tokens = " + stok.countTokens());
        //System.out.println("token: " + stok.nextToken());
        System.out.println("\n\n");

    //2)
        str = "    Hello    world   ";
        stok= new StringTokenizer(str);
        
        System.out.println(str);

        while (stok.hasMoreTokens())
        {
            System.out.println("#tokens = " + stok.countTokens());
            System.out.println("token: [" + stok.nextToken() + "]");
        }
        System.out.println("#tokens = " + stok.countTokens());
        System.out.println("\n\n");

    //3)
        str = "root:x:0:0:root:/root:/bin/bash";
        stok = new StringTokenizer(str, ":");

        System.out.println(str);


        int n = stok.countTokens();
        System.out.println("#tokens = " + n);

        for (int i=0; i<n; i++)
        {
            System.out.println("token [" + stok.nextToken() + "]");
        }

        //System.out.println("username = " + stok.nextToken());
        //System.out.println("password = " + stok.nextToken());
        //System.out.println("userid   = " + stok.nextToken());
        //System.out.println("groupid  = " + stok.nextToken());
        //System.out.println("comment  = " + stok.nextToken());
        //System.out.println("home dir = " + stok.nextToken());
        //System.out.println("shell    = " + stok.nextToken());
        //System.out.println("\n\n");

    //4)
        str = "Hello-world.It is!a nice day,today";
        stok= new StringTokenizer(str,"-.!, ");
        
        System.out.println(str);

        while (stok.hasMoreTokens())
        {
            System.out.println("#tokens = " + stok.countTokens());
            System.out.println("token: [" + stok.nextToken() + "]");
        }
        System.out.println("#tokens = " + stok.countTokens());
    }
}

