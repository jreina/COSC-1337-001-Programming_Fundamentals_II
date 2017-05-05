import java.io.*; public class VPCrte {
    static final int MEMSIZ = 100;
    static final int HALT = 0;
    static final int ADD = 1;
    static final int SUB = 2;
    static final int MLT = 3;
    static final int DIV = 4;
    static final int ILOAD = 5;
    static final int LOAD = 6;
    static final int STOR = 7;
    static final int READ = 8;
    static final int WRITE = 9;
    static final int BR = 10;
    static final int BZ = 11;
    static final int BN = 12;
    static final int DUMP = 13;
 
    private static final String[] _operators = { "HALT", "ADD", "SUB", "MLT", "DIV", "ILOAD", "LOAD", "STOR", "READ", "WRITE", "BR", "BZ", "BN", "DUMP" };

    static int MEMORY[] = new int[MEMSIZ];
    static int PCREG;
    static int IRREG;
    static int GPREG;
    
    static boolean debug = false;
    static void readToMemory(String fname) throws IOException
    {
        FileReader fr = new FileReader(fname);
        BufferedReader br = new BufferedReader(fr);
        String buffer = null;
        int memindex = 0;
        while ((buffer = br.readLine()) != null)
        {
            if (debug)
            {   
                System.out.println("readToMemory: [" + memindex + "] = (" + buffer + ")");
            }
            
            // copy machine code instruction into memory
            MEMORY[memindex] = Integer.parseInt(buffer);
            memindex++;
        }
    }
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

    private static String opcodeToString(int opcode)
    {
        return _operators[opcode];
    }
    
    public static void dumpMemory()
    {
        System.out.println("===================================================================");
        int c=0;
        System.out.println("PCREG = " + pad(PCREG, 4));
        System.out.println("IRREG = " + pad(IRREG,4));
        System.out.println("GPREG = " + pad(GPREG, 4) + "\n");
         
        System.out.println("MEMORY: 0 1 2 3 4 5 6 7 8 9");
        System.out.println(" ---------------------------------------------------------------");
        
        for (int i=0; i<MEMSIZ; i++)
        {
            if ((i%10) == 0)
            {
                System.out.print(" " + c + "|");
                c++;
            }
            
            System.out.print(" " + pad(MEMORY[i], 4));
            
            if (((i+1)%10) == 0)
                System.out.println();
        }
        System.out.println();
        System.out.println("===================================================================");
    }
       
    public static void runProg() throws IOException
    {
	// initialize PCREG to zero
        PCREG = 0;
        int opcode;
        int operand;
	BufferedReader input = new BufferedReader
        	(new InputStreamReader(System.in));

        while(true)
        {
            // fetch current instruction from memory and copy to IRREG
            IRREG = MEMORY[PCREG];

            // extract opcode and operand from IRREG
            opcode = IRREG / 100;
            operand = IRREG % 100;
            if (debug)
            {
		// Does Java have a String formatter? :)
                System.out.println("runProg: MEMORY[" +
		    pad(PCREG, 2) + "] = " + pad(MEMORY[PCREG], 4) + ", opcode = " +
		    pad(opcode, 2) + ", operand = " + pad(operand, 2) +
		    ", GPREG = " + pad(GPREG, 4) + " (" + opcodeToString(opcode) 
		    + ")");
            }

            // handle all of the opcodes with a large if/else if/else if/...
            // or switch statement.
            switch(opcode){
                case HALT:
                    return;
                case ADD:
                    GPREG += MEMORY[operand];
                    break;
                case SUB:
                    GPREG -= MEMORY[operand];
                    break;
                case MLT:
                    GPREG *= MEMORY[operand];
                    break;
                case DIV:
                    GPREG /= MEMORY[operand];
                    break;
                case ILOAD:
                    GPREG = operand;
                    break;
                case LOAD:
                    GPREG = MEMORY[operand];
                    break;
                case STOR:
                    MEMORY[operand] = GPREG;
                    break;
                case READ:
		    System.out.print("[" + operand + "]? ");
                    MEMORY[operand] = Integer.parseInt(input.readLine());
                    break;
                case WRITE:
                    System.out.println("[" + operand + "] -> " + MEMORY[operand]);
                    break;
                case BR:
                    PCREG = operand - 1;
                    break;
                case BZ:
                    if(GPREG == 0) PCREG = operand - 1;
                    break;
                case BN:
                    if(GPREG != 0) PCREG = operand - 1;
                    break;
                case DUMP:
                    dumpMemory();
                    break;
                default:
                    System.out.println("ERROR: OPCODE " + opcode + " not currently supported!");
                    System.exit(0);
                    break;
            }
            // increment PCREG to prepare for next instruction
            PCREG++;
        }
    }
    
    public static void main(String argv[]) throws IOException
    {
        if (argv.length == 0)
        {
            System.out.println("usage: java VPCrte FILENAME.exe [ debug ]");
            System.exit(0);
        } 
        
        if ((argv.length == 2) && (argv[1].equals("debug"))) debug = true;
        readToMemory(argv[0]);
        if (debug) dumpMemory();
        
        runProg();
    }
}
