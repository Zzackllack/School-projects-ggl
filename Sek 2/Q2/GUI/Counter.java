import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Counter implements ActionListener {
    private int count = 0;
    private JLabel label;

    public Counter() {
        JFrame frame = new JFrame("My Counter");
        frame.setLayout(new FlowLayout());
        frame.setSize(200, 100);
        
        label = new JLabel("Counter: 0");
        frame.add(label);

        JButton button = new JButton("Count");
        button.addActionListener(this);
        frame.add(button);

        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent evt) {
        count++;
        label.setText("Counter: " + count);
        System.out.println("Counter: " + count);
    }

    public static void main(String[] args) {
        new Counter();
    }
}