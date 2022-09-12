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
        String MESSAGE = in.nextLine();
        //String to Binary
        String binary="";
        byte[] b = MESSAGE.getBytes();
        for(int i : b)
        {
            String s = Integer.toBinaryString(i);
            if (s.length()<7)
            {
                s = "0"+s;
            }
            binary += s;
        } 

        //Binary to Unary
        String unary ="";
        
        for (int i=0; i<binary.length(); i++)
        {    char ch = binary.charAt(i);
            if(i>0 && ch==binary.charAt(i-1))
            {
                unary = unary +"0";
            }
            else if (ch =='1')
            {
                unary = unary +" 0 0";
            }
            else //wenn ch=='0'
            {
               unary = unary + " 00 0";        
            }
    
        }    

        // Write an answer using System.out.println()
        // To debug: System.err.println("Debug messages...");
      
             
        //return unary.substring(1,unary.length());

        System.out.println(unary.substring(1,unary.length()));
        
    }

} //class
