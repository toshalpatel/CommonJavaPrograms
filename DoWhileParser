import java.util.Scanner;
/* do a=1 while(i<9)
100: a=1
101: if i < 9 goto 100
102: goto 103
*/

public class DoWhileParser {
    
    static String input;
    static int etrue, efalse, m1, m2, s, s1;
    
    static void backpatch(int m){
        System.out.println(" goto"+m);
    }
    
    static void SDTS(String action, String cond){
        s1 = 100;
        m1 = s1;
        m2 = s1;
        System.out.print(s1+"\t"+action);
        etrue = s1 + 1;
        backpatch(m1);
        backpatch(m2);
        s = efalse;
               
    }
    
    public static String substringBetween(String str, String open, String close) {
        if (str == null || open == null || close == null) {
            return null;
        }
        int start = str.indexOf(open);
        if (start != -1) {
            int end = str.indexOf(close, start + open.length());
            if (end != -1) {
                return str.substring(start + open.length(), end);
            }
        }
        return null;
    }
    
    public static void main(String[] args){
        System.out.println("Enter the program fragment: ");
        Scanner in = new Scanner(System.in);
        input = in.next();
        SDTS(substringBetween(input,"do "," while"), substringBetween(input, "(", ")"));
    }
    
}
