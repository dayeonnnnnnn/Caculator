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
    private String operator;
    private double firstOperand;

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
            } //see

    /**
     * @created 2024-10-24
     * @lastModified 2024-10-24
     *
     * @changelog
     * <ul>
     *   <li>2024-10-24: 초기화 기능 추가 (Baek Da Yeon)</li>
     * </ul>
     */

             else if (command.equals("Backspace")) {
                backspace();
            }

            /**
             *
             * * @created 2024-10-24
             * @lastModified 2024-10-24
             *
             * @changelog
             * <ul>
             *   <li>2024-10-24: 뒤로가기 추가 (Baek Da Yeon)</li>
             * </ul>
             **/

            else if (command.equals("=")) {
                calculate();
            } else if (command.equals("+") || command.equals("-") || command.equals("*") || command.equals("/")) {
                firstOperand = Double.parseDouble(input.toString());
                operator = command;
                input.setLength(0);
            } else {
                input.append(command);
            }
            textField.setText(input.toString());
        } //@see

    /**
     *
     * * @created 2024-10-24
     * @lastModified 2024-10-28
     *
     * @changelog
     * <ul>
     *   <li>2024-10-28: =, + 추가 (Baek Da Yeon)</li>
     *   <li>2024-10-28: 사칙연산 추가 (Baek Da Yeon)</li>
     * </ul>
     **/
            private void calculate() {
                double secondOperand = Double.parseDouble(input.toString());
                double result = 0; //@see

                /**
                 *
                 * * @created 2024-10-24
                 * @lastModified 2024-10-28
                 *
                 * @changelog
                 * <ul>
                 *   <li>2024-10-28: calculate() 메서드 추가 (Baek Da Yeon)</li>
                 *   <li>2024-10-28: result secondOperand 변수 추가,  (Baek Da Yeon)</li>
                 * </ul>
                 **/

            switch (operator) {
                case "+":
                    result = firstOperand + secondOperand;
                    break;
                case "-":
                    result = firstOperand - secondOperand;
                    break;
                case "*":
                    result = firstOperand * secondOperand;
                    break;
                case "/":
                    if (secondOperand != 0) {
                        result = firstOperand / secondOperand;
                    } else {
                        textField.setText("Error"); // 0으로 나누기 오류 처리
                        return;
                    }
                    break;
            } //@see
            /**
             *
             * @created 2024-10-24
             * @lastModified 2024-10-28
             *
             * @changelog
             * <ul>
             *   <li>2024-10-28: 스위치 문 추가(Baek Da Yeon)</li>
             * </ul>
             **/

            input.setLength(0);
            input.append(result);
            operator = null; // 연산자 초기화
            textField.setText(input.toString()); // 결과를 텍스트 필드에 표시
        }
    }

    private void clear() {
        input.setLength(0);
        input.append("0");
        operator = null; // 연산자 초기화
        textField.setText(input.toString()); // 텍스트 필드 업데이트
    }

    private void backspace() {
        if (input.length() > 1) {
            input.deleteCharAt(input.length() - 1);
        } else {
            input.setLength(0);
            input.append("0");
        }
        textField.setText(input.toString()); // 텍스트 필드 업데이트
    }

    public static void main(String[] args) {
        new Main();
    }
}