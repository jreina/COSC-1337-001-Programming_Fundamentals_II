import java.io.*; import java.util.*; public class Assemble {
    // Array of operators. Indexes MUST be preserved.
    // Index corresponds to opcode.
    // New operators MUST be appended to the end of the array.
    // VPCrte WILL abort if new operators are not handled there.
    private static final String[] _operators = { "HALT", "ADD", "SUB", "MLT", "DIV", "ILOAD", "LOAD", "STOR", "READ", "WRITE", "BR", "BZ", "BN", "DUMP" };
    
    public static String pad(int n, int w)
    {
        // determine length of 'n'
        String instruction = "" + n;
        String paddedInstruction = "";

        // calculate number of leading 0's to pad with
        int padCount = w - instruction.length();

        // create and return string of leading 0's, and 'n'
        for(int i = 0; i < padCount; i++)
        {
            paddedInstruction += "0";
        }

        paddedInstruction += instruction;
        return paddedInstruction;
    }
    static void readSrc(String fname) throws IOException
    {
        ST tokenizer;

        int operand, opcode;

        FileReader fr = new FileReader(fname);
        BufferedReader br = new BufferedReader(fr);

        String buffer = null;
	String operator;

        while ((buffer = br.readLine()) != null)
        {
            // skip any lines of length zero or starting with '#'
            if(_isCommentOrEmpty(buffer)) continue;
            
            // tokenize string.  1st token is operator, 2nd is operand
            tokenizer = new ST(buffer);
            operator = tokenizer.nextToken();
            operand = Integer.parseInt(tokenizer.nextToken());
            
            // If operand is invalid, display error and abort.
            if(operand > 99) {
                System.out.println("ERROR: INVALID OPERAND [" + operand + "]");
                System.exit(0);
            }

	    // Get opcode from operator string
            opcode = _operatorIndex(operator);

            // If operator is invalid, display error and abort.
            if(opcode == -1) {
                System.out.println("ERROR: INVALID OPERATOR [" + operator + "]");
                System.exit(0);
            }

            // output opcode and operand, each padded to two characters.
            System.out.println(pad(opcode, 2) + pad(operand, 2));
        }
    }

    // Returns the index of the operator, or -1 if it doesn't exist
    private static int _operatorIndex(String op)
    {
        for(int i = 0; i < _operators.length; i++)
        {
            if(_operators[i].equals(op)) return i;
        }
        return -1;
    }
    
    // Returns a value indicating whether the current line
    // is a comment, or an empty line.
    private static boolean _isCommentOrEmpty(String line)
    {
        if(line.length() == 0) return true;
        if(line.substring(0,1).equals("#")) return true;
        return false;
    }

    public static void main(String argv[]) throws IOException
    {
        if (argv.length != 1)
        {
            System.out.println("usage: java Assemble INPUTFILE");
            System.exit(0);
        }
        readSrc(argv[0]);
    }
}
