import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

public class Quiz2 implements ActionListener {
    String[] questions = {
            "The simplified SOP (Sum of Product) form of the Boolean expression (P+Q+R).(P+Q+R).(P+Q+R) is ",
            "Consider the following Boolean function of four variables: f(w, x, y, z) = ∑m(1,3,4,6,9,11,12,14). The function is: ",
            "Which are the essential prime implicants for the given function: Y(A, B, C, D) = ∑ m",
            "Find the minimum product of sums of the expression: f=ABC + A'B'C'",
            "Consider the Boolean operator # with the following properties: x # 0 = x, x # 1 = x' , x # x = 0 and x # x' = 1. Then x # y is equivalent to ",
            "In which of the following gates the output is 1 if and only if at least one input is 1?",
            "The Boolean expression Y = (AB)’ is logically equivalent to what single gate? ",
            "If f1 = ∑m (4, 5, 6, 7, 8); f3 = ∑m (1, 6, 15), f = ∑m (1, 6, 8, 15) and (f1.f2)+f3=f then f2 is ",
            "Let, x1 ⊕ x2 ⊕ x3 ⊕ x4 = 0 where x1, x2, x3, x4 are Boolean variables, and ⊕ is the XOR operator. Which one of the following must always be TRUE?",
            "Consider the Boolean operator # with the following properties: x # 0 = x, x # 1 = x' , x # x = 0 and x # x' = 1. Then x # y is equivalent to" };

    String[][] options = { { "(P.Q+R)", "(P+Q.R)", "(P.Q+R) ", "(P.Q+R) " }, { "Independent of one variable",
            "Independent of two variables", "Independent of three variables", "Dependent on all the variables" },
            { "B’C’+B’D+BD", "B’C’+CD", "B’D+ AD’", "AB+CD’" },
            { "f=(A + B’)(A’ + C)(B + C’)", "f=(B' + C)(A' + B)(A + C')", "f=(A + B)(B’ + C)(A + C’)",
                    "f=(B’ + C’)(A’ + B’)(A’ + C’)" },
            { "xy' + x'y", "xy' + x'y'", "x'y + xy", "xy + x'y'" }, { "AND", "NOR", "NAND", "OR" },
            { "NAND", "NOT", "AND", "NOR" }, { "∑ m (4, 6)", "∑m (4, 8)", "∑m (6, 8)", "∑m (4, 6, 8)" },
            { "x1x2x3x4 = 0", "x1.x3 + x2 = 0 ", "x'1 ⊕ x'3 = x'2 ⊕ x'4", "x1 + x2 + x3 + x4 = 0" },
            { "xy' + x'y", "xy' + x'y'", "x'y + xy", "xy + x'y'" } };

    char[] answers = { 'B', 'B', 'B', 'B', 'A', 'D', 'A', 'C', 'C', 'A' };
    char guess;
    char answer;
    int index;
    int correct_guesses = 0;
    int total_questions = questions.length;
    int result;
    int seconds = 10;

    JFrame frame = new JFrame("LEVEL: HARD");
    JTextField textfield1 = new JTextField();
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

    public Quiz2() {
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