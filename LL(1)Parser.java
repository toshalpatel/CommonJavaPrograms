
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Stack;

/**
 * S -> (L) | a
 * L -> SX
 * X -> ,SX | ~
 */

public class LL1Parser {
    static ArrayList<Production> grammar = new ArrayList<>();
    static ArrayList<String> nonTerminals = new ArrayList<>();
    static ArrayList<Character> terminals = new ArrayList<>();
    static HashMap<String, ArrayList<Character>> first = new HashMap<>();
    static HashMap<String, ArrayList<Character>> follow = new HashMap<>();
    static String[][] table;
    static int n, t, nt;
    
    private static void init() {
        HashSet<String> nter = new HashSet<>();
        HashSet<Character> ter = new HashSet<>();
        
        Production prod[] = new Production[]{new Production("S", "(L)"), 
            new Production("S", "a"), new Production("L", "SX"), 
            new Production("X", ",SX"), new Production("X", "~")};
        grammar.addAll(Arrays.asList(prod));
        
        n = grammar.size();
        
        //find terminals and non terminals
        for (Production p : grammar) {
            nter.add(p.LHS);
            char[] tp = p.RHS.toCharArray();
            for (int i = 0; i < tp.length; i++) {
                if (!Character.isUpperCase(tp[i])) {
                    ter.add(tp[i]);
                }
            }
        }
        
        nonTerminals.addAll(nter);
        terminals.addAll(ter);
        t = terminals.size();
        nt = nonTerminals.size();
        
        System.out.println("Grammar - ");
        for (Production p : prod) {
            System.out.println("\t" + p.toString());
        }
    }
    
    private static void calcFirst() {
        ArrayList<Character> res, f;
        HashSet<Character> tem;
        
        for (Production p : grammar) {
            f = first.get(p.LHS);
            if (f == null) {
                f = new ArrayList<>();
                first.put(p.LHS, f);
            }
            res = new ArrayList<>();
            findFirst(res, p.LHS, p.RHS);
            tem = new HashSet<>();
            tem.addAll(res);
            f.addAll(tem);
            first.put(p.LHS, f);
            p.first.addAll(tem);
        }
        
        System.out.println("\nFirst Sets - ");
        for (String nt : nonTerminals) {
            System.out.println("\t" + nt + ": " + first.get(nt).toString());
        }
    }
    
    private static void findFirst(ArrayList<Character> res, String LHS, String RHS) {
        boolean fE;
        ArrayList<Character> tem = new ArrayList<>();
        String[] s;
        if (!Character.isUpperCase(RHS.charAt(0))) {
            res.add(RHS.charAt(0));
            return;
        }
        
        for (Production p : grammar) {
            if(p.RHS.equals(RHS) && p.LHS.equals(LHS)) {
                if (RHS.equals("~")) {
                    res.add('~');
                } else {
                    while (Character.isUpperCase(RHS.charAt(0))) {                        
                        fE = false;
                        s = findRHS(Character.toString(p.RHS.charAt(0))).split(" ");
                        for (String item : s) {
                            if (item.equals("null")) {
                                continue;
                            }
                            findFirst(tem, Character.toString(RHS.charAt(0)), item);
                            for (Character c : tem) {
                                res.add(c);
                            }
                            for (Character c : tem) {
                                if (c == '~') {
                                    fE = true;
                                    break;
                                }
                            }
                        }
                        
                        if (!fE) {
                            break;
                        }
                    }
                }
            }
        }
    }

    private static String findRHS(String toString) {
        String s = null;
        for (Production p : grammar) {
            if (p.LHS.equals(toString)) {
                s = s + " " + p.RHS;
            }
        }
        return s;
    }
            
    private static void calcFollow() {
        ArrayList<Character> res, f;
        HashSet<Character> tem;
        
        for (Production p : grammar) {
            f = follow.get(p.LHS);
            if (f == null) {
                f = new ArrayList<>();
                follow.put(p.LHS, f);
            }
            res = new ArrayList<>();
            findFollow(res, p.LHS);
            tem = new HashSet<>();
            tem.addAll(res);
            f.addAll(tem);
            follow.put(p.LHS, f);
            p.follow.addAll(tem);
        }
        
        System.out.println("\nFollow Sets - ");
        for (String nt : nonTerminals) {
            ArrayList<Character> t = follow.get(nt);

            //Code to remove duplicates.
            HashSet<Character> set = new HashSet<>();
            set.addAll(t);
            t.clear();
            t.addAll(set);
            follow.put(nt, t);
            System.out.println("\t" + nt + ": " + t.toString());
        }
    }
    
