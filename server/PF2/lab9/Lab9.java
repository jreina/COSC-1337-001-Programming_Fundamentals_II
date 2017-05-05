import java.io.*;

/*
    Disclaimer: I am not very satisfied with my solution.
    It appears to work, but is not particularly elegant.
    I thought I would get a change to refactor, but that
    just didn't happen.
*/
public class Lab9
{
    public static void main(String args[]) throws java.io.IOException
    {
        InputStreamReader reader = new InputStreamReader(System.in);
        final int CHAROFFSET = 48;
        int ten, one, rows, cols;
        String[][] bitmap;

        // Get number of rows...
        ten = reader.read();
        ten = ten - CHAROFFSET;
        one = reader.read();
        one = one - CHAROFFSET;
        reader.read();   // skip over the comma!
        rows = 10*ten + one;

        // Get number of columns...
        ten = reader.read();
        ten = ten - CHAROFFSET;
        one = reader.read();
        one = one - CHAROFFSET;
        reader.read();   // skip over the comma!
        cols = 10*ten + one;

        bitmap = new String[rows][cols];

        System.out.println("Raw data in table format: =======================");

        // Get the rest of the data into our array...
        int row = 0;
        int col = 0;
        for (int i=0; i<rows * cols; i++)
        {
            int c = reader.read();
            c = c - CHAROFFSET;
            System.out.print(c);         
            String bit;
            if(c >= 5) {
                bit = "X";
            }
            else {
                bit = " ";
            }
            
            bitmap[row][col] = bit;
            col++;
            if(col == cols) {
                col = 0;
                row++;
                System.out.println();
            }
        }

        // Unfiltered print
        System.out.println("\nConverted to 'pixels': ==========================");
        for (int i=0; i < rows; i++) {
            for (int j=0; j < cols; j++) {
                System.out.print(bitmap[i][j]);
            }
            System.out.println();
        }

        // Filter out noisy pixels
        // Iterate over all 'interior' pixels
        for (int i=1; i < rows - 1; i++) {
            for (int j=1; j < cols - 1; j++) {
                boolean foundNeighbor = false;
                // Set up a search window
                for(int checkRow = i-1; checkRow < i + 2; checkRow++){
                    for(int checkCol = j-1; checkCol < j + 2; checkCol++){
                        if(checkRow == i && checkCol == j) continue;
                        if(bitmap[checkRow][checkCol] == bitmap[i][j]) foundNeighbor = true;
                    }
                    if(!foundNeighbor) bitmap[i][j] = " ";
                }
            }
        }

        // Filtered print
        System.out.println("Filtered out noise: =============================");
        for (int i=0; i < rows; i++) {
            for (int j=0; j < cols; j++) {
                System.out.print(bitmap[i][j]);
            }
            System.out.println();
        }
    }
}
