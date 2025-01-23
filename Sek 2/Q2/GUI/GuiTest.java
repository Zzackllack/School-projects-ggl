import java.awt.FlowLayout;
import javax.swing.*;

public class GuiTest {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Test ig");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 200);

        JLabel label = new JLabel("Text-Label");
        frame.add(label);

        JButton button = new JButton("Klick mich");
        frame.add(button);

        frame.setLayout(new FlowLayout());
        frame.setVisible(true);
    }
}