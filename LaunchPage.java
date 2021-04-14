import java.awt.Color;
import java.awt.Font;
import java.awt.event.*;
import javax.swing.*;

public class LaunchPage implements ActionListener {

    JFrame frame = new JFrame("QUIZZICLE");
    JTextArea textarea = new JTextArea();
    JButton button1 = new JButton("EASY LEVEL");
    JButton button2 = new JButton("MEDIUM LEVEL");
    JButton button3 = new JButton("HARD LEVEL");

    LaunchPage() {

        frame.add(button1);
        frame.add(button2);
        frame.add(button3);
        frame.add(textarea);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 500);
        frame.getContentPane().setBackground(new Color(50, 50, 50));
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setResizable(false);

        textarea.setBounds(0, 0, 500, 50);
        textarea.setLineWrap(true);
        textarea.setWrapStyleWord(true);
        textarea.setBackground(new Color(25, 25, 25));
        textarea.setForeground(new Color(25, 255, 0));
        textarea.setFont(new Font("Serif", Font.PLAIN, 25));
        textarea.setBorder(BorderFactory.createBevelBorder(1));
        textarea.setText("Choose your difficulty level:");
        textarea.setEditable(false);

        button1.setBounds(150, 100, 200, 50);
        button1.setFocusable(false);
        button1.addActionListener(this);
        button1.setFont(new Font("Serif", Font.PLAIN, 15));

        button2.setBounds(150, 200, 200, 50);
        button2.setFocusable(false);
        button2.addActionListener(this);
        button2.setFont(new Font("Serif", Font.PLAIN, 15));

        button3.setBounds(150, 300, 200, 50);
        button3.setFocusable(false);
        button3.addActionListener(this);
        button3.setFont(new Font("Serif", Font.PLAIN, 15));

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == button1) {
            frame.dispose();
            Quiz quiz = new Quiz();
        }

        if (e.getSource() == button2) {
            frame.dispose();
            Quiz1 quiz = new Quiz1();
        }

        if (e.getSource() == button3) {
            frame.dispose();
            Quiz2 quiz = new Quiz2();
        }

    }
}