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
        String T = in.nextLine();
        T = T.replaceAll("nl", "1nl");

        
        //Solution a = new Solution();
        //a.solution(T);

        // Write an answer using System.out.println()
        // To debug: System.err.println("Debug messages...");

        List<String> stringList = new ArrayList<>();
        stringList = stringToList(T);
        String result = "";

        for (String t : stringList)
        {
            //int faktor = bestimmeFaktor(e);

            String m = t.substring(0, 2);
            int faktor = 0;
            int startInd = 1;
            //int endInd = T.length();
            if (m.matches("[0-9][0-9]") && 2 < t.length())     // wenn Ziffern 2x vorkommenm
            {
                faktor = Integer.parseInt(m);
                startInd = 2;
            }
            else// (m.matches("[0-9]"))    // wenn Ziffer 1x vorkommt
            {
                m = ""+m.charAt(0);
                faktor = Integer.parseInt(m);
            }

            String ze = t.substring(startInd, t.length());
            
            // Pattern regex = Pattern.compile("[ ]");
            // Matcher matcher = regex.matcher(ze);
            // if (matcher.find())
            // {
                // int endInd = ze.indexOf(" ");
                // ze = T.substring(startInd, endInd+1);
            // }

            for (int j=0; j<faktor; j++)
            {
                result += ze;
            }
        }
        result = result.replaceAll(" ", "");
        result = result.replaceAll("sp", " ");
        result = result.replaceAll("bS", "\\\\");
        result = result.replaceAll("sQ", "'");
        result = result.replaceAll("nl", "\n");

        System.out.println(result);
        //System.out.println("answer");
    }
       
    
    private static List<String> stringToList(String str)
    {
        List<String> strArr = new ArrayList<>();

        for (int i=1; i<str.length(); i++)
        {
            String strae = str.substring(i-1,i+1);
            boolean ae = strae.matches("[0-9][0-9]");

            String ch = ""+str.charAt(i);
            if(ch.matches("[0-9]") && !ae)
            {
                String s = str.substring(0, i-1);
                strArr.add(s);
                str = str.substring(i, str.length());
                i=0;
            }
        }
        strArr.add(str);
        return strArr;
    }
}
