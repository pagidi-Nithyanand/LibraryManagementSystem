package Admin_functions;

import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.*;

public class View {
  public static String data;

  public void View_books() {
    JFrame View_books = new JFrame("Books Available:");
    String[] columns = { "BookId", "Name", "Author", "Price", "No. of Copies" };
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
    View_books.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
}