    private static void findFollow(ArrayList<Character> res, String LHS) {        
        if (grammar.get(0).LHS.equals(LHS)) {
            res.add('$');
        }
        
        for (Production p : grammar) {
            for (int i = 0; i < p.RHS.length(); i++) {
                if (p.RHS.charAt(i) == LHS.charAt(0)) {
                    if((i + 1) < p.RHS.length()) {
                        first(res, p.RHS.charAt(i + 1), p);
                    }
                    if((i + 1) == p.RHS.length() && !LHS.equals(p.LHS)) {
                        findFollow(res, p.LHS);
                    }
                }
            }
        }
    }

    private static void first(ArrayList<Character> res, Character c, Production p) {
        if(!Character.isUpperCase(c)) {
            res.add(c);
        }
        
        for (Production pr : grammar) {
            if (pr.LHS.equals(c.toString())) {
                if (pr.RHS.equals("~")) {
                    findFollow(res, p.LHS);
                } else if (Character.isLowerCase(pr.RHS.charAt(0))) {
                    res.add(pr.RHS.charAt(0));
                } else {
                    first(res, pr.RHS.charAt(0), pr);
                }
            }
        }
    }
    
    private static void createParsingTable() {
        table = new String[nt+1][t+1];
        ArrayList<Character> ter = new ArrayList<>();
        int i, j;
        
        ter.addAll(terminals);
        ter.remove((Character)'~');
        ter.add('$');
        
        for (j = 0; j <= nt; j++) {
            Arrays.fill(table[j], " ");
        }
        
        for (i = 1, j = 1; i <= t; i++) {
            table[0][i] = ter.get(i-1).toString();
            if (j <= nt) {
                table[j][0] = nonTerminals.get(j-1);
                j++;
            }
        }
        
        for (Production p : grammar) {
            i = findIndexOf(p.LHS);
            for (Character c : p.first) {
                if (c != '~') {
                    j = findIndexOf(c);
                    table[i][j] = p.RHS;
                } else {
                    if (c == '~') {
                        if (!p.follow.contains('$')) {
                            for (Character c1 : p.follow) {
                                j = findIndexOf(c1);
                                table[i][j] = p.RHS;
                            }
                        } else {
                            j = findIndexOf('$');
                            table[i][j] = p.RHS;
                        }
                        
                    }
                }
            }
        }
        
        System.out.println("\nParsing table - ");
        for(i = 0; i < (nt + 1); i++) {
            for(j = 0; j < (t + 1); j++) {
                System.out.print(table[i][j] + "\t");
            }
            System.out.println();
        }
    }

    private static int findIndexOf(String s) {
        switch (s) {
            case "S": return 1;
            case "X": return 2;
            case "L": return 3;
        }
        return 0;
    }

    private static int findIndexOf(Character c) {
        switch (c) {
            case 'a': return 1;
            case '(': return 2;
            case ')': return 3;
            case ',': return 4;
            case '$': return 5;
        }
        return 0;   
    }
    
    private static void parseString() {
        String in = "(a)" + "$";
        System.out.println("\nString to be parsed - " + in);
        
        boolean flag = false;
        int i, j, k = 0;
        String sym;
        char[] sy;
        
        Stack<String> s = new Stack<>();
        s.push("$");
        s.push("S");
        
        Character p = in.charAt(k++);
        
        while (true) {  
            if (s.lastElement().equals("$") && p.toString().equals("$")) {
                flag = true;
                break;
            } else {
                i = findIndexOf(s.lastElement());
                j = findIndexOf(p);
                sym = table[i][j];
                if (sym.equals(" ")) {
                    flag = false;
                    break;
                }
                sy = sym.toCharArray();
                
                if(s.lastElement().equals(table[i][0])) {
                    s.pop();
                    for (i = sy.length - 1; i >= 0; i--) {
                        if (sy[i] != '~') {
                            s.push(Character.toString(sy[i]));
                        }
                    }
                }
                if (s.lastElement().equals(p.toString())) {
                    s.pop();
                    p = in.charAt(k++);
                }
            }
        }
        
        if(flag) {
            System.out.println("String Accepted");
        } else {
            System.out.println("String rejected");
        }
        
    }
    
    public static void main(String[] args) {
        init();
        calcFirst();
        calcFollow();
        createParsingTable();
        parseString();
    }
}

class Production {

    String LHS, RHS;
    ArrayList<Character> first;
    ArrayList<Character> follow;
    
    public Production(String LHS, String RHS) {
        this.LHS = LHS;
        this.RHS = RHS;
        first = new ArrayList<>();
        follow = new ArrayList<>();
    }

    @Override
    public String toString() {
        return LHS + " -> " + RHS;
    }
}
