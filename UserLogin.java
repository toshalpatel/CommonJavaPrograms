import java.util.Scanner;
import java.util.Date;

class UserLogin {
    static int count=0;
    String username, password;
    long logintime;
    static long loggedinsec;
    
    
    UserLogin()
    {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter username");
        username = in.next();
        System.out.println("Enter password");
        password = in.next();
        count++;
        logintime = new Date().getTime();
    }
    
    long loggedinseconds()
    {
    	long d= new Date().getTime();
        return (d-logintime)/1000;
    }
    
    static long loggedinseconds(long log)
    {
        long p;
        Scanner in =new Scanner (System.in);
        System.out.println( "enter ur favourite superhero:");
        String a=in.nextLine();
        System.out.println("enter ur favourite chocolate:");
        String b=in.nextLine();
        long logout = new Date().getTime();
        p = (logout-log)/1000;
        return p;
    }
    
    static void displayCount()
    {
        System.out.println("user count: "+count);
    }
    
    public void display()
    {
        System.out.println("username: "+ username+"\nlogin time: "+ logintime + "\nno. of seconds logged in: "+loggedinsec+" sec");
    }

    public static void main(String[]args)
    {
        User u = new User();
        displayCount();
        loggedinsec = loggedinseconds(new Date().getTime());
        u.display();
        System.out.println("no. of seconds logged in (using static): "+u.loggedinseconds()+" sec"); 
        System.out.println();
        User u2 = new User();
        displayCount();
        loggedinsec = loggedinseconds(new Date().getTime());
        u2.display();
        System.out.println("no. of seconds logged in (using static): "+u.loggedinseconds()+" sec"); 
    }
}
