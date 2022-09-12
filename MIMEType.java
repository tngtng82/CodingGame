import java.util.*;
import java.util.regex.Pattern;
import java.io.*;
import java.math.*;

/**
 * Auto-generated code below aims at helping you parse
 * the standard input according to the problem statement.
 **/
class Solution {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt(); // Number of elements which make up the association table.
        int Q = in.nextInt(); // Number Q of file names to be analyzed.
        String[] extList = new String[N];// {};
        String[] mtList = new String[N];// {};;
        
        
        for (int i = 0; i < N; i++) {
            String EXT = in.next().toLowerCase(); // file extension
            extList[i] = EXT;
            String MT = in.next(); // MIME type.
            mtList[i] = MT;
        }
        
        in.nextLine();
       
        for (int i = 0; i < Q; i++) {
            String typ = "";
            String res = "UNKNOWN";
            String FNAME = in.nextLine().toLowerCase(); // One file name per line.
            
            for (int j = 0; j < FNAME.length(); j++)
            {
                if('.' == FNAME.charAt(j))
                {   
                    typ = FNAME.substring(j+1, FNAME.length());       
                }            
            }
            
            for (int k=0; k<N;k++)
            {
                if(extList[k].equals(typ))
                {
                    res = mtList[k];
                }
            }
            System.out.println(res);
        }

        // Write an answer using System.out.println()
        // To debug: System.err.println("Debug messages...");
        // For each of the Q filenames, display on a line the corresponding MIME type. If there is no corresponding type, then display UNKNOWN.
        //System.out.println("UNKNOWN");
    }
}
