/**
 * @author Jitesh Kumar Jha
 * @email jiteshjha96@gmail.com
 * Last Updated : 03 April 2016
 */

package properties;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * Creates a frame with Properties label and associated popup menu.
 * Properties Menu Item utilizes PropertiesDialog custom dialog box.
 */


public class PropertiesMain extends JFrame {

    // Variable for JFrame.
    private JFrame frame;
    // Variables for components.
    private JDialog dialog;
    private JLabel changingProperties;

    public PropertiesMain() {
        // Instantiation of JFrame.
        frame = new JFrame();
        // Set size for the frame.
        frame.setSize(new Dimension(400, 75));
        // Set title for the frame.
        frame.setTitle("Changing Properties");
        // Set default close operation.
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // GridBagLayout arranges components in a horizontal and vertical manner.
        frame.setLayout(new GridBagLayout());
        // Instantiation of label.
        changingProperties = new JLabel("Changing Properties");

        // Build popup menu.
        final JPopupMenu popup = new JPopupMenu();

        // Create New project menu item.
        JMenuItem menuItem = new JMenuItem("New Project");
        // Invoke on right-click(keystroke: KeyEvent.VK_P).
        menuItem.setMnemonic(KeyEvent.VK_P);
        // Listen to actions on the New Project menu item.
        menuItem.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
              //logic
            }
        });
        //Add New Project menu item to the popup.
        popup.add(menuItem);


        // Create Properties menu item.
        menuItem = new JMenuItem("Properties");
        // Invoke on right-click(keystroke: KeyEvent.VK_P).
        menuItem.setMnemonic(KeyEvent.VK_F);
        // Listen to actions on the Properties menu item.
        menuItem.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
              // Create an object of PropertiesDialog.
              PropertiesDialog pDialog = new PropertiesDialog();
              // Focus on PropertiesDialog.
              pDialog.setVisible(true);
              // Get the Color values after disposal of the dialog box.
              Color newBackgroundColor = pDialog.getBackgroundColor();
              Color newFontColor = pDialog.getFontColor();
              // Get the new name after disposal of the dialog box.
              String newName = pDialog.getName();
              // If cancel button is pressed, no changes occurred on pressing continue button
              // or one or more properties values are unchanged, then don't change the corresponding values.
              if(newBackgroundColor != null)
                frame.getContentPane().setBackground(newBackgroundColor);
              if(newFontColor != null)
                changingProperties.setForeground(newFontColor);
              if(newName != null)
                changingProperties.setText(newName);
            }
        });
        //Add Properties menu item to the popup.
        popup.add(menuItem);


        // Create New File menu item.
        menuItem = new JMenuItem("New File");
        // Invoke on right-click(keystroke: KeyEvent.VK_P).
        menuItem.setMnemonic(KeyEvent.VK_F);
        // Listen to actions on the New File menu item.
        menuItem.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
              //logic
            }
        });
        popup.add(menuItem);

        // Add mouse listener
        changingProperties.addMouseListener(new MouseAdapter() {

            @Override
            public void mousePressed(MouseEvent e) {
                showPopup(e);
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                showPopup(e);
            }
            // If right click is pressed, get the co-ordinates and show the popup at that precise location.
            private void showPopup(MouseEvent e) {
                if (e.isPopupTrigger()) {
                    popup.show(e.getComponent(),
                            e.getX(), e.getY());
                }
            }
        });
        // Default position of label is Centre of the container in GridBagLayout.
        GridBagConstraints grid = new GridBagConstraints();
        frame.add(changingProperties, grid);
        // Set Defualt Close Operation.
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // Set size of the frame.
        frame.setSize(300, 200);
        // Focus on the frame.
        frame.setVisible(true);


    }

    public static void main(String[] args) {
        // Use the system 'look and feel' for the Swing application.
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException
                | UnsupportedLookAndFeelException e1) {
            e1.printStackTrace();
        }
        // Invoke the Swing thread and create an instance of PropertiesMain().
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new PropertiesMain();
            }
        });
    }

}
