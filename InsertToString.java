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
        String s = in.nextLine();
        int changeCount = in.nextInt();
        if (in.hasNextLine()) {
            in.nextLine();
        }

        String [] ss = s.replace("\\n",":").split(":");
        String [][] textPos = new String [ss.length][ss.length];
        StringBuilder [] sb = new StringBuilder[ss.length];

        for(int i=0; i<ss.length; i++)
        {
            sb[i] = new StringBuilder(ss[i]);
            System.err.println("sb_i : " + sb[i].toString() + " : " + ss[i]);
        }

        for (int i = 0; i < changeCount; i++) {
            String rawChange = in.nextLine();
            // String rawChange = in[i];
            rawChange = rawChange.replace("|", ":");
            String [] rc= rawChange.split(":");
            int line = Integer.parseInt(rc[0]);
            int raw = Integer.parseInt(rc[1]);
            String text = rc[2];
            if (raw >= textPos[line].length)
            {
                int range = raw + 1;
                textPos[line] = Arrays.copyOf(textPos[line], range);
            }

            if (line >= textPos.length)
            {
                int range = line +1;
                textPos = Arrays.copyOf(textPos, range);
            }

            textPos[line][raw] = text;
        }

        for (int i=0; i<textPos.length;i++)
        {
            for (int j=0; j<textPos[i].length; j++)
            {
                if (textPos[i][j] != null)
                {
                    int offset = j;
                    String a = sb[i].toString();
                    String b = textPos[i][j];

                    if(j < sb[i].length())
                    {
                        offset = sb[i].length() - ss[i].length() + j;
                    }
                    sb[i] = sb[i].insert(offset,textPos[i][j]);
                }
            }
            //System.out.println(sb[i].toString());
        }

        for (int i = 0; i<sb.length;i++)
        {
            String result = sb[i].toString();
            String[] res = result.replace("\\n",":").split(":");
            for (int j=0; j<res.length;j++)
            {
                System.out.println(res[j]);
            }
        }
    }
}

