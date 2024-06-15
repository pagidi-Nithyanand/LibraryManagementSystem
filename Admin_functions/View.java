package Admin_functions;

import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.*;

public class View {
  public static String data;

  public void all_books() {
    JFrame View_books = new JFrame("Books Available:");
    String[] columns = { "BookId", "Name", "Author", "Price", "No. of Copies" };
    DefaultTableModel tableModel = new DefaultTableModel(columns, 0);
    JTable vTable = new JTable(tableModel);
    vTable.setModel(tableModel);
    vTable.setAutoCreateRowSorter(true);
    vTable.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
    vTable.setFillsViewportHeight(true);
    JScrollPane scroll = new JScrollPane(vTable);
    try {
      Class.forName("com.mysql.cj.jdbc.Driver");
      Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/books", "root", "MySQL@123");
      Statement indata = con.createStatement();
      String sql1 = "select * from newbooks";
      ResultSet rs = indata.executeQuery(sql1);
      while (rs.next()) {
        int Bookid = rs.getInt(1);
        String name = rs.getNString(2);
        String Aname = rs.getNString(3);
        Float price = rs.getFloat(4);
        int copies = rs.getInt(5);
        tableModel.addRow(new Object[] { Bookid, name, Aname, price, copies });

      }
    } catch (Exception e1) {
      System.out.println(e1);
    }
    View_books.add(scroll);
    View_books.setVisible(true);
    View_books.setSize(600, 400);
    View_books.setLocationRelativeTo(null);
    // View_books.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }
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
  public void Select_books() {
    JFrame View_books = new JFrame("Select Book");
    String[] columns = { "BookId", "Name", "No. of Copies" };
    DefaultTableModel tableModel = new DefaultTableModel(columns, 0);
    JTable vTable = new JTable(tableModel);
    vTable.setModel(tableModel);
    vTable.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
    vTable.setFillsViewportHeight(true);
    JScrollPane scroll = new JScrollPane(vTable);
    try {
      Class.forName("com.mysql.cj.jdbc.Driver");
      Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/books", "root", "MySQL@123");
      Statement indata = con.createStatement();
      String sql1 = "select * from newbooks";
      ResultSet rs = indata.executeQuery(sql1);
      while (rs.next()) {
        int Bookid = rs.getInt(1);
        String name = rs.getNString(2);
        int copies = rs.getInt(5);
        tableModel.addRow(new Object[] { Bookid, name, copies });

      }
      vTable.addMouseListener(new MouseListener() {
        @Override
        public void mouseReleased(MouseEvent e) {
        }

        @Override
        public void mousePressed(MouseEvent e) {
          String selectedCellValue = vTable.getValueAt(vTable.getSelectedRow(), 0).toString();
          data = selectedCellValue;
          // System.out.println(data);
          // JTextField e1=new JTextField();
          // e1.setText(selectedCellValue);
          View_books.dispose();
        }

        @Override
        public void mouseExited(MouseEvent e) {
        }

        @Override
        public void mouseEntered(MouseEvent e) {
        }

        @Override
        public void mouseClicked(MouseEvent e) {
        }
      });
    } catch (Exception e1) {
      System.out.println(e1);
    }
    View_books.add(scroll);
    View_books.setVisible(true);
    View_books.setSize(600, 400);
    View_books.setLocationRelativeTo(null);
  }
public void View_books() {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'View_books'");
}
}