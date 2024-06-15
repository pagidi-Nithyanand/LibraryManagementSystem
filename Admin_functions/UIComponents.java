package Admin_functions;

import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Set;
import javax.swing.*;

public class UIComponents {
    public static class Handler extends Object {
        // For creating handlers for action events in buttons
        public void execute() {
        }
    }

    public static JButton Button(String text, Handler h) {
        JButton button = new JButton(text);
        button.setMargin(new Insets(10, 50, 10, 50));
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                h.execute();
            }
        });
        return button;

    }

    public static JPanel ButtonPanel(String[] buttonTitles, Handler[] h, int rows, int cols) {
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(rows, cols, 30, 30));
        for (int i = 0; i < buttonTitles.length; i++) {
            JButton button = UIComponents.Button(buttonTitles[i], h[i]);

            panel.add(button);
        }
        return panel;
    }

    public static void Table(HashMap<String, String[]> map, String title) {
        JFrame f = new JFrame();
        f.setTitle(title);
        Set<String> a = map.keySet();
        String[] columns = new String[a.size()];
        a.toArray(columns);
        int size = map.get(columns[0]).length;
        String data[][] = new String[size][];
        for (int i = 0; i < size; i++) {
            int length = columns.length;
            String[] temp = new String[length];
            for (int j = 0; j < length; j++) {
                temp[j] = map.get(columns[j])[i];
            }
            data[i] = temp;
        }
        JTable j = new JTable(data, columns);
        j.setBounds(30, 40, 200, 300);
        j.setAutoCreateRowSorter(true);
        ((DefaultRowSorter) j.getRowSorter()).toggleSortOrder(10);
        JScrollPane sp = new JScrollPane(j);
        f.add(sp);
        f.setExtendedState(JFrame.MAXIMIZED_BOTH);
        f.setSize(900, 900);
        f.setVisible(true);
    }

    // TODO:Incomplete
    public static void HorizontalTable(String title) {
        JFrame f = new JFrame();
        f.setTitle(title);
        f.setSize(900, 900);
        f.setVisible(true);
    }

    public static void Popup(JPanel panel, String title) {
        JFrame f = new JFrame();
        JDialog dialog = new JDialog(f, title, true);
        dialog.add(panel);
        dialog.setSize(800, 800);
        dialog.setVisible(true);
    }

    public static void Error(String errTitle, String errMessage) {
        JOptionPane.showMessageDialog(null, errMessage, errTitle, JOptionPane.ERROR_MESSAGE);
    }

    public static void Message(String errTitle, String errMessage) {
        JOptionPane.showMessageDialog(null, errMessage, errTitle, JOptionPane.INFORMATION_MESSAGE);
    }

    public static void Warn(String errTitle, String errMessage) {
        JOptionPane.showMessageDialog(null, errMessage, errTitle, JOptionPane.WARNING_MESSAGE);
    }

    public static String Input(String text, String title) {
        String input = JOptionPane.showInputDialog(null, text, title, JOptionPane.QUESTION_MESSAGE);
        return input;
    }

}