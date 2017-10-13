import java.util.Scanner;
public class lrParser {
   static String a[][];
   static int state[];
   static String tab[][];
   public static void First()
    {
         for(int i=0;i<a.length;i++)
        {
            for(int j=1;j<a[i].length-2;j++)
            {
                char t[] = a[i][j].toCharArray();
                if(Character.isUpperCase(t[0])==false)
                    a[i][a[i].length-2]=a[i][a[i].length-2]+t[0];
                else
                {
                    for(int s=0;s<a.length;s++)
                    {
                        char s1[] = a[s][0].toCharArray(); 
                           if(s1[0]==t[0] && state[s]==1)
                           a[i][a[i].length-2]=a[i][a[i].length-2]+a[s][a[s].length-2];
                    }
                }
            }
            state[i]=1;
        }
    }
   
   public static void recursion(int i,char []t)
   {
       int m;
       for(int j=0;j<a.length;j++)
           {
               for(int k=1;k<a[j].length-2;k++)
               {
                   if(a[j][k].contains(t[0]+"")==false)
                       break;
                   int s = a[j][k].indexOf(t[0]);
                   if(s+1 != a[j][k].length())
                   {
                      if(Character.isUpperCase(a[j][k].charAt(s+1))==true)
                       {   
                         for( m=0;m<a.length;m++)
                          {
                              if(a[m][0].equals(a[j][k].charAt(s+1)+""))
                                 break;
                          }
                          a[i][a[i].length-1]=a[i][a[i].length-1]+a[m][a[m].length-2];
                       }
                      else
                          a[i][a[i].length-1]=a[i][a[i].length-1]+a[j][k].charAt(s+1);
                    }
                    
                     if(a[i][a[i].length-1].contains("1") || s+1 == a[j][k].length())
                     {   
                         if(a[i][a[i].length-1].contains("1"))
                             a[i][a[i].length-1]=a[i][a[i].length-1].replace("1", "");
                         if(a[j][a[j].length-1].length()>0)
                             a[i][a[i].length-1]=a[i][a[i].length-1]+a[j][a[j].length-1];
                         else
                          {   recursion(j,a[j][0].toCharArray());
                              a[i][a[i].length-1]=a[i][a[i].length-1]+a[j][a[j].length-1];
                          }
  }}}                }
 
   public static void Follow()
   {
       a[0][a[0].length-1]=a[0][a[0].length-1]+"$";
       for(int i=0;i<a.length;i++)
            recursion(i,a[i][0].toCharArray() );   
   }
   
   public static void table()
   {
       for(int i=0;i<a.length;i++)
       {
           for(int j=1;j<a[i].length-2;j++)
           {
               if(Character.isUpperCase(a[i][j].charAt(0))== false)
               { 
                        if(a[i][j].contains("1"))
                         {  
                            char t[] = a[i][a[i].length-1].toCharArray();   //follow
                            for(int s=0;s<t.length;s++)
                            {
                              for(int n=1;n<=5;n++)
                              {
                                 if(tab[0][n].equals(t[s]+""))
                                 {
                                    tab[i+1][n] = tab[i+1][n]+tab[i+1][0]+"->"+a[i][j]; 
                                    break;
                                 }}}}
                    else{
                       for(int k=1;k<=5;k++)
                      {
                       if(tab[0][k].equals(a[i][j].charAt(0)+"") )
                       { 
                        tab[i+1][k] = tab[i+1][k]+tab[i+1][0]+"->"+a[i][j]; 
                         break;
                       }}}}
               else
               {
                   for(int k=0;k<a.length;k++)
                   {
                       if(a[k][0].equals(a[i][j].charAt(0)+"") )
                       {
                           char t[] = a[k][a[k].length-2].toCharArray();
                           for(int p=0;p<t.length;p++)
                           {
                               for(int m=1;m<=5;m++)
                               {
                                  if(tab[0][m].equals(t[p]+"") )
                                  {
                                    tab[i+1][m] = tab[i+1][m]+tab[i+1][0]+"->"+a[i][j];
                                    break;
                                  }}}}}}}}}
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the number of production");
        int n = in.nextInt();
        a = new String[n][];
        state = new int[n];
        tab = new String[4][6];
        tab[0][1]=","; tab[0][2]=")"; tab[0][3]="("; tab[0][4]="x"; tab[0][5]="$";
        tab[1][0]="S"; tab[2][0]="L"; tab[3][0]="A"; tab[0][0]="";
        for(int i=1;i<tab.length;i++)
        {
            for (int j=1;j<tab[i].length;j++)
                tab[i][j]="";
        }
        for( int i=0;i<a.length;i++)
        {
            System.out.print("Enter the numbers of production in P"+i);
            int p = in.nextInt();
            a[i]= new String[p+2];
            for(int j=0;j<p;j++)
                a[i][j] = in.next();
            a[i][p]="";
            a[i][p+1]="";
        }
        First();  
        Follow(); 
        System.out.println("First:- ");
        for(int i=0;i<a.length;i++)
            System.out.println(" First("+a[i][0]+") =  "+a[i][a[i].length-2]);
        System.out.println("FOLLOW:- ");
          for(int i=0;i<a.length;i++)
        { 
            if(a[i][a[i].length-1].contains("("))
                a[i][a[i].length-1] = a[i][a[i].length-1].replaceAll("\\(", "")+"(" ;
            if(a[i][a[i].length-1].contains(")"))
                a[i][a[i].length-1] = a[i][a[i].length-1].replaceAll("\\)", "")+")";
            if(a[i][a[i].length-1].contains("x"))
                a[i][a[i].length-1] = a[i][a[i].length-1].replaceAll("x", "")+"x";
            if(a[i][a[i].length-1].contains(","))
                a[i][a[i].length-1] = a[i][a[i].length-1].replaceAll("\\,", "")+",";
            System.out.println(" Follow("+a[i][0]+") =   "+a[i][a[i].length-1]);
        }
          table();
          System.out.println("Table:- ");
          for(int i=0;i<tab.length;i++)
          {
              for(int j=0;j<tab[i].length;j++)
                  System.out.print("\t"+tab[i][j]+"\t");
              System.out.println(" ");
          }
            
          System.out.println("LL1 Grammar");  
    }
}
