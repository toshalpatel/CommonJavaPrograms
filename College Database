
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.*;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.awt.event.*;
import javax.swing.*;
class Assign {
        JFrame frm; 
        JPanel panel;
        JLabel l1; 
        JLabel l2;
        JLabel l3;
        JTextField t1;
        JTextField t2;
        JTextField t3;        
        JButton btn; 
          Assign()
                  {
                   frm  = new JFrame("College Information");
                   panel = new JPanel();
                   l1 = new JLabel("College Name: ");
                   l2 = new JLabel("College City: ");
                   l3  = new JLabel("Number of departments: ");
                   t1= new JTextField(10);
                   t2= new JTextField(10);
                   t3= new JTextField(10);
                   btn= new JButton("ADD COLLEGE");
                   panel.add(l1);
                   panel.add(t1);
                   panel.add(l2);
                   panel.add(t2);
                   panel.add(l3);
                   panel.add(t3);
                   panel.add(btn);
                   frm.add(panel);
                    MyA m = new MyA();
                    btn.addActionListener(m);
                    frm.setSize(400, 400);
        frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);         
        frm.setVisible(true);
                  }
class MyA implements ActionListener
{
    int cid=100;
    Statement stmt;
              public void actionPerformed(ActionEvent ae) { 
                            try
            {
        Class.forName("org.apache.derby.jdbc.ClientDriver");
      Connection con =  DriverManager.getConnection("jdbc:derby://localhost:1527/CollegeInfo;user=college;password=college");
      stmt = con.createStatement();
      int r=0;
      r=stmt.executeUpdate("insert into COLLEGE values("+(cid++)+",'"+t1.getText()+"','"+t2.getText()+"','"+t3.getText()+"')");
      ResultSet rs = stmt.executeQuery("select * from COLLEGE");
      while(rs.next())
      {
          System.out.println("CID:"+rs.getInt(1));
          System.out.println("CNAME:"+rs.getString(2));
          System.out.println("CITY:"+rs.getString(3));
          System.out.println("NO_OF_DEPT:"+rs.getString(4));
      }
      stmt.close();
      con.close();
      
   }        catch (ClassNotFoundException ex) {
                Logger.getLogger(Assign.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(Assign.class.getName()).log(Level.SEVERE, null, ex);
            }
                
        }
           }
}
class College
{
    public static void main(String[] args)
    {
        Assign r = new Assign();
    }
}

