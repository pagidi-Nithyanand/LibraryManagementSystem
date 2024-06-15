package Admin_functions;

import java.sql.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import javax.swing.*;
import com.toedter.calendar.JDateChooser;

public class issue {
  public void issued() {
    JFrame g = new JFrame("Issue Books");
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
    JLabel l3 = new JLabel("Return Date");
    l3.setBounds(5, 90, 100, 30);
    long date = System.currentTimeMillis() + 7 * 24 * 3600 * 1000;
    Date d = new Date(date);
    JDateChooser e3 = new JDateChooser(d);
    e3.setBounds(100, 90, 120, 30);
    JButton b1 = new JButton("ok");
    b1.setBounds(120, 130, 50, 20);
    ActionListener a2 = new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        try {
          Class.forName("com.mysql.cj.jdbc.Driver");
          Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/books", "root",
              "MySQL@123");
          System.out.println("Connected to MySQL");
          // Statement indata = con.createStatement();
          int Bookid = Integer.parseInt(e1.getText());
          int Userid = Integer.parseInt(e2.getText());
          String ReturnDate = e3.getDate().toString();
          String sql1 = "Insert into Issued(Bookid,Userid,ReturnDate) select ?,?,? from newbooks where BookCopies>0 and Bookid=?";
          PreparedStatement preparedStmt1 = con.prepareStatement(sql1);
          preparedStmt1.setInt(1, Bookid);
          preparedStmt1.setInt(2, Userid);
          preparedStmt1.setString(3, ReturnDate);
          preparedStmt1.setInt(4, Bookid);
          preparedStmt1.execute();
          String sql2 = "update newbooks set BookCopies = BookCopies- 1 where  BookCopies> 0 and Bookid=?";
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
    g.add(l3);
    g.add(e1);
    g.add(e2);
    g.add(e3);
    g.add(b);
    g.add(b1);
    g.setLayout(null);
    g.setVisible(true);
    g.setSize(360, 200);
    g.setLocationRelativeTo(null);
    // g.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }
}
