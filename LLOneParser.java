import java.util.*;

class Tuple<A, B> {

    public final A a;
    public final B b;

    public Tuple(A a, B b) {
        this.a = a;
        this.b = b;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Tuple<?, ?> tuple = (Tuple<?, ?>) o;
        if (!a.equals(tuple.a)) return false;
        return b.equals(tuple.b);
    }

    @Override
    public int hashCode() {
        int result = a.hashCode();
        result = 31 * result + b.hashCode();
        return result;
    }
}

public class LLOneParser {
    
    static ArrayList<String> production;
    static List<Tuple> FIRST, FOLLOW;
    static Set<Character> nonT, T;
    static int n;
    
    static void calcFirst(char t){
        String tp = null;
        char[] p = null;
        int l=0;
        for(int i=0; i<n; i++){
            String ntp = production.get(i);
            l = ntp.length();
            p = new char[l];
            p = ntp.toCharArray();
            if(p[0] == t)
                tp = ntp;
        }
        
        if(nonT.contains(p[3])) {
            Tuple<Character, Character> t1 = new Tuple<>(t,p[3]);
            FIRST.add(t1);
        }
    }
    
    static void calcFollow(char t) {
        String tp = null;
        char[] p = null;
        int l=0;
        for(int i=0; i<n; i++){
            String ntp = production.get(i);
            l = ntp.length();
            p = new char[l];
            p = ntp.toCharArray();
            if(p[0] == t)
                tp = ntp;
        }
        
        if(nonT.contains(p[3])) {
            Tuple<Character, Character> t1 = new Tuple<>(t,p[3]);
            FIRST.add(t1);
        }
    }
    
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        System.out.print("Enter the number of productions: ");
        n = in.nextInt();
        System.out.println("Enter the productions:");
        
        production = new ArrayList<>();
        for (int i=0; i<n; i++)
            production.add(in.next());
        
        for(int i=0; i<n; i++){
            int l = production.get(i).length();
            char[] p = new char[l];
            p = production.get(i).toCharArray();
            for(int j=0; j<l; j++){
                if (p[j]>=65 && p[j]<=90)
                    T.add(p[j]);
                else if((p[j]<65 || p[j]>90)&&(p[j]!=32))
                    nonT.add(p[j]);
            }
        }
        for(char t: T)
            calcFirst(t);
        for(char t: T)
            calcFollow(t);
    }
}
