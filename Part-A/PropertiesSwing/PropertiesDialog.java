/**
 * @author Jitesh Kumar Jha
 * @email jiteshjha96@gmail.com
 * Last Updated : 03 April 2016
 */

package properties;

import java.awt.BorderLayout;
import java.awt.Component;

import java.awt.Frame;
import java.awt.GridBagConstraints;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.JColorChooser;

/**
 * Creates a custom dialog box to change properties of a label.
 * Input : Import the class, create an PropertiesDialog, and set visibility to true.
 * Output : Returns name, backgroundColor and fontColor throught get methods if values entered, or null for unchanged values.
 */

public class PropertiesDialog extends JDialog {

    // To store the altered name.
    private static String name;
    // To store the color options.
    private Color backgroundColor;
    private Color fontColor;

    // Various components for the dialog box.
    private JTextField textfield1;
    private JButton backgroundColorButton;
    private JButton fontColorButton;
    private JButton continueButton;
    private JButton cancelButton;

    // Creates a dialog box where properties of a label can be changed.
    public PropertiesDialog() {
        // blocks any access to the parent window while the focus is on dialog box.
        setModalityType(ModalityType.APPLICATION_MODAL);
        // build the whole dialog box.
        buildNewObjectDialog();

        // Listen to actions on the continue button.
        continueButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
                // Get the name entered.
                name = textfield1.getText();
                // If no name has been entered.
                if(name.equals("Change Name"))
                  name = null;
                // Remove focus from the dialog box.
                setVisible(false);
                // Free resources on dialog box.
                dispose();
              }
        });

        // Listen to actions on the cancel button.
        cancelButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
                // Reset all values to null to destroy any property value changes.
                backgroundColor = null;
                fontColor = null;
                name = null;
                // Remove focus from the dialog box.
                setVisible(false);
                // Free resources on dialog box.
                dispose();
              }
        });

        // Listen to actions on the backgroundColor button.
        backgroundColorButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
          // Focus on backgroundColor dialog box.
          setAlwaysOnTop(false);
          // Get background color with a color chooser dialog box.
          backgroundColor = JColorChooser.showDialog(null,"Select a background color", null);
          // Focus on backgroundColor's parent dialog box.
          setAlwaysOnTop(true);
          }
        });

        // Listen to actions on the fontColor button.
        fontColorButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
          // Focus on fontColor dialog box.
          setAlwaysOnTop(false);
          // Get font color with a color chooser dialog box.
          fontColor = JColorChooser.showDialog(null,"Select a font color", null);
          // focus on fontColor's parent dialog box.
          setAlwaysOnTop(true);
          }
        });

        // Dialog box's size.
        setSize(600,300);
        // Dialog box can be resized.
        setResizable(false);
        // Focus on Dialog box.
        setAlwaysOnTop(true);
        // Location of dialog box is independent of it's parent location.
        setLocationRelativeTo(null);
        setTitle("Enter details");
        // Grid layout with ration 4:1.
        setLayout(new GridLayout(4,1));
    }


     // Create the components of the dialog box.
     private void buildNewObjectDialog() {
         // Set the values to point to null to indicate no value.
         name = null;
         backgroundColor = null;
         fontColor = null;

         // Create JTextField object.
         textfield1 = new JTextField("Change Name",15);

         // Create JButton objects.
         continueButton = new JButton("Submit");
         cancelButton = new JButton("Cancel");
         backgroundColorButton = new JButton("Add a background color");
         fontColorButton = new JButton("Add a font color");

         // Add the textfield to the dialogbox.
         this.add(textfield1);

         // Add the buttons to the dialogbox.
         this.add(backgroundColorButton);
         this.add(fontColorButton);
         this.add(cancelButton);
         this.add(continueButton);
     }
     /**
      * Get methods.
      */
     public String getName() {
       return this.name;
     }

     public Color getBackgroundColor() {
       return this.backgroundColor;
     }

     public Color getFontColor() {
       return this.fontColor;
     }
}
