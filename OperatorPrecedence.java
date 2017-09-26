import java.util.ArrayList;
import java.util.Scanner;

public class OperatorPre {

    static ArrayList<String> Grammer;
    static ArrayList<Character> terminals,nonterminals;
    static ArrayList<Character>[] leading,trailing;
    static String nontermre,anyre,termre,onetermre;
   
    public static void main(String[] args) {
        // TODO code application logic here
       
        Grammer = new ArrayList<>();
        terminals = new ArrayList<>();
        nonterminals = new ArrayList<>();
       
       
       
        int n;
        char startterminal;
       
        Scanner in = new Scanner(System.in);
        System.out.print("Enter the number of productions: ");
        n = in.nextInt();
       
        System.out.println("Enter the productions:");
        int p=n,len;
        while(p>0)
        {
            String prod = in.next();
            len = prod.length();
            Grammer.add(prod);
            char[] prodc = prod.toCharArray();
            int i=0;
            while(i<len)
            {
                if(prodc[i]=='>')
                {
                   
                }
                else
                {
                    int asc = (int)prodc[i];
                    if(asc >= 65 && asc <=90)
                    {
                        if(!nonterminals.contains(prodc[i]))
                            nonterminals.add(prodc[i]);
                    }
                    else if(asc == 38)
                    {
                       
                    }
                    else
                    {
                        if(!terminals.contains(prodc[i]))
                            terminals.add(prodc[i]);
                    }
                }
                i++;
            }
            p--;
        }
       
        leading = new ArrayList[nonterminals.size()];
        trailing = new ArrayList[nonterminals.size()];
       
        // productions taken.
        startterminal = nonterminals.get(0);
        System.out.println("\nNonterminals are - " + nonterminals);
        System.out.println("Terminals are - " + terminals);
        System.out.println("Start Terminal is " + startterminal);
       
        // forming the nonterminal terminal regular expression.
        StringBuilder builder = new StringBuilder();
        StringBuilder builder2 = new StringBuilder();
        builder.append('[');
        builder2.append('[');
        for(int i=0;i<nonterminals.size();i++)
        {
            builder.append(nonterminals.get(i));
            builder2.append(nonterminals.get(i));
            leading[i] = new ArrayList<Character>();
            trailing[i] = new ArrayList<Character>();
        }
        for(int i=0;i<terminals.size();i++)
        {
            builder.append(terminals.get(i));
        }
        builder.append("]+");
        builder2.append(']');
        anyre = builder.toString();
        onetermre = builder2.toString() + "?";
        nontermre = builder2.toString();
        
        System.out.println(anyre + " " + onetermre + " " + nontermre);
        int lenl = 4;
        do
        {
        for(int i=0;i<Grammer.size();i++)
        {
            String[] lr = Grammer.get(i).split(">");
            String lhs = lr[0];
            int k = nonterminals.indexOf(lhs.charAt(0));
            //int k = nonterminals.indexOf((Grammer.get(i).split(">"))[0]);
            //System.out.println("" + k);
            String rhs = lr[1];
            //System.out.println(rhs);
            for(int j=0;j<terminals.size();j++)
            {
                if(rhs.matches(onetermre + "[" + terminals.get(j) + "]" + anyre))
                {
                    leading[k].add(terminals.get(j));
                }
                if(rhs.matches(anyre + "[" + terminals.get(j) + "]" + onetermre))
                {
                    trailing[k].add(terminals.get(j));
                }
                if(rhs.matches(onetermre +"[" + terminals.get(j) + "]"))    
                {
                    for(char o : leading[rhs.charAt(0)])
                        leading[k].add(o);
                }
                if(rhs.matches("[" + terminals.get(j) + "]" + onetermre ))    
                {
                    for(char o : trailing[rhs.charAt(0)])
                        trailing[k].add(o);
                }      
            }
           
            if(terminals.contains(rhs))
            {
                Character ck = rhs.charAt(0);
                leading[k].add(ck);
                trailing[k].add(ck);
            }
            if(nonterminals.contains(rhs))
            {
                Character ck = rhs.charAt(0);
                int t = nonterminals.indexOf(ck);
                leading[k].addAll(leading[t]);
                trailing[k].addAll(trailing[t]);
            }
            lenl--;
        }
        }while(lenl > 0);
       
        System.out.println("Leading are - ");
        for(int i=0;i<nonterminals.size();i++)
        {
            for(int j=0;j<leading[i].size();j++)
            {
                System.out.print(leading[i].get(j) + " ");
            }
            System.out.println("");
        }
        System.out.println("Trailing are - ");
        for(int i=0;i<nonterminals.size();i++)
        {
            for(int j=0;j<trailing[i].size();j++)
            {
                System.out.print(trailing[i].get(j) + " ");
            }
            System.out.println("");
        }
    }
   
}
