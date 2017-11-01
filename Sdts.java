import java.io.*;

public class Sdts
{
    String[] arr = new String[15];
    String  a;
    int i=100,flag=0;
    int M1[] = new int[5];
    public static void main(String[] args) throws FileNotFoundException, IOException
    {
        int turn =1,k=0,m=0;
        String p = "";
        Sdts sd = new Sdts();
        File f = new File("H:\\sdts.txt");
        FileInputStream fin=new FileInputStream(f);
        DataInputStream din=new DataInputStream(fin);
        BufferedReader br=new BufferedReader(new InputStreamReader(din));
         while(br.read()!=-1)
         {
             sd.a = br.readLine();
             if(sd.a.contains("do{")== true)
             {
                sd.flag=0;
                while(br.read()!=-1)
                {
                   sd.a = br.readLine();
                   if(sd.a.contains("}")== true)
                       break;
                   if(sd.a.contains("do{")== true)
                   {
                       sd.flag=0;
                       continue;
                   } 
                   if(sd.flag==0)
                   {
                       sd.arr[k++] = sd.i+"   "+sd.a;
                       sd.M1[m++] = sd.i++;
                       sd.flag=1;
                   }
                   else
                   {
                        sd.arr[k++] = sd.i+"   "+sd.a;
                        sd.i++;
                   }
                }
             }
             if(sd.a.contains("while")== true)
             {
                p="";
                turn=1; 
                char token[] =  sd.a.toCharArray();
                for(int j=0;j<token.length;j++)
                {
                    if(token[j]==')')
                    {
                        sd.arr[k++] =sd.i+"   if "+p+ " goto "+sd.M1[--m];
                        sd.i++;
                        sd.arr[k++] =sd.i+"   goto  "+ ++sd.i;
                        break;
                    }
                       
                    if(token[j]=='('|| turn ==0)
                    {
                        turn=0;
                        if(token[j]!='(')
                           p = p + token[j];
                    }
                }
             }
          }
         System.out.println("code genertaed: -");
          for(int i=0;i<k;i++)
            System.out.println("  "+sd.arr[i]);
    }
}