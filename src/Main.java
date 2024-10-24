import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * 데이터베이스 연결을 관리하는 싱글톤 클래스입니다.
 *
 * @author Baek Da Yeon(joa0906@naver.com)
 * @version 2.5
 * @since 1.0
 *
 * @created 2024-10-24
 * @lastModified 2024-10-24
 *
 * @changelog
 * <ul>
 *   <li>2024-10-24: 최초 생성 (Baek Da Yeon)</li>
 *
 * </ul>
 */
public class Main extends JFrame {
    private JTextField textField;
    private StringBuilder input;
    private String operator; // 연산자 변수 추가
    private double firstOperand; // 첫 번째 피연산자 변수 추가

    public Main() {
        this.setTitle("계산기");
        this.setSize(500, 250);
        this.setLayout(new BorderLayout());

        input = new StringBuilder("0");
        textField = new JTextField(input.toString());
        textField.setEditable(false);
        this.add(textField, BorderLayout.NORTH);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(6, 4, 3, 3));

        String[] text = {
                "C", "Backspace", "=", ".",
                "7", "8", "9", "/",
                "4", "5", "6", "*",
                "1", "2", "3", "-",
                "0", "", "", "+"
        };

        for (String label : text) {
            JButton button = new JButton(label);
            button.setBackground(Color.WHITE);
            button.addActionListener(new ButtonClickListener());
            panel.add(button);
        }

        this.add(panel, BorderLayout.CENTER);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private class ButtonClickListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String command = e.getActionCommand();

            if (command.equals("C")) {
                clear();
            }

    /**
     * @created 2024-10-24
     * @lastModified 2024-10-24
     *
     * @changelog
     * <ul>
     *   <li>2024-10-24: 초기화 기능 추가 @see (Baek Da Yeon)</li>
     * </ul>
     */
     else if (command.equals("Backspace")) {
            backspace();
        }
                textField.setText(input.toString());
    }
        }

    /**
     * @created 2024-10-24
     * @lastModified 2024-10-24
     *
     * @changelog
     * <ul>
     *   <li>2024-10-24: 뒤로가기 추가 (Baek Da Yeon)</li>
     * </ul>
     */

    private void clear() {
        input.setLength(0);
        input.append("0");
    }

    private void backspace() {
        if (input.length() > 1) {
            input.deleteCharAt(input.length() - 1); //@see
        } else {
            input.setLength(0);
            input.append("0");
        }
    }

    public static void main(String[] args) {
        new Main();
    }
}