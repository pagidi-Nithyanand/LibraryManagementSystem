package Users;

import Admin_functions.Return;
import Admin_functions.View;
import Admin_functions.insert;
import Admin_functions.issue;
import Admin_functions.UIComponents.Handler;
import Admin_functions.View_Issued;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import javax.swing.*;
import Admin_functions.UIComponents;
import java.awt.FlowLayout;

public class Admin {
  public void Admin_functions() throws SQLException {
    JFrame Admin = new JFrame("Admin");
    String[] buttonTitles = { "View Books", "Issue Book", "Return Book", "", "", "", "", "Add User", "" };
    UIComponents.Handler[] handlers = new UIComponents.Handler[buttonTitles.length];
    handlers[0] = new UIComponents.Handler() {
      public void execute() {
        View v = new View();
        v.View_books();
      }
    };
    Admin.add(UIComponents.ButtonPanel(buttonTitles, handlers, 4, 2));
    Admin.setLayout(new FlowLayout(FlowLayout.CENTER));
    Admin.setSize(600, 400);
    Admin.setVisible(true);
    JButton add_b = new JButton("Add Book");  //creating instance of JButton for adding books
    add_b.setBounds(150, 60, 120, 25);
    ActionListener a1 = new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        Admin.setVisible(false);
        insert i = new insert();
        i.bookdata();
      }
    };
    add_b.addActionListener(a1);
    JButton view_b = new JButton("View Books"); //creating instance of JButton to view books
    view_b.setBounds(20, 20, 120, 25);
    ActionListener a2 = new ActionListener() {
    public void actionPerformed(ActionEvent e) {
    View v = new View();
    v.View_books();
     }
     };
     view_b.addActionListener(a2);
     JButton issue_b = new JButton("Issue Book");  //creating instance of JButton to issue books
     issue_b.setBounds(450, 20, 120, 25);
     ActionListener a3 = new ActionListener() {
     public void actionPerformed(ActionEvent e) {
     issue i = new issue();
     i.issued();
     }
     };
     issue_b.addActionListener(a3);
     JButton issued_b = new JButton("View Issued Books"); //creating instance of JButton to view the issued books
     issued_b.setBounds(280, 20, 160, 25);
     ActionListener a4 = new ActionListener() {
     public void actionPerformed(ActionEvent e) {
     View_Issued vi = new View_Issued();
     vi.Issued_books();
     }
     };
     issued_b.addActionListener(a4);
     JButton return_b = new JButton("Return Book");  //creating instance of JButton to return books
     return_b.setBounds(280, 60, 160, 25);
     ActionListener a5 = new ActionListener() {
     public void actionPerformed(ActionEvent e) {
     Return r = new Return();
     r.Returned();
     }
     };
     return_b.addActionListener(a5);
     JButton add_user = new JButton("Add User");  //creating instance of JButton to add users
     add_user.setBounds(20, 60, 120, 25);
     ActionListener a6 = new ActionListener() {
     public void actionPerformed(ActionEvent e) {
     insert users = new insert();
     users.userdata();
     }
     };
     add_user.addActionListener(a6);
     JButton users_b = new JButton("View Readers"); //creating instance of JButton to view users
     users_b.setBounds(150, 20, 120, 25);
     JButton create_b = new JButton("Create/Reset"); //creating instance of JButton to create or reset database
     create_b.setBounds(450, 60, 120, 25);
     ActionListener a8 = new ActionListener() {
     public void actionPerformed(ActionEvent e) {
     JFrame c = new JFrame("Clear/Reset");
     JButton createad = new JButton("Create new Admin");
     ActionListener a81 = new ActionListener() {
     public void actionPerformed(ActionEvent e) {
     int res = JOptionPane.showOptionDialog(new JFrame(), "Do you want to Add new Admin", "Confirm",
     JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null,
     new Object[] { "Yes", "No" }, JOptionPane.YES_OPTION);
     if (res == JOptionPane.YES_OPTION) {
     System.out.println("Selected Yes!");
     insert i = new insert();
     i.admindata();
     } else if (res == JOptionPane.NO_OPTION) {
     System.out.println("Selected No!");
     } else if (res == JOptionPane.CLOSED_OPTION) {
     System.out.println("Window closed without selecting!");
     }
     }
     };
     createad.addActionListener(a81);
     JButton resetuc = new JButton("Clear Login Credentials");
     ActionListener a82 = new ActionListener() {
     public void actionPerformed(ActionEvent e) {
     int res = JOptionPane.showOptionDialog(new JFrame(), "Do you want to clear login credentials", "Confirm",
     JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null,
     new Object[] { "Yes", "No" }, JOptionPane.YES_OPTION);
     if (res == JOptionPane.YES_OPTION) {
     System.out.println("Selected Yes!");
     } else if (res == JOptionPane.NO_OPTION) {
     System.out.println("Selected No!");
     } else if (res == JOptionPane.CLOSED_OPTION) {
     System.out.println("Window closed without selecting!");
     }
     }
     };
     resetuc.addActionListener(a82);
     JButton resetbd = new JButton("Clear Book Details");
     ActionListener a83 = new ActionListener() {
     public void actionPerformed(ActionEvent e) {
     int res = JOptionPane.showOptionDialog(new JFrame(), "Do you want to clear book details", "Confirm",
     JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null,
     new Object[] { "Yes", "No" }, JOptionPane.YES_OPTION);
     if (res == JOptionPane.YES_OPTION) {
     System.out.println("Selected Yes!");
     } else if (res == JOptionPane.NO_OPTION) {
     System.out.println("Selected No!");
     } else if (res == JOptionPane.CLOSED_OPTION) {
     System.out.println("Window closed without selecting!");
     }
     }
     };
     resetbd.addActionListener(a83);
     JButton resetibd = new JButton("Clear Issued Book\'s Details");
     ActionListener a84 = new ActionListener() {
     public void actionPerformed(ActionEvent e) {
     int res = JOptionPane.showOptionDialog(new JFrame(),"Do you want to clear Issued book details", "Confirm",
     JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null,
     new Object[] { "Yes", "No" }, JOptionPane.YES_OPTION);
     if (res == JOptionPane.YES_OPTION) {
     System.out.println("Selected Yes!");
     } else if (res == JOptionPane.NO_OPTION) {
     System.out.println("Selected No!");
     } else if (res == JOptionPane.CLOSED_OPTION) {
     System.out.println("Window closed without selecting!");
     }
     }
     };
     resetibd.addActionListener(a84);
     createad.setBounds(50, 50, 300, 27);
     resetuc.setBounds(50, 100, 300, 27);
     resetbd.setBounds(50, 150, 300, 27);
     resetibd.setBounds(50, 200, 300, 27);
     c.add(resetuc);
     c.add(resetbd);
     c.add(resetibd);
     c.add(createad);
     c.setLayout(null);
     c.setVisible(true);
     c.setSize(400, 400);
     c.setLocationRelativeTo(null);
      c.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
     }
     };
     create_b.addActionListener(a8);
     Admin.add(create_b);
     Admin.add(return_b);
     Admin.add(issue_b);
     Admin.add(add_b);
     Admin.add(issued_b);
     Admin.add(users_b);
     Admin.add(view_b);
     Admin.add(add_user);
     Admin.setSize(600, 200); //400 width and 500 height
     Admin.setLayout(null); //using no layout managers
     Admin.setVisible(true); //making the frame visible
     Admin.setLocationRelativeTo(null);
    Admin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }
}
