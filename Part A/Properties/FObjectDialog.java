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

public class FObjectDialog extends JDialog {

    private static String name;
    private JTextField textfield1;
    private Color backgroundColor;
    private Color fontColor;
    private JButton backgroundColorButton;
    private JButton fontColorButton;
    private JButton continueButton;
    private JButton cancelButton;

    //Creates a frame were the players can enter their names
    public FObjectDialog() {

        setModalityType(ModalityType.APPLICATION_MODAL);
        // build the whole dialog
        buildNewObjectDialog();

        continueButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
                name = textfield1.getText();
                if(name.equals("Change Name"))
                  name = null;
                setVisible(false);
                dispose();
              }
        });
        cancelButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {

                backgroundColor = null;
                fontColor = null;
                name = null;
                setVisible(false);
                dispose();
              }
        });
        backgroundColorButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
          setAlwaysOnTop(false);
          backgroundColor = JColorChooser.showDialog(null,"Select a background color", null);
          setAlwaysOnTop(true);
          }
        });
        fontColorButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
          setAlwaysOnTop(false);
          fontColor = JColorChooser.showDialog(null,"Select a font color", null);
          setAlwaysOnTop(true);
          }
        });

        setSize(600,300);
        setResizable(false);
        setAlwaysOnTop(true);
        setLocationRelativeTo(null);
        setTitle("Enter details");
        setLayout(new GridLayout(4,1));

    }



     private void buildNewObjectDialog() {
         //name = null;
         //backgroundColor = null;
         //fontColor = null;
         continueButton = new JButton("Submit");
         cancelButton = new JButton("Cancel");
         textfield1 = new JTextField("Change Name",15);
         backgroundColorButton = new JButton("Add a background color");
         fontColorButton = new JButton("Add a font color");


         this.add(backgroundColorButton);
         this.add(fontColorButton);
         this.add(textfield1);

         this.add(cancelButton);
         this.add(continueButton);
     }

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
