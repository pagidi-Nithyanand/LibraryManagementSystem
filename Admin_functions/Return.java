package Admin_functions;

import java.sql.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Return {
  public void Returned() {
    JFrame g = new JFrame("Return Books");
    JLabel l1 = new JLabel("BooK ID");
    l1.setBounds(5, 10, 100, 30);
    JTextField e1 = new JTextField(20);
    e1.setBounds(100, 10, 120, 30);
    JButton b = new JButton("Select book");
    ActionListener a1 = new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        View v = new View();
        v.Select_books();
        String a = View.data;
        e1.setText(a);
      }
    };
    b.addActionListener(a1);
    b.setBounds(220, 10, 120, 30);
    JLabel l2 = new JLabel("User Id");
    l2.setBounds(5, 50, 100, 30);
    JTextField e2 = new JTextField(20);
    e2.setBounds(100, 50, 120, 30);
    JButton b1 = new JButton("ok");
    b1.setBounds(120, 90, 50, 20);
    ActionListener a2 = new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        try {
          Class.forName("com.mysql.cj.jdbc.Driver");
          Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/books", "root",
              "MySQL@123");
          System.out.println("Connected to MySQL");
          int Bookid = Integer.parseInt(e1.getText());
          int Userid = Integer.parseInt(e2.getText());
          String sql1 = "Delete from Issued where Issued.Bookid=? and Issued.Userid=?";
          PreparedStatement preparedStmt = con.prepareStatement(sql1);
          preparedStmt.setInt(1, Bookid);
          preparedStmt.setInt(2, Userid);
          preparedStmt.execute();
          String sql2 = "update newbooks set BookCopies = BookCopies+1 where Bookid=?";
          PreparedStatement preparedStmt2 = con.prepareStatement(sql2);
          preparedStmt2.setInt(1, Bookid);
          preparedStmt2.execute();
        } catch (Exception er) {
          System.out.println(er);
        }
      }
    };
    b1.addActionListener(a2);
    g.add(l1);
    g.add(l2);
    g.add(e1);
    g.add(e2);
    g.add(b);
    g.add(b1);
    g.setLayout(null);
    g.setVisible(true);
    g.setSize(360, 200);
    g.setLocationRelativeTo(null);
    // g.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }
}
