import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class Index extends JFrame {
    private JFrame frame; // instance variable of a JFrame
    private JDialog dialog;
    private JLabel changingProperties;

    public Index() {
        super();
        frame = new JFrame(); // instantiation
        frame.setSize(new Dimension(400, 75));
        frame.setTitle("Changing Properties");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridBagLayout());
        GridBagConstraints grid = new GridBagConstraints();
        changingProperties = new JLabel("Changing Properties");

        // build poup menu
        final JPopupMenu popup = new JPopupMenu();
        // New project menu item
        JMenuItem menuItem = new JMenuItem("New Project");
        menuItem.setMnemonic(KeyEvent.VK_P);
        menuItem.getAccessibleContext().setAccessibleDescription(
                "New Project");
        menuItem.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
              //logic
            }
        });
        popup.add(menuItem);
        // New File menu item
        menuItem = new JMenuItem("Properties");
        menuItem.setMnemonic(KeyEvent.VK_F);
        menuItem.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
              FObjectDialog fod = new FObjectDialog();

              fod.setVisible(true);
              Color newBackgroundColor = fod.getBackgroundColor();
              Color newFontColor = fod.getFontColor();
              String newName = fod.getName();
              if(newBackgroundColor != null)
                frame.getContentPane().setBackground(newBackgroundColor);
              if(newFontColor != null)
                changingProperties.setForeground(newFontColor);
              if(newName != null)
                changingProperties.setText(newName);
            }
        });
        popup.add(menuItem);
        // New File menu item
        menuItem = new JMenuItem("New File");
        menuItem.setMnemonic(KeyEvent.VK_F);
        menuItem.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
              //logic
            }
        });
        popup.add(menuItem);

        // add mouse listener
        changingProperties.addMouseListener(new MouseAdapter() {

            @Override
            public void mousePressed(MouseEvent e) {
                showPopup(e);
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                showPopup(e);
            }

            private void showPopup(MouseEvent e) {
                if (e.isPopupTrigger()) {
                    popup.show(e.getComponent(),
                            e.getX(), e.getY());
                }
            }
        });
        frame.add(changingProperties, grid);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 200);
        frame.setVisible(true);


    }

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException
                | UnsupportedLookAndFeelException e1) {
            e1.printStackTrace();
        }

        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new Index();
            }
        });
    }

}
