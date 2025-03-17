import java.awt.*;
import java.awt.event.*;

public class NestedClassExample extends Frame {
   // GUI components and counter variable
   private TextField tfDisplay;
   private Button btnIncrement;
   private Button btnReset;
   private int count = 0;

   // Constructor to set up the GUI and event handling
   public NestedClassExample() {
      setLayout(new FlowLayout());
      add(new Label("Nested Class Counter"));

      tfDisplay = new TextField("0", 10);
      tfDisplay.setEditable(false);
      add(tfDisplay);

      // Create Increment and Reset buttons
      btnIncrement = new Button("Increment");
      add(btnIncrement);
      btnReset = new Button("Reset");
      add(btnReset);

      // Local inner class as ActionListener for the Increment button
      class IncrementListener implements ActionListener {
         @Override
         public void actionPerformed(ActionEvent evt) {
            count++;
            tfDisplay.setText(String.valueOf(count));
         }
      }
      btnIncrement.addActionListener(new IncrementListener());

      // Use a named inner class (member inner class) for the Reset button
      btnReset.addActionListener(new ResetListener());

      setTitle("Nested Class Example");
      setSize(300, 120);
      setVisible(true);
   }

   // Named inner class to reset the counter
   private class ResetListener implements ActionListener {
      @Override
      public void actionPerformed(ActionEvent evt) {
         count = 0;
         tfDisplay.setText("0");
      }
   }

   // The main method to run the application
   public static void main(String[] args) {
      new NestedClassExample();
   }
}
