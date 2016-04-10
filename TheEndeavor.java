//creating a database for a magazine subscription
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

class TheEndeavor {
	public static void main(String[] args) {
		Subscribe s = new Subscribe();
	}
}

class Subscribe {
	Subscribe() {
		JFrame jfrm = new JFrame("The Endeavor Subscription");
		//jfrm.setLayout(new FlowLayout());
		JLabel jlab= new JLabel("Fill the following info to subscribe:");
		jfrm.setSize(400,500);
		JPanel jp = new JPanel();
		JLabel namel=new JLabel("Enter name:");
		JTextField name = new JTextField(10);
		JLabel lab2 = new JLabel("Enter School:");
		JTextField school = new JTextField(15);
		JLabel lab3 = new JLabel("Enter Class:");
		JTextField classt = new JTextField(5);
		JLabel lab4 = new JLabel("Enter Address:");
		JTextField address = new JTextField(40);
		JLabel lab5 = new JLabel("Enter Contact number:");
		JTextField cno = new JTextField(10);
		JLabel lab6 = new JLabel("Enter email id:");
		JTextField email = new JTextField(20);
		JButton jb1 = new JButton("SUBSCRIBE");
		JLabel jlab1 = new JLabel("Press subscribe!");
		jp.add(jlab);
		jp.add(namel);
		jp.add(name);
		jp.add(lab2);
		jp.add(school);
		jp.add(lab3);
		jp.add(classt);
		jp.add(lab4);
		jp.add(address);
		jp.add(lab5);
		jp.add(cno);
		jp.add(lab6);
		jp.add(email);
		jp.add(jb1);
		jp.add(jlab1);
		jfrm.add(jp);
		jb1.addActionListener(new ActionListener(){
                    public void actionPerformed(ActionEvent ae) {
                        try {
                            Class.forName("org.apache.derby.jdbc.ClientDriver");
                            Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/StudentInfo;user=endeavor;password=endeavor");
                            Statement stmt = con.createStatement();
                            int r = 0;
                            r = stmt.executeUpdate("insert into ENDEAVOR values('"+name.getText()+"','"+school.getText()+"','"+classt.getText()+"','"+address.getText()+"','"+cno.getText()+"','"+email.getText()+"')");
                            stmt.close();
                            con.close();
                        }
                        catch (SQLException ex) {
                            Logger.getLogger(Subscribe.class.getName()).log(Level.SEVERE, null, ex);
                        } catch (ClassNotFoundException ex) {
                            Logger.getLogger(Subscribe.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        jlab1.setText("Thankyou for subscribing!");
                    }
                });
		jfrm.setVisible(true);
		jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
