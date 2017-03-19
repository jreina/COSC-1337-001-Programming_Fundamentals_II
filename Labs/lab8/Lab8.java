public class Lab8
{
    public static void main(String argv[])
    {
        int ar[][] = new int[3][4];

        int n = 1;

        for (int i=0; i < ar.length; i++) {
            for (int j=0; j< ar[i].length; j++) {
                ar[i][j] = n;
                n++;
            }
        }

        // print out the elements of the array
        // left to right, top to bottom
        for (int i=0; i < ar.length; i++) {
            for (int j=0; j < ar[i].length; j++) {
                System.out.print(ar[i][j] + " ");
            }
        }
        System.out.println();

        // your code goes here!

        // 4 3 2 1 8 7 6 5 12 11 10 9
        for (int row=0; row < ar.length; row++) {
            for (int col=ar[row].length - 1; col > -1; col--) {
                System.out.print(ar[row][col] + " ");
            }
        }
        System.out.println();

        // 9 10 11 12 5 6 7 8 1 2 3 4 
        for (int row=ar.length - 1; row > -1; row--) {
            for (int col=0; col < ar[row].length; col++) {
                System.out.print(ar[row][col] + " ");
            }
        }
        System.out.println();
        
        // 12 11 10 9 8 7 6 5 4 3 2 1 
        for (int row=ar.length - 1; row > -1; row--) {
            for (int col=ar[row].length - 1; col > -1; col--) {
                System.out.print(ar[row][col] + " ");
            }
        }
        System.out.println();
        

        // 1 5 9 2 6 10 3 7 11 4 8 12
        for (int col=0; col < ar[0].length; col++) {
            for (int row=0; row < ar.length; row++) {
                System.out.print(ar[row][col] + " ");
            }
        }
        System.out.println();

        // 9 5 1 10 6 2 11 7 3 12 8 4 
        for (int col=0; col < ar[0].length; col++) {
            for (int row=ar.length - 1; row > -1; row--) {
                System.out.print(ar[row][col] + " ");
            }
        }
        System.out.println();

        // 4 8 12 3 7 11 2 6 10 1 5 9
        for (int col=ar[0].length -1; col > -1; col--) {
            for (int row=0; row < ar.length; row++) {
                System.out.print(ar[row][col] + " ");
            }
        }
        System.out.println();

        // 12 8 4 11 7 3 10 6 2 9 5 1
        for (int col=ar[0].length - 1; col > -1; col--) {
            for (int row=ar.length - 1; row > -1; row--) {
                System.out.print(ar[row][col] + " ");
            }
        }
        System.out.println();
    }
}