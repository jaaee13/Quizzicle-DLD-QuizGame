import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

public class Quiz1 implements ActionListener {
    String[] questions = {
            "Which are the essential prime implicants of the following Boolean function: f (a,b,c) = a'c + ac'+ b'c ",
            "Find the minimum sum of products form of the logic function: f (A,B,C,D) = ∑m(0,2,8,10,15) + ∑d (3,11,12,14)",
            "In case of XOR/XNOR simplification we have to look for the following ______________",
            "In the sum of products function, f(X,Y,Z) = ∑(2,3,4,5), the  prime implicants are ",
            "Let * be defined as x * y= x' + y. Let z = x * y. Value of z*x is",
            "What is the dual form of the following Boolean expression: AB + A’C + BC = AB + A’C ",
            "The Boolean function Y = AB + CD is to be realized using only 2 input NAND gates. The minimum number of gates required is",
            "Which method is most suitable for minimizing Boolean functions having many variables or if several Boolean functions need simplification?",
            "Which one of the following is true about the binary operator ≠?",
            "Which statement below best describes a Karnaugh map?" };

    String[][] options = { { "a'c and ac'", "a'c and b'c", "a'c only", "ac' and bc'" },
            { "BD’+ A’C", "B’D’+ AC", "BD+ A’C’", "B’D+ AC’" },
            { "Diagonal Adjacencies", "Offset Adjacencies", "Straight Adjacencies",
                    "Both diagonal and offset Adjacencies" },
            { "X'Y, XY'", "X'Y, XY'Z' , XY'Z", "X'YZ' , X'YZ, XY'", "X'YZ' , X'YZ, XY'Z' , XY'Z" },
            { "x' + y", "x", "0", "1" },
            { "A’B’ + AC’ + B’C’ = A’B’ + AC’", "(A’+B’)(A+C’)(B+C) = (A’+B’)(A+C’)", "(A+B)(A’+C)(B+C)=(A+B)(A’+C)",
                    "(A+B)(A’+C)(B+C)=(A’+B’)(A+C’)" },
            { "2", "3", "4", "5" }, { "Karnaugh Map", "Quine-McCluskey Methods", "Both", "None" },
            { "Both commutative and associative", "Commutative but not associative", "Not commutative but associative",
                    "Neither commutative nor associative" },
            { "It is simply a rearranged truth table",
                    "The Karnaugh map eliminates the need for using NAND and NOR gates",
                    "Variable complements can be eliminated by using Karnaugh maps",
                    "A Karnaugh map can be used to replace Boolean rules" } };

    char[] answers = { 'A', 'B', 'D', 'A', 'B', 'C', 'B', 'C', 'A', 'A' };
    char guess;
    char answer;
    int index;
    int correct_guesses = 0;
    int total_questions = questions.length;
    int result;
    int seconds = 10;

    JFrame frame = new JFrame("LEVEL: MEDIUM");
    JTextField textfield = new JTextField();
    JTextArea textarea = new JTextArea();
    JButton buttonA = new JButton();
    JButton buttonB = new JButton();
    JButton buttonC = new JButton();
    JButton buttonD = new JButton();
    JLabel answer_labelA = new JLabel();
    JLabel answer_labelB = new JLabel();
    JLabel answer_labelC = new JLabel();
    JLabel answer_labelD = new JLabel();
    JLabel time_label = new JLabel();
    JLabel seconds_left = new JLabel();
    JTextField number_right = new JTextField();
    JTextField percentage = new JTextField();

    Timer timer = new Timer(1000, new ActionListener() {

        @Override
        public void actionPerformed(ActionEvent e) {
            seconds--;
            seconds_left.setText(String.valueOf(seconds));
            if (seconds <= 0) {
                displayAnswer();
            }
        }
    });

    public Quiz1() {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1300, 700);
        frame.getContentPane().setBackground(new Color(50, 50, 50));
        frame.setLayout(null);
        frame.setResizable(false);

