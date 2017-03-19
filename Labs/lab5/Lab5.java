public class Lab5
{

    public static void main(String argv[])
    {
        if (argv.length != 1)
        {
            System.out.println("usage:  Lab5 \"STRING IN QUOTES\"");
            System.exit(0);
        }

        String str = argv[0];

        int end = 0;
        int start = 0;
        String token;
        
        while(end != str.length())
        {
            // Set end to first instance of ' '
            end = str.indexOf(' ', start);
            if(end == -1) end = str.length();

            token = str.substring(start, end);
            System.out.println("token = [" + token + "]");
            
            start = end + 1;
        }
    }
}