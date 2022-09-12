import java.util.*;
import java.io.*;
import java.math.*;

/**
 * Auto-generated code below aims at helping you parse
 * the standard input according to the problem statement.
 **/
class Solution {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int L = in.nextInt();
        int H = in.nextInt();
        if (in.hasNextLine()) {
            in.nextLine();
        }
        String T = in.nextLine().toUpperCase();
        String [][] chars = new String[27][H]; //max.27 Zeichen von (A-Z + ? )
        for (int i = 0; i < H; i++) {
            String ROW = in.nextLine();
            for (int j=0; j<27; j++)
            {
                chars[j][i]= ROW.substring(j*L, (j+1)*L);
            }
        }
        for(int i=0; i<H; i++)
        {
            for (char x : T.toCharArray())
            {
                x -= 65;
                if (x<0 || x>26)
                x = 26;
                System.out.print(chars[x][i]);
            }
            System.out.println();
        }

        // Write an answer using System.out.println()
        // To debug: System.err.println("Debug messages...");

        //System.out.println("answer");
    }
}
