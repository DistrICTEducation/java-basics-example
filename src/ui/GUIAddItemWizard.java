package ui;

import java.awt.CardLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import system.DuplicateException;
import system.Item;

/**
 *
 * @author Joris Schelfaut
 */
public class GUIAddItemWizard extends JFrame {
    
    protected final GUI parent;

    GUIAddItemWizard(GUI parent) {
        super("Add item wizard");
        this.parent = parent;
        this.setBounds(250, 150, 400, 400);
        this.setVisible(true);
    }
    
    protected void addItem(Item item) throws NullPointerException, DuplicateException {
        this.parent.getLibrary().addItem(item);
    }

    private JDialog Wizard;
        
    private JPanel cardPanel;
    private CardLayout cardLayout;
            
    private JButton backButton;
    private JButton nextButton;
    private JButton cancelButton;
    
    private int returnCode;
    
}
