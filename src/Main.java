import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
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
    public Main() {
        this.setTitle("계산기");
        this.setSize(500, 250);
        this.setLayout(new BorderLayout());

        JTextField textField = new JTextField("0");
        textField.setEditable(false);
        this.add(textField, BorderLayout.NORTH);

        JPanel Panel = new JPanel();
        Panel.setLayout(new GridLayout(6,4,3,3));

        String[] text = {
                "C", "Backspace", "=", ".",
                "7", "8", "9", "/",
                "4", "5", "6", "*",
                "1", "2", "3", "-",
                "0", "", "", "+"
        };

        /**
         *
         * @created 2024-10-24
         * @lastModified 2024-10-24
         *
         * @changelog
         * <ul>
         *   <li>2024-10-24: 최초 생성 (Baek Da Yeon)</li>
         *   <li>2024-10-24: 문자 위치 변경 (Baek Da Yeon)</li>
         *
         * </ul>
         */

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
        Main f = new Main();
    }
}