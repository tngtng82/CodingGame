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
        String LON = in.next();
        String LAT = in.next();
        double lona = 0;
        double lata = 0;
        
        final Pattern space = Pattern.compile(";"); 
        String[] newStr;

        int N = in.nextInt();
        if (in.hasNextLine()) {
            in.nextLine();
            LON = LON.replace(',', '.');
            LAT = LAT.replace(',', '.');
            lona = Double.valueOf(LON);
           //System.err.println(lona);
            lata = Double.valueOf(LAT);
           // System.err.println(lata);
            
        }
        double res = Integer.MAX_VALUE;
        String text="";

        for (int i = 0; i < N; i++) {
            String DEFIB = in.nextLine();
            System.err.println(DEFIB);
            newStr = space.split(DEFIB);
            /*System.err.println(Arrays.toString(newStr));

            System.err.println((newStr[newStr.length-2]));
            System.err.println((newStr[newStr.length-1]));
            */
             
            double lonb = Double.valueOf(newStr[newStr.length-2].replace(',', '.'));
            //System.err.println(lonb);

            double latb = Double.valueOf(newStr[newStr.length-1].replace(',', '.'));
            //System.err.println(latb);

            double x = (lonb - lona)*Math.cos(lata/2 + latb/2);
            double y = latb - lata;

            double d = Math.sqrt(x*x+y*y)*6371;

            //System.err.println("res = "+ res + "/" + "d = " + d);
          
            if(d < res)
            {
                res = d;
                text = newStr[1];
                //System.err.println("d neu = "+d);
                //System.err.println(newStr[1]);
                //System.out.println(newStr[1]);       
            }
            
        }

        // Write an answer using System.out.println()
        // To debug: System.err.println("Debug messages...");

        System.out.println(text);
    }
}
