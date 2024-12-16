package Lab2;

import javax.swing.*;
import javax.swing.event.*;
import javax.swing.tree.DefaultMutableTreeNode;
import java.awt.*;

class AdvancedMenu extends JFrame {

    JMenuBar mb;
    JMenu m1, m2, m3;

    JSplitPane splitPane;
    JTextArea textArea;
    JTree tree;

    public void setMenu() {
        mb = new JMenuBar();
        m1 = new JMenu("File");
        m2 = new JMenu("Edit");
        m3 = new JMenu("Help");

        JMenuItem mi1 = new JMenuItem("New");
        JMenuItem mi2 = new JMenuItem("Open");
        JMenuItem mi3 = new JMenuItem("Save");
        JMenuItem mi4 = new JMenuItem("Exit");
        JMenuItem mi5 = new JMenuItem("Color Chooser");

        mi1.addActionListener(e -> showDialog("New File"));
        mi2.addActionListener(e -> openFile());
        mi4.addActionListener(e -> System.exit(0));
        mi5.addActionListener(e -> chooseColor());

        m1.add(mi1);
        m1.add(mi2);
        m1.add(mi3);
        m1.addSeparator();
        m1.add(mi4);
        m1.addSeparator();
        m1.add(mi5);

        JRadioButtonMenuItem rb1 = new JRadioButtonMenuItem("Cut");
        JRadioButtonMenuItem rb2 = new JRadioButtonMenuItem("Copy");
        JRadioButtonMenuItem rb3 = new JRadioButtonMenuItem("Paste");

        m2.add(rb1);
        m2.add(rb2);
        m2.add(rb3);

        JCheckBoxMenuItem cb1 = new JCheckBoxMenuItem("Bold");
        JCheckBoxMenuItem cb2 = new JCheckBoxMenuItem("Italic");

        m3.add(cb1);
        m3.add(cb2);

        mb.add(m1);
        mb.add(m2);
        mb.add(m3);

        setJMenuBar(mb);

        createSplitPane();

        setSize(600, 400);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    private void createSplitPane() {
        // Text Area
        textArea = new JTextArea();

        // Tree
        DefaultMutableTreeNode root = new DefaultMutableTreeNode("Root");
        DefaultMutableTreeNode child1 = new DefaultMutableTreeNode("Child 1");
        DefaultMutableTreeNode child2 = new DefaultMutableTreeNode("Child 2");
        root.add(child1);
        root.add(child2);
        tree = new JTree(root);
        tree.addTreeSelectionListener(new TreeSelectionListener() {
            public void valueChanged(TreeSelectionEvent e) {
                textArea.setText("Selected: " + e.getPath());
            }
        });

        // Split Pane
        splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, new JScrollPane(tree), new JScrollPane(textArea));
        splitPane.setDividerLocation(150);

        add(splitPane);
    }

    private void showDialog(String message) {
        JOptionPane.showMessageDialog(this, message);
    }

    private void openFile() {
        JFileChooser fileChooser = new JFileChooser();
        int result = fileChooser.showOpenDialog(this);
        if (result == JFileChooser.APPROVE_OPTION) {
            JOptionPane.showMessageDialog(this, "Selected file: " + fileChooser.getSelectedFile().getAbsolutePath());
        }
    }

    private void chooseColor() {
        Color color = JColorChooser.showDialog(this, "Choose a color", Color.WHITE);
        if (color != null) {
            textArea.setForeground(color);
        }
    }
}

public class MenuBarDemo {
    public static void main(String[] args) {
        System.out.println("Name: Shreejal Dhungana \t Section: A");
        System.out.println("LAB 2 \t Question 5");
        AdvancedMenu m = new AdvancedMenu();
        m.setMenu();
    }
}
