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

        // Aufgabe 2: Unterschiedliche Layouts
        // a) Erkundigen Sie sich im Internet über 4 mögliche Layouts, die das Swing-Framework anbietet.
        // 1. FlowLayout: Anordnen der Komponenten in einer Zeile, wenn der Platz nicht ausreicht, wird in die nächste Zeile umgebrochen.
        // 2. BorderLayout: Teilt den Container in fünf Bereiche (Norden, Süden, Osten, Westen, Mitte) und ordnet die Komponenten entsprechend an.
        // 3. GridLayout: Teilt den Container in ein Gitter mit gleich großen Zellen und ordnet die Komponenten in diesen Zellen an.
        // 4. CardLayout: Ermöglicht das Stapeln von Komponenten, wobei jeweils nur eine Komponente sichtbar ist.

        // b) Beschreiben Sie jedes Layout mit 1-2 Sätzen und testen Sie das FlowLayout in Ihrem Programm.
        frame.setLayout(new FlowLayout()); // Testing FlowLayout
        frame.setVisible(true);
    }
}