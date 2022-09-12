import java.util.*;
import java.io.*;
import java.math.*;
import java.util.regex.Pattern;

/**
 * Auto-generated code below aims at helping you parse
 * the standard input according to the problem statement.
 **/
class OneDspreadsheet{

    private static String[] result;
    public static void main(String args[]) {

        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        
        result = new String[N];
        String[] op = new String[N];
        String[] arg1Ar = new String[N];
        String[] arg2Ar = new String[N];

        //Speicher + Verarbeiten des Inputs
        for (int i = 0; i < N; i++) {
            String operation = in.next();
            String arg1 = in.next();
            String arg2 = in.next();

            //opArg.put(operation, arg1 + " " + arg2);
            op[i] = operation;
            arg1Ar[i] = arg1;// + " " + arg2;
            arg2Ar[i] = arg2;// + " " + arg2;

            String a1 = getArg(arg1);
            String a2 = getArg(arg2);
            if(!a1.contains("$") && !a2.contains("$"))
            {
                oper(operation, a1, a2, i);
            }
        }

        //2. Pruefung
        int cnt = 0;
        while(cnt < N)
        {
            cnt = 0;
            for (int i = 0; i < N; i++) {

                // Write an answer using System.out.println()
                // To debug: System.err.println("Debug messages...");
                if (result[i] == null)
                {
                    String operation = op [i];
                    String a1 = getArg(arg1Ar[i]);
                    String a2 = getArg(arg2Ar[i]);
                    
                    if(!a1.contains("$") && !a2.contains("$"))
                    {
                        oper(operation, a1, a2, i);
                    }         
                }
                else
                {
                    cnt++;
                }
            }
        }

        //Ausgabe
        for (int i= 0; i <N; i++)
        {
             System.out.println(""+result[i]);
        }
    }

    private static void oper(String operant, String a1, String a2, int i)
    {   
        switch(operant)
        {
            case "VALUE":   result[i] = ADD(a1, a2);  break;
            case "ADD":     result[i] = ADD(a1, a2);    break;
            case "SUB":     result[i] = SUB(a1, a2);    break;
            case "MULT":    result[i] = MULT(a1, a2);   break;
            default: 
        }
    }

    private static String getArg(String arg)
    {
        String a = arg;
        
        if(arg.equals("_"))
        {
            return "0";        
        }

        if(arg.contains("$"))
        {
            int index = Integer.parseInt(arg.replace("$",""));
            a = result[index];
            if (a == null)
            {
                a = arg;
            }
        }
        return a; 
    }

    //Add
    private static String ADD(String a, String b)
    {
        int res = Integer.parseInt(a) + Integer.parseInt(b);
        return ""+res;
    }

    //Sub
    private static String SUB(String a, String b)
    {
        int res = Integer.parseInt(a) - Integer.parseInt(b);
        return ""+res;
    }

    //Mul
    private static String MULT(String a, String b)
    {
        int res = Integer.parseInt(a) * Integer.parseInt(b);
        return ""+res;
    }
}