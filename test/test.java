import javax.swing.JDialog;
import javax.swing.JOptionPane;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;



public class test {

    // Method to check the condition and show error dialog if the condition is met
    public static void checkConditionAndShowError(Alert alert, boolean condition) {
        if (condition) {
            alert.showErrorDialog("An unexpected error occurred.", "Error", 500, 300); // Position at (500, 300)
        }
    }

    // Main method to demonstrate the usage of checkConditionAndShowError
    public static void main(String[] args) {
        boolean condition = true; // Replace with your actual condition
        Alert alert = new Alert(); // Create an instance of Alert

        // Ensure GUI creation and updates are done in the Event Dispatch Thread
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                checkConditionAndShowError(alert, condition);
            }
        });
    }
}

class Alert {

    // Instance method to display an error message dialog at a specific position
    public void showErrorDialog(String message, String title, int x, int y) {
        JOptionPane optionPane = new JOptionPane(message, JOptionPane.ERROR_MESSAGE);
        JDialog dialog = optionPane.createDialog(title);
        
        // Set the position of the dialog
        dialog.setLocation(x, y);
        
        // Add a WindowListener to close the dialog when "OK" or the close button is clicked
        dialog.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                dialog.dispose();
            }
        });

        // Show the dialog and wait for the user to click a button
        dialog.setVisible(true);

        // Handle button clicks
        int result = JOptionPane.showConfirmDialog(
                null, 
                message, 
                title, 
                JOptionPane.DEFAULT_OPTION, 
                JOptionPane.ERROR_MESSAGE
        );

        if (result == JOptionPane.OK_OPTION) {
            dialog.dispose();
        }
    }
}