        textfield.setBounds(0, 0, 1300, 50);
        textfield.setBackground(new Color(25, 25, 25));
        textfield.setForeground(new Color(25, 255, 0));
        textfield.setFont(new Font("Serif", Font.PLAIN, 30));
        textfield.setBorder(BorderFactory.createBevelBorder(1));
        textfield.setHorizontalAlignment(JTextField.CENTER);
        textfield.setEditable(false);

        textarea.setBounds(0, 50, 1300, 100);
        textarea.setLineWrap(true);
        textarea.setWrapStyleWord(true);
        textarea.setBackground(new Color(25, 25, 25));
        textarea.setForeground(new Color(25, 255, 0));
        textarea.setFont(new Font("Serif", Font.PLAIN, 25));
        textarea.setBorder(BorderFactory.createBevelBorder(1));
        textarea.setEditable(false);

        buttonA.setBounds(0, 150, 100, 100);
        buttonA.setFont(new Font("Serif", Font.PLAIN, 35));
        buttonA.setFocusable(false);
        buttonA.addActionListener(this);
        buttonA.setText("A");

        buttonB.setBounds(0, 250, 100, 100);
        buttonB.setFont(new Font("Serif", Font.PLAIN, 35));
        buttonB.setFocusable(false);
        buttonB.addActionListener(this);
        buttonB.setText("B");

        buttonC.setBounds(0, 350, 100, 100);
        buttonC.setFont(new Font("Serif", Font.PLAIN, 35));
        buttonC.setFocusable(false);
        buttonC.addActionListener(this);
        buttonC.setText("C");

        buttonD.setBounds(0, 450, 100, 100);
        buttonD.setFont(new Font("Serif", Font.PLAIN, 35));
        buttonD.setFocusable(false);
        buttonD.addActionListener(this);
        buttonD.setText("D");

        answer_labelA.setBounds(150, 150, 1200, 100);
        answer_labelA.setBackground(new Color(50, 50, 50));
        answer_labelA.setForeground(new Color(25, 255, 0));
        answer_labelA.setFont(new Font("Serif", Font.PLAIN, 35));

        answer_labelB.setBounds(150, 250, 1200, 100);
        answer_labelB.setBackground(new Color(50, 50, 50));
        answer_labelB.setForeground(new Color(25, 255, 0));
        answer_labelB.setFont(new Font("Serif", Font.PLAIN, 35));

        answer_labelC.setBounds(150, 350, 1200, 100);
        answer_labelC.setBackground(new Color(50, 50, 50));
        answer_labelC.setForeground(new Color(25, 255, 0));
        answer_labelC.setFont(new Font("Serif", Font.PLAIN, 35));

        answer_labelD.setBounds(150, 450, 1200, 100);
        answer_labelD.setBackground(new Color(50, 50, 50));
        answer_labelD.setForeground(new Color(25, 255, 0));
        answer_labelD.setFont(new Font("Serif", Font.PLAIN, 35));

        seconds_left.setBounds(1185, 560, 100, 100);
        seconds_left.setBackground(new Color(25, 25, 25));
        seconds_left.setForeground(new Color(255, 0, 0));
        seconds_left.setFont(new Font("Serif", Font.PLAIN, 60));
        seconds_left.setBorder(BorderFactory.createBevelBorder(1));
        seconds_left.setOpaque(true);
        seconds_left.setHorizontalAlignment(JTextField.CENTER);
        seconds_left.setText(String.valueOf(seconds));

        time_label.setBounds(1185, 525, 100, 25);
        time_label.setBackground(new Color(50, 50, 50));
        time_label.setForeground(new Color(255, 0, 0));
        time_label.setFont(new Font("Serif", Font.PLAIN, 16));
        time_label.setHorizontalAlignment(JTextField.CENTER);
        time_label.setText("Timer >:D");

        number_right.setBounds(550, 225, 200, 100);
        number_right.setBackground(new Color(25, 25, 25));
        number_right.setForeground(new Color(25, 255, 0));
        number_right.setFont(new Font("Serif", Font.PLAIN, 50));
        number_right.setBorder(BorderFactory.createBevelBorder(1));
        number_right.setHorizontalAlignment(JTextField.CENTER);
        number_right.setEditable(false);

