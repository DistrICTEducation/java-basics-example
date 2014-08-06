package ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListCellRenderer;
import system.Item;
import system.Library;

/**
 * The GUI class allows the user to interact with the system.
 *
 * @author Joris Schelfaut
 */
public class GUI extends UserInterface {

    private final JFrame frame;
    private final int WIDTH  = 400;
    private final int HEIGHT = 500;
    private final JMenuBar menuBar;
    private final JScrollPane scrollPane;
    private final JList items;

    /**
     * @param library the library that can be accessed through this view.
     */
    public GUI(Library library) {
        super(library);
        
        // anonymous code block to initialize the JFrame.
        {
            this.frame = new JFrame("Library application");
            this.frame.setBounds(100, 100, WIDTH, HEIGHT);
            this.frame.setLayout(new FlowLayout());
            this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        }
        // add components :
        {
            // Initialize menu bar :
            {
                this.menuBar = new JMenuBar();
                JMenu menu = new JMenu("Options");
                JMenuItem menuItem = new JMenuItem("Exit");
                menuItem.setAction(new ExitApplicationAction());
                menu.add(menuItem);

                this.menuBar.add(menu);
            }
            this.frame.setJMenuBar(this.menuBar);
            // Initialize scroll pane :
            {
                this.items = new JList(new DefaultListModel<Item>());
                this.items.setListData(this.getLibrary().getItems().toArray());
                this.items.setCellRenderer(new ItemCellRenderer());

                this.scrollPane = new JScrollPane(this.items,
                        JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
                        JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
                this.scrollPane.setPreferredSize(new Dimension(WIDTH - 100, HEIGHT - 100));
            }
            this.frame.add(this.scrollPane);
        }
    }

    @Override
    public void show() {
        this.frame.setVisible(true);
    }

    /**
     * Exits the application.
     */
    private class ExitApplicationAction extends AbstractAction {

        public ExitApplicationAction() {
            super("Exit");
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            System.exit(0);
        }
    }

    /**
     * Renders a cell of the list in the JScrollPane.
     */
    private class ItemCellRenderer implements ListCellRenderer {

        private static final String x222222 = "#222222";
        private static final String xCCCCCC = "#cccccc";
        private static final String x000000 = "#000000";
        
        @Override
        public Component getListCellRendererComponent(JList list, Object value,
                int index, boolean isSelected, boolean cellHasFocus) {
            JPanel panel = new JPanel(new BorderLayout());
            JLabel label = new JLabel(value.toString(), JLabel.LEFT);
            label.setFont(new Font("Verdana", Font.PLAIN, 10));
            panel.add(label);

            if (cellHasFocus) {
                panel.setBackground(Color.decode(x222222));
                label.setForeground(Color.decode(xCCCCCC));
            } else if (isSelected) {
                panel.setBackground(Color.decode(x000000));
                label.setForeground(Color.decode(xCCCCCC));
            } else {
                panel.setBackground(Color.decode(xCCCCCC));
                label.setForeground(Color.decode(x222222));
            }
            return panel;
        }
    }
}
