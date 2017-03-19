import java.io.*;

public class Lab4
{
    public static void main(String argv[]) throws IOException
    {
        BigInteger b1,b2,b3;

        b1 = new BigInteger();
        b2 = new BigInteger();

        System.out.println("input the first BigInteger:");
        b1.inputBigInteger();
        System.out.println("input the second BigInteger:");
        b2.inputBigInteger();

        System.out.print("BigInt #1:  "); b1.printBigInteger();
        System.out.print("BigInt #2:  "); b2.printBigInteger();
        System.out.println("            =========================");
        b3 = b1.add(b2);
        System.out.print("SUM:        "); b3.printBigInteger();
        System.out.println();

        System.out.print("BigInt #1:  "); b1.printBigInteger();
        System.out.print("BigInt #2:  "); b2.printBigInteger();
        System.out.println("            =========================");
        b3 = b1.subtract(b2);
        System.out.print("DIFFERENCE: "); b3.printBigInteger();
        System.out.println();

        System.out.print("BigInt #1:  "); b1.printBigInteger();
        System.out.print("BigInt #2:  "); b2.printBigInteger();
        System.out.println("            =========================");
        b3 = b1.multiply(b2);
        System.out.print("PRODUCT:    "); b3.printBigInteger();
        System.out.println();
    }
}


class BigInteger
{
    private final int INTSIZ=25;
    private int intArray[] = new int[INTSIZ];

    // Print the contents of the instance
    public void printBigInteger()
    {
        for (int i=0; i<INTSIZ; i++) {
            System.out.print(intArray[i]);
        }
        System.out.println();
    }
    
    // Add the value of thhe instance to a given instance
    public BigInteger add(BigInteger b)
    {
        BigInteger bisum = new BigInteger();

        int carry = 0;

        int tmp;

        for(int i=INTSIZ-1; i>=0; i--)
        {
            tmp = intArray[i] + b.intArray[i] + carry;

            carry = tmp/10;
            bisum.intArray[i] = tmp%10;
        }

        return bisum;
    }

    // Compare this BigInteger to another BigInteger
    public BigInteger subtract(BigInteger b)
    {
        // Create a temporary local copy of 
        // the current instance. Otherwise it would
        // get mangled up!!
        BigInteger a = _copyOf();
        BigInteger difference = new BigInteger();
        
        for(int i = INTSIZ - 1; i >= 0; i--)
        {
            if(b.intArray[i] > a.intArray[i])
            {
                a.intArray[i-1]--;
                a.intArray[i] += 10;
            }
            difference.intArray[i] = a.intArray[i] - b.intArray[i];
        }
        return difference;
    }
    
    // Multiply this BigInteger by another BigInteger
    public BigInteger multiply(BigInteger b)
    {
        BigInteger biProd = new BigInteger();
        BigInteger biTemp = new BigInteger();
        int offset = 0;
        
        // For each bottom number...
        for(int i = INTSIZ - 1; i > -1; i--)
        {
            // For each top number
            for(int j = INTSIZ - 1; j > -1; j--)
            {
                biTemp.intArray[j] = intArray[j] * b.intArray[i];
                
            }
            biTemp.shift(offset);
            offset++;
            biProd = biProd.add(biTemp);
        }
        return biProd;
    }
    
    // Shift values by the specified number
    // of positions.
    public void shift(int n)
    {
        for (int i=1; i<INTSIZ - n; i++)
        {
            intArray[i] = intArray[i + n];
        }
        for (int i = INTSIZ - n; i < INTSIZ; i++)
        {
            intArray[i] = 0;
        }
    }
    
    // Provides a copy of this instance.
    private BigInteger _copyOf()
    {
        BigInteger biclone = new BigInteger();

        for (int i=0; i<INTSIZ; i++)
        {
            biclone.intArray[i] = intArray[i];
        }

        return biclone;
    }
    
    // don't worry about the implementation of this method.  We haven't
    // covered some of the String methods below, but will ... very soon!
    public void inputBigInteger() throws IOException
    {
        BufferedReader input = new BufferedReader
                              (new InputStreamReader(System.in));

        System.out.print("enter the BigInteger: (do not pad with zeros): ");
        String str = input.readLine();

        if (str.length() > INTSIZ) throw new ArithmeticException("OVERFLOW!");

        for (int i=0; i<str.length(); i++)
        {
            intArray[INTSIZ-str.length()+i] =
                    Integer.parseInt(str.substring(i, i+1));
        }
    }
}