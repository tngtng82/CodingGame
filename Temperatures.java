import java.util.*;
import java.io.*;
import java.lang.reflect.Array;
import java.math.*;

/**
 * Auto-generated code below aims at helping you parse
 * the standard input according to the problem statement.
 **/
class Solution {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt(); // the number of temperatures to analyse
    
        int result = 0;
        //int z = 0;
        int zalt = 5536;
        for (int i = 0; i < n; i++) {
            int t = in.nextInt(); // a temperature expressed as an integer ranging from -273 to 5526
            if(Math.abs(t) < Math.abs(zalt)){
                result = t;
                zalt = t;
            }
            if(Math.abs(t) == Math.abs(zalt)){
                result = Math.max(t,zalt);
            }
            
        }
     
        // Write an answer using System.out.println()
        // To debug: System.err.println("Debug messages...");

        System.out.println(result);
    }
}
