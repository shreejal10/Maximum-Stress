package unit2;

//menu bar is a tab that contains sequence of item known as menu and menu contains list of other sub items known as menu items
/*
 * step1: create menu bar
 * step2: create menu and menu item
 * add menu item to menu and menu into menu bar
 */

import javax.swing.*;
import java.awt.*;

class Menu extends JFrame {
    JMenuBar mb;
    JMenu m1, m2, m3, m4;

    public void setMenu() {
        mb = new JMenuBar();

        m1 = new JMenu("File");

        // for shortcut key mnemonic is used
        m1.setMnemonic('f');

        // creating menu item for menu m1
        JMenuItem mi1 = new JMenuItem("New", 'n');
        JMenuItem mi2 = new JMenuItem("Open", 'o');
        JMenuItem mi3 = new JMenuItem("Save", 's');

        // adding sub item in save menu item
        m4 = new JMenu("Save as");
        JMenuItem s1 = new JMenuItem("Save as PDF");
        JMenuItem s2 = new JMenuItem("Save as Word");

        // adding sub item into save menu item
        m4.add(s1);
        m4.add(s2);

        // add m4 into menu m1 for branching

        // adding menuitem into menu
        m1.add(mi1);
        m1.add(mi2);
        m1.add(mi3);
        m1.add(m4);

        // adding menu into menu bar
        mb.add(m1);

        // for menu m2-> adding radiobutton menu item
        m2 = new JMenu("Edit");

        // adding radiobutton item
        JRadioButtonMenuItem rb1 = new JRadioButtonMenuItem("Cut");
        JRadioButtonMenuItem rb2 = new JRadioButtonMenuItem("Copy");
        JRadioButtonMenuItem rb3 = new JRadioButtonMenuItem("Paste");

        // adding radiobutton item into menu
        m2.add(rb1);
        m2.add(rb2);
        m2.add(rb3);

        // adding menu into menu bar
        mb.add(m2);

        // for menu m3->adding checkbox menu item
        m3 = new JMenu("View");
        JCheckBoxMenuItem cb1 = new JCheckBoxMenuItem("Zoom in");
        JCheckBoxMenuItem cb2 = new JCheckBoxMenuItem("Zoom out");

        // adding checkbox item into menu
        m3.add(cb1);
        m3.add(cb2);

        // adding menu into menu bar
        mb.add(m3);

        // adding menubar into Jframe
        add(mb);
        setVisible(true);
        setSize(400, 400);
        setLayout(new FlowLayout());
        setDefaultCloseOperation(3);
    }
}

public class MenuBar {
    public static void main(String[] args) {

        Menu m = new Menu();
        m.setMenu();
    }
}
