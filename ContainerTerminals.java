import java.util.*;
import java.io.*;
import java.math.*;

/**
 * Auto-generated code below aims at helping you parse
 * the standard input according to the problem statement.
 **/
class ContainerTerminals {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        if (in.hasNextLine()) {
            in.nextLine();
        }
        System.err.println("N= " + N);
        for (int i = 0; i < N; i++) {
            String line = in.nextLine();
            System.err.println("line = " + line);

            List<Character> stack = new ArrayList<>();

            for (int j=0; j<line.length(); j++)
            {
                char c = line.charAt(j);
                if (j<1)
                {
                    stack.add(j,c);
                }
                else
                {
                    int stackSize = stack.size();
                    int cnt = 0;
                    while(cnt < stackSize)
                    {
                        if(c <= stack.get(cnt))
                        {
                            stack.remove(cnt);
                            stack.add(cnt,c);
                            break;                        
                        }
                        else if(cnt == stack.size()-1)
                        {
                            stack.add(c);       //fuegt das element am ende der liste hinzu
                            break;
                        }
                        cnt++;
                    }
                }
            }
            System.out.println(stack.size());
        }  
    }

    // Write an answer using System.out.println()
    // To debug: System.err.println("Debug messages...");

    //System.out.println("answer");
}

