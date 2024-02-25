import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class useDinnerParty {
    public static void main(String[] args) {
        // Create the frame
        JFrame frame = new JFrame("Party Planner");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        frame.getContentPane().setBackground(Color.BLUE);

        // Create a panel
        JPanel panel = new JPanel();
        panel.setBackground(Color.BLUE);
        frame.add(panel);

        // Add components to the panel
        JLabel label = new JLabel("Enter number of guests for the party:");
        label.setForeground(Color.WHITE); // Set text color to white
        panel.add(label);

        JTextField textField = new JTextField(10);
        panel.add(textField);

        JButton button = new JButton("Next");
        panel.add(button);

        // Show the frame
        frame.setVisible(true);

        // Event handling for the button
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Get the number of guests for the party
                int numGuests = Integer.valueOf(textField.getText());


                // Close the frame
                frame.dispose();

                // Show invitation message
                JOptionPane.showMessageDialog(null, "The party has " + numGuests + " guests.\nPlease come to my party!");

                // Create a new frame for dinner party
                JFrame dinnerFrame = new JFrame("Dinner Party Planner");
                dinnerFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                dinnerFrame.setSize(400, 300);
                dinnerFrame.getContentPane().setBackground(Color.BLUE);

                // Create a new panel
                JPanel dinnerPanel = new JPanel();
                dinnerPanel.setBackground(Color.BLUE);
                dinnerFrame.add(dinnerPanel);

                // Add components to the dinner panel
                JLabel dinnerLabel = new JLabel("Enter number of guests for the dinner party:");
                dinnerLabel.setForeground(Color.WHITE); // Set text color to white
                dinnerPanel.add(dinnerLabel);

                JTextField dinnerTextField = new JTextField(10);
                dinnerPanel.add(dinnerTextField);

                JButton dinnerButton = new JButton("Next");
                dinnerPanel.add(dinnerButton);

                // Show the dinner frame
                dinnerFrame.setVisible(true);

                // Event handling for the dinner button
                dinnerButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        // Get the number of guests for dinner party
                        int numDinnerGuests = Integer.valueOf(dinnerTextField.getText());

                        // Get the menu choice
                        String[] options = {"Chicken", "Veggie"};
                        int dinnerChoice = JOptionPane.showOptionDialog(null, "Select the menu option", "Menu Choice", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);

                        // Close the dinner frame
                        dinnerFrame.dispose();

                        // Show special requests dialog
                        JTextArea textArea = new JTextArea(5, 20);
                        JScrollPane scrollPane = new JScrollPane(textArea);
                        JOptionPane.showMessageDialog(null, scrollPane, "Any Special Requests?", JOptionPane.PLAIN_MESSAGE);

                        // Show dinner party details
                        JOptionPane.showMessageDialog(null, "The dinner party has " + numDinnerGuests + " guests.\nMenu option " + (dinnerChoice + 1) + " will be served.\nSpecial requests:\n" + textArea.getText() + "\nPlease come to my party!");
                    }
                });
            }
        });
    }
}
