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
        int n = in.nextInt();       //Anzahl Signale
        int m = in.nextInt();       //Anzahl Operationen
        
        Map<String, String> input = new HashMap(); 
        Map<String, String> output = new HashMap(); 
        String[] key = new String[m];
        
        
        for (int i = 0; i < n; i++) {
            String inputName = in.next();
            String inputSignal = in.next();
            System.err.println("inputName = " + inputName);
            System.err.println("inputSignal = " + inputSignal);

            input.put(inputName, inputSignal);
        }
        
        for (int i = 0; i < m; i++) {
            String outputName = in.next();
            String type = in.next();
            String inputName1 = in.next();
            String inputName2 = in.next();
            System.err.println("outputName = " + outputName);
            System.err.println("type = " + type);
            System.err.println("inputName1 = " + inputName1);
            System.err.println("inputName2 = " + inputName2);

        
           key[i] = outputName;
           output.put(outputName, getString(type, input.get(inputName1), input.get(inputName2)));
        }
        
        for (int i = 0; i < m; i++) {

            // Write an answer using System.out.println()
            // To debug: System.err.println("Debug messages...");

            System.out.println(key[i] + " " + output.get(key[i]));
        }
    }

     private static String NAND(String in1, String in2)
    {
        String out = "";
        for (int i=0; i<in1.length(); i++)
        {
            boolean a1 = checkChar(in1.charAt(i));
            boolean a2 = checkChar(in2.charAt(i));        
           
            if (a1 && a2)
            {
                out += "-";
            }
            else
            {
                out += "_";
            }
        }
        return out;
    }

    private static String getString(String op, String in1, String in2)
    {
        String out = "";
        for (int i=0; i<in1.length(); i++)
        {
            boolean a1 = checkChar(in1.charAt(i));
            boolean a2 = checkChar(in2.charAt(i));        
           
            if (logic(op, a1, a2))
            {
                out += "-";
            }
            else
            {
                out += "_";
            }
        }
        return out;
    }
    
    private static boolean logic(String op, boolean a1, boolean a2)
    {
        switch(op)
        {
            case "AND" :    return a1 && a2;
            case "OR" :     return a1 || a2;
            case "XOR" :    return a1 ^ a2;
            case "NAND" :   return !(a1 && a2);
            case "NOR" :    return !(a1 || a2);
            case "NXOR" :    return !(a1 ^ a2);

                default:    
        }
        return false;
    }
    
    private static boolean checkChar(char ch)
    {
        return (ch == '-');
    }
    
}
