package Admin_functions;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import javax.swing.*;

public class clear {
  public static void main(String[] args) {
    Verify();
  }

  public static void Verify() {
    JFrame login = new JFrame("Verify");
    JLabel l1, l2;
    l1 = new JLabel("Username"); // Create label Username
    l1.setBounds(30, 15, 100, 30); // x axis, y axis, width, height

    l2 = new JLabel("Password"); // Create label Password
    l2.setBounds(30, 50, 100, 30);

    JTextField F_user = new JTextField(); // Create text field for username
    F_user.setBounds(110, 15, 200, 30);

    JPasswordField F_pass = new JPasswordField(); // Create text field for password
    F_pass.setBounds(110, 50, 200, 30);
    F_pass.setEchoChar('*');
    JButton login_b = new JButton("Login");// creating instance of JButton for Login Button
    login_b.setBounds(130, 90, 80, 25);
    ActionListener a1 = new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        
        // try {
        // Class.forName("com.mysql.cj.jdbc.Driver");
        // Connection con =
        // DriverManager.getConnection("jdbc:mysql://localhost:3306/books", "root",
        // "MySQL@123");
        // Statement indata = con.createStatement();
        // String sql1 = "select * from Admins";
        // ResultSet rs = indata.executeQuery(sql1);
        // while(rs.next()){
        // if (rs.getNString(1).equalsIgnoreCase(F_user.getText())
        // &&rs.getNString(2).equals(F_pass.getText()) ){
        // //Admin a=new Admin();
        // //a.Admin_functions();
        // }
        // else{
        // //JOptionPane.showInputDialog(login_b,"f","","");
        // }
        // }
        // } catch (SQLException e1) {
        // // TODO Auto-generated catch block
        // e1.printStackTrace();
        // } catch (ClassNotFoundException e12) {
        // // TODO Auto-generated catch block
        // e12.printStackTrace();
        // }
      }
    };
    login_b.addActionListener(a1);
    login.add(F_pass); // add password
    login.add(login_b);// adding button in JFrame
    login.add(F_user); // add user
    login.add(l1); // add label1 i.e. for username
    login.add(l2); // add label2 i.e. for password
    login.setSize(400, 180);// 400 width and 500 height
    login.setLayout(null);// using no layout managers
    login.setVisible(true);// making the frame visible
    login.setLocationRelativeTo(null);
  }
}
