import java.util.Scanner;
/* do a=1 while(i<9)
100: a=1
101: if i < 9 goto 100
102: goto 103
*/

public class SDTSDoWhile {
    
    static String input;
    static int etrue, efalse, m1, m2, s, s1;
    
    static void backpatch(int m){
        System.out.println(" goto "+m);
        s1++;
    }
    
    static void SDTS(String action, String cond){
        s1 = 100;
        m1 = s1;
        
        System.out.println(s1+":\t"+action);
        s1++;
        System.out.print(s1+":\tif "+cond);
        etrue = s1 + 1;
        backpatch(m1);
        System.out.print(s1+":\t");
        m2 = s1;
        backpatch(++m2);
        s = efalse;
    }
    
    int checkLines (String input){
        
        return 0;
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
        /*Scanner in = new Scanner(System.in);
        input = in.next();*/
        input = "do i=0; i=i+1 while ( i<9 )";
        System.out.println(input);
        String action = substringBetween(input,"do","while");
        String condition= substringBetween(input, "(", ")");
        //System.out.println(action+"\n"+condition);
        SDTS(action, condition);
    }
}
