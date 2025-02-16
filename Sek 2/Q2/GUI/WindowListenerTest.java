import java.awt.event.*;
import javax.swing.*;

public class WindowListenerTest extends JFrame implements WindowListener {

    public WindowListenerTest() {
        JFrame frame = new JFrame("Window Listener Test");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        
        frame.addWindowListener(this);

        frame.setVisible(true);
    }

    @Override
    public void windowOpened(WindowEvent e) {
        // Do nothing
    }

    @Override
    public void windowClosing(WindowEvent e) {
        // Action to be performed when the window is closing
        System.exit(0);
    }

    @Override
    public void windowClosed(WindowEvent e) {
        // Do nothing
    }

    @Override
    public void windowIconified(WindowEvent e) {
        // Do nothing
    }

    @Override
    public void windowDeiconified(WindowEvent e) {
        // Do nothing
    }

    @Override
    public void windowActivated(WindowEvent e) {
        // Do nothing
    }

    @Override
    public void windowDeactivated(WindowEvent e) {
        // Do nothing
    }

    public static void main(String[] args) {
        new WindowListenerTest();
    }
}