        percentage.setBounds(550, 325, 200, 100);
        percentage.setBackground(new Color(25, 25, 25));
        percentage.setForeground(new Color(25, 255, 0));
        percentage.setFont(new Font("Serif", Font.PLAIN, 50));
        percentage.setBorder(BorderFactory.createBevelBorder(1));
        percentage.setHorizontalAlignment(JTextField.CENTER);
        percentage.setEditable(false);

        frame.add(time_label);
        frame.add(seconds_left);
        frame.add(answer_labelA);
        frame.add(answer_labelB);
        frame.add(answer_labelC);
        frame.add(answer_labelD);
        frame.add(buttonA);
        frame.add(buttonB);
        frame.add(buttonC);
        frame.add(buttonD);
        frame.add(textarea);
        frame.add(textfield);
        frame.setVisible(true);

        nextQuestion();
    }

    public void nextQuestion() {

        if (index >= total_questions) {
            results();
        } else {
            textfield.setText("QUESTION " + (index + 1));
            textarea.setText(questions[index]);
            answer_labelA.setText(options[index][0]);
            answer_labelB.setText(options[index][1]);
            answer_labelC.setText(options[index][2]);
            answer_labelD.setText(options[index][3]);
            timer.start();
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        buttonA.setEnabled(false);
        buttonB.setEnabled(false);
        buttonC.setEnabled(false);
        buttonD.setEnabled(false);

        if (e.getSource() == buttonA) {
            answer = 'A';
            if (answer == answers[index]) {
                correct_guesses++;
            }
        }
        if (e.getSource() == buttonB) {
            answer = 'B';
            if (answer == answers[index]) {
                correct_guesses++;
            }
        }
        if (e.getSource() == buttonC) {
            answer = 'C';
            if (answer == answers[index]) {
                correct_guesses++;
            }
        }
        if (e.getSource() == buttonD) {
            answer = 'D';
            if (answer == answers[index]) {
                correct_guesses++;
            }
        }
        displayAnswer();
    }

    public void displayAnswer() {

        timer.stop();

        buttonA.setEnabled(false);
        buttonB.setEnabled(false);
        buttonC.setEnabled(false);
        buttonD.setEnabled(false);

        if (answers[index] != 'A')
            answer_labelA.setForeground(new Color(255, 0, 0));
        if (answers[index] != 'B')
            answer_labelB.setForeground(new Color(255, 0, 0));
        if (answers[index] != 'C')
            answer_labelC.setForeground(new Color(255, 0, 0));
        if (answers[index] != 'D')
            answer_labelD.setForeground(new Color(255, 0, 0));

        Timer pause = new Timer(1500, new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                answer_labelA.setForeground(new Color(25, 255, 0));
                answer_labelB.setForeground(new Color(25, 255, 0));
                answer_labelC.setForeground(new Color(25, 255, 0));
                answer_labelD.setForeground(new Color(25, 255, 0));

                answer = ' ';
                seconds = 10;
                seconds_left.setText(String.valueOf(seconds));
                buttonA.setEnabled(true);
                buttonB.setEnabled(true);
                buttonC.setEnabled(true);
                buttonD.setEnabled(true);
                index++;
                nextQuestion();
            }
        });
        pause.setRepeats(false);
        pause.start();
    }

    public void results() {

        buttonA.setEnabled(false);
        buttonB.setEnabled(false);
        buttonC.setEnabled(false);
        buttonD.setEnabled(false);

        result = (int) ((correct_guesses / (double) total_questions) * 100);

        textfield.setText("RESULTS!");
        textarea.setText("");
        answer_labelA.setText("");
        answer_labelB.setText("");
        answer_labelC.setText("");
        answer_labelD.setText("");

        number_right.setText("(" + correct_guesses + "/" + total_questions + ")");
        percentage.setText(result + "%");

        frame.add(number_right);
        frame.add(percentage);

    }

}