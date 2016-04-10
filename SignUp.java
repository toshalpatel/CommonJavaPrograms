import java.io.*;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

public class SignUp {
    public static void main(String[] args) {
    JFrame frm= new JFrame("Log in");
    JPanel mainpanel= new JPanel(new FlowLayout());
    JPanel panel= new JPanel(new FlowLayout());
    JPanel panel2= new JPanel(new FlowLayout());
    JPanel panel3= new JPanel(new FlowLayout());
    JPanel panel4= new JPanel(new FlowLayout());
    JLabel label1= new JLabel("Name");
    JLabel label2= new JLabel("Username");
    JLabel label3= new JLabel("Password");
    JLabel label4= new JLabel("Mobile No.");
    JTextField t1 = new JTextField(20);
    JTextField t2 = new JTextField(20);
    JTextField t3 = new JTextField(20);
    JTextField t4 = new JTextField(20);
    JButton button= new JButton("Sign Up");
    panel.add(label1);
    panel.add(t1);
    panel2.add(label2);
    panel2.add(t2);
    panel3.add(label3);
    panel3.add(t3);
    panel4.add(label4);
    panel4.add(t4);
    
    mainpanel.add(panel);
    mainpanel.add(panel2);
    mainpanel.add(panel3);
    mainpanel.add(panel4);
    mainpanel.add(button);
    frm.add(mainpanel);
    frm.setSize(350,350);
    frm.setVisible(true);
    frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    button.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e)
        {
            try {
                String name = t1.getText();
                String Username= t2.getText();
                String Password= t3.getText();
                String MN= t4.getText();
                byte b1[]= name.getBytes();
                byte b2[]= Username.getBytes();
                byte b3[]= Password.getBytes();
                byte b4[]= MN.getBytes();
                File f= new File("D:\\File.txt");
                FileOutputStream fout = null;
                    fout = new FileOutputStream(f);
                DataOutputStream d=  new DataOutputStream(fout);
                d.write(b1);
                d.write(b2);
                d.write(b3);
                d.write(b4);
                d.close();
            } catch (IOException ex) {
                Logger.getLogger(SignUp.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        });
    }
}
