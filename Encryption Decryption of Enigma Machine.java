import java.util.*;
import java.io.*;
import java.math.*;

/**
 * Auto-generated code below aims at helping you parse
 * the standard input according to the problem statement.
 **/
class Solution
{
    static String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

    /* static String[] rot = {"BDFHJLCPRTXVZNYEIWGAKMUSQO",
    "AJDKSIRUXBLHWTMCQGZNPYFVOE",
    "EKMFLGDQVZNTOWYHXUSPAIBRCJ"};
     */

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        String operation = in.nextLine();
        System.err.println(operation);
        int pseudoRandomNumber = in.nextInt();
        System.err.println(pseudoRandomNumber);

        if (in.hasNextLine()) {
            in.nextLine();
        }

        String[] rot = new String[3];

        for (int i = 0; i < 3; i++){
            String rotor = in.nextLine();
            System.err.println(rotor);
            rot[i] = rotor;
        }

        String message = in.nextLine();
        System.err.println("message: "+ message);
        //String code = "";

        if(operation.equals("ENCODE"))
        {
            message = Code(pseudoRandomNumber, message, operation);
            System.err.println("encode: "+message);
            for(int i=0; i<rot.length; i++)
            {
                message = Rotor(message, rot[i], operation);
                System.err.println("encode: "+message);
            }
        }
        else //wenn DECODE
        {
            for(int i=rot.length-1; i >= 0; i--)
            //for(int i=0; i<rot.length; i++)
            {
                message = Rotor(message, rot[i], operation);
                System.err.println("decode: "+message);
            }
            message = Code(pseudoRandomNumber, message, operation);
            System.err.println("decode: "+message);
        }

        // Write an answer using System.out.println()
        // To debug: System.err.println("Debug messages...");

        System.out.println(message);
    }

    public static String Code(int number, String text, String mode)
    {
        text = text.toUpperCase();
        String output = "";

        for(int i=0; i<text.length();i++)
        {
            String ch = ""+text.charAt(i);
            int ind = alphabet.indexOf(ch);
            char buchstabe ='?';

            if(mode.equals("ENCODE"))
            {
                ind = ind + number + i;
                while(ind >25)
                {
                    ind = ind - 26;
                }
                
                // if(ind > 25)
                // {
                    // ind = ind % 26;
                // }
                buchstabe = alphabet.charAt(ind);
            }
            else //Wenn DECODE
            {
                ind = ind - number - i;
                while(ind < 0)
                {
                    ind = ind + 26;
                }
                buchstabe = alphabet.charAt(ind);
            }

            output += buchstabe;
        }
        return output;
    }

    public static String Rotor(String text, String rotor, String mode)
    {
        String output = "";
        for (int i=0; i<text.length();i++)
        {
            char ch = text.charAt(i);
            char buchstabe ='?';
            if(mode.equals("ENCODE"))
            {
                int ind = alphabet.indexOf(ch);
                buchstabe = rotor.charAt(ind);
            }
            else //Wenn DECODE
            {
                int ind = rotor.indexOf(ch);
                buchstabe = alphabet.charAt(ind);
            }
            output += buchstabe;
        }
        return output;
    }

}