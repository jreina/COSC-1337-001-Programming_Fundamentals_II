import java.io.*;
import java.util.*; 

public class Assemble
{
    public static String pad(int n, int w)
    {
        // determine length of 'n'

        // calculate number of leading 0's to pad with

        // create and return string of leading 0's, and 'n'
    }


    static void readSrc(String fname) throws IOException
    {
        //for each line of assembly code:
        {
            // skip any lines of length zero or starting with '#'
            
            // tokenize string.  1st token is operator, 2nd is operand

            // If operand is invalid, display error and abort.

            // If operator is invalid, display error and abort.

            // convert string operator to numeric form.

            // output opcode and operand, each padded to two characters.
                        
        }
    }

    public static void main(String argv[]) throws IOException
    {
        if (argv.length != 1)
        {
            System.out.println("usage:  java Assemble INPUTFILE");
            System.exit(0);
        }

        readSrc(argv[0]);
    }
}
