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

        JTextField textField = new JTextField(15);
        frame.add(textField);

        JCheckBox checkBox = new JCheckBox("Mich ankreuzen");
        frame.add(checkBox);
        JRadioButton radioButton1 = new JRadioButton("Option 1");
        JRadioButton radioButton2 = new JRadioButton("Option 2");
        ButtonGroup group = new ButtonGroup();
        group.add(radioButton1);
        group.add(radioButton2);
        frame.add(radioButton1);
        frame.add(radioButton2);

        JComboBox<String> comboBox = new JComboBox<>(new String[]{"Item 1", "Item 2", "Item 3"});
        frame.add(comboBox);

        JSlider slider = new JSlider(0, 100, 50);
        frame.add(slider);

        frame.setLayout(new FlowLayout());
        frame.setVisible(true);
    }
}