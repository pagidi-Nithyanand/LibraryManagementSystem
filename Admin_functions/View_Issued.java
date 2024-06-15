package Admin_functions;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.*;

public class View_Issued {
  public void Issued_books() {
    JFrame Issued_books = new JFrame("Issued Books");
    String[] columns = { "BookId", "Name", "Userid", "ReturnDate" };
    DefaultTableModel tableModel = new DefaultTableModel(columns, 0);
    JTable iTable = new JTable(tableModel);
    iTable.setModel(tableModel);
    iTable.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
    iTable.setFillsViewportHeight(true);
    JScrollPane scroll = new JScrollPane(iTable);
    try {
      Class.forName("com.mysql.cj.jdbc.Driver");
      Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/books", "root", "MySQL@123");
      Statement indata = con.createStatement();
      String sql1 = "select Issued.Bookid,newbooks.Bookname,Issued.Userid,Issued.ReturnDate from newbooks,Issued where newbooks.Bookid=Issued.Bookid";
      ResultSet rs = indata.executeQuery(sql1);
      while (rs.next()) {
        int Bookid = rs.getInt(1);
        String name = rs.getNString(2);
        int userid = rs.getInt(3);
        String ReturnDate = rs.getNString(4);
        tableModel.addRow(new Object[] { Bookid, name, userid, ReturnDate });
      }
    } catch (Exception e1) {
      System.out.println(e1);
    }
    Issued_books.add(scroll);
    Issued_books.setVisible(true);
    Issued_books.setSize(600, 400);
    Issued_books.setLocationRelativeTo(null);
  }
}