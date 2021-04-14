import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

public class HomePage implements ActionListener {

    JFrame frame = new JFrame("Welcome");
    JTextField textfield = new JTextField();
    JButton startbutton = new JButton("Start");

    HomePage() {

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 500);
        frame.getContentPane().setBackground(new Color(50, 50, 50));
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setResizable(false);
        frame.add(startbutton);
        frame.add(textfield);

        textfield.setBounds(0, 0, 500, 100);
        textfield.setBackground(new Color(25, 25, 25));
        textfield.setForeground(new Color(25, 255, 0));
        textfield.setFont(new Font("Serif", Font.PLAIN, 30));
        textfield.setBorder(BorderFactory.createBevelBorder(1));
        textfield.setHorizontalAlignment(JTextField.CENTER);
        textfield.setText("QUIZZICLE");
        textfield.setEditable(false);

        startbutton.setBounds(150, 200, 200, 50);
        startbutton.setFocusable(false);
        startbutton.addActionListener((ActionListener) this);
        startbutton.setFont(new Font("Serif", Font.PLAIN, 15));

    }

    @Override
    public void actionPerformed(ActionEvent a) {
        if (a.getSource() == startbutton) {
            frame.dispose();
            LaunchPage launchPage = new LaunchPage();
        }

    }
}
