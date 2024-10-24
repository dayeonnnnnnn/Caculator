package Test;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Test extends JFrame {
    public Test() {
        this.setTitle("계산기");
        this.setSize(500, 250);
        this.setLayout(new BorderLayout());

        JTextField textField = new JTextField("0");
        textField.setEditable(false);
        this.add(textField, BorderLayout.NORTH);

        JPanel Panel = new JPanel();
        Panel.setLayout(new GridLayout(6,4,3,3));

        String[] text = {
                "Backspace", "", "", "CE", "C",
                "7", "8", "9", "/", "sqrt",
                "4", "5", "6", "x", "%",
                "1", "2", "3", "-", "1/x",
                "0", "+/-", ".", "+", "="
        };

        for (int i = 0; i < text.length; i++) {
            JButton button = new JButton(text[i]);
            button.setBackground(Color.WHITE);

            Panel.add(button);
        }

        this.add(Panel, BorderLayout.CENTER);

        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        Test f = new Test();
    }
}