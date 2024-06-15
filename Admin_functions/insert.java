package Admin_functions;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import javax.swing.*;

public class insert {
  public void show() {
    JFrame g = new JFrame("Books Entry");
    JLabel l1 = new JLabel("Book Name:");
    l1.setBounds(5, 10, 100, 30);
    JTextField e1 = new JTextField(20);
    e1.setBounds(80, 10, 120, 30);
    JLabel l2 = new JLabel("Author:");
    l2.setBounds(5, 50, 100, 30);
    JTextField e2 = new JTextField(20);
    e2.setBounds(80, 50, 120, 30);
    JLabel l3 = new JLabel("Book Price:");
    l3.setBounds(5, 90, 100, 30);
    JTextField e3 = new JTextField(20);
    e3.setBounds(80, 90, 120, 30);
    JLabel l4 = new JLabel("No of copies:");
    l4.setBounds(5, 130, 100, 30);
    JTextField e4 = new JTextField(20);
    e4.setBounds(80, 130, 120, 30);
    JButton b1 = new JButton("ok");
    b1.setBounds(120, 170, 50, 20);
    ActionListener a1 = new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        try {
          Class.forName("com.mysql.cj.jdbc.Driver");
          Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/books", "root", "MySQL@123");
          System.out.println("Connected to MySQL");
          Statement indata = con.createStatement();
          String BookName = e1.getText();
          String BookAuthor = e2.getText();
          float BookPrice = Float.parseFloat(e3.getText());
          int BookCopies = Integer.parseInt(e4.getText());
          String sql1 = "Insert into NewBooks(BookName,BookAuthor,BookPrice,BookCopies) Values('" + BookName + "','"
              + BookAuthor + "','" + BookPrice
              + "','" + BookCopies + "')";
          indata.executeUpdate(sql1);
        } catch (Exception er) {
          System.out.println(er);
        }
      }
    };
    b1.addActionListener(a1);
    g.add(l1);
    g.add(l2);
    g.add(l3);
    g.add(l4);
    g.add(e1);
    g.add(e2);
    g.add(e3);
    g.add(e4);
    g.add(b1);
    g.setLayout(null);
    g.setVisible(true);
    g.setSize(300, 300);
    g.setLocationRelativeTo(null);
    // g.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }
}
