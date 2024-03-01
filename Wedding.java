import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;

public class TestWedding extends JFrame implements ActionListener {

    private JTextField BrideFirstName;
    private JTextField BrideLastName;
    private JTextField GroomFirstName;
    private JTextField GroomLastName;
    private JTextField DateOfMarriage;
    private JTextField location;
    private JTextField cake;
    private JCheckBox kidsCheckBox;
    private JButton ComfirmButton;
    private JTextArea WeddingDetails;

    public TestWedding() {
        setTitle("Wedding Planner");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create main panel with vertical box layout
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        mainPanel.setBackground(new Color(255, 182, 193)); // Light Pink Background

        // Create text fields for bride's and groom's names, wedding date, location, and cake type
        BrideFirstName = createTextField(mainPanel, "Bride's First Name:");
        BrideLastName = createTextField(mainPanel, "Bride's Last Name:");
        GroomFirstName = createTextField(mainPanel, "Groom's First Name:");
        GroomLastName = createTextField(mainPanel, "Groom's Last Name:");
        DateOfMarriage = createTextField(mainPanel, "Wedding Date (YYYY-MM-DD):");
        location = createTextField(mainPanel, "Location:");
        cake = createTextField(mainPanel, "Type of Cake:");

        // Create checkbox for indicating if kids will be at the wedding
        kidsCheckBox = new JCheckBox("Kids at Wedding");
        mainPanel.add(kidsCheckBox);

        // Create button to confirm wedding details
        ComfirmButton = new JButton("Create Wedding");
        ComfirmButton.addActionListener(this);

        // Create text area to display wedding details
        WeddingDetails = new JTextArea(10, 30);
        WeddingDetails.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(WeddingDetails);

        // Add button and text area to main panel
        mainPanel.add(ComfirmButton);
        mainPanel.add(scrollPane);

        // Add main panel to frame
        getContentPane().add(mainPanel);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private JTextField createTextField(JPanel mainPanel, String label) {
        JPanel panel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        panel.setBackground(new Color(255, 182, 193)); // Light Pink Background
        JLabel jLabel = new JLabel(label);
        JTextField textField = new JTextField(20);
        panel.add(jLabel);
        panel.add(textField);
        mainPanel.add(panel);
        return textField;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == ComfirmButton) {
            // Retrieve values from text fields and checkbox
            String brideFirstName = BrideFirstName.getText();
            String brideLastName = BrideLastName.getText();
            String groomFirstName = GroomFirstName.getText();
            String groomLastName = GroomLastName.getText();
            String dateString = DateOfMarriage.getText();
            LocalDate date = LocalDate.parse(dateString);
            String Location = location.getText();
            String CakeType = cake.getText();
            boolean kids = kidsCheckBox.isSelected();

            // Create Person objects for bride and groom
            Person bride = new Person(brideFirstName, brideLastName);
            Person groom = new Person(groomFirstName, groomLastName);

            // Create Couple object
            Couple couple = new Couple(bride, groom);

            // Create Wedding object with user-provided details
            Wedding wedding = new Wedding(couple, date, Location, CakeType, kids);

            // Display wedding details in the text area
            WeddingDetails.setText("Wedding Details:\n" +
                    "Bride: " + bride.getFirstName() + " " + bride.getLastName() + "\n" +
                    "Groom: " + groom.getFirstName() + " " + groom.getLastName() + "\n" +
                    "Date: " + date + "\n" +
                    "Location: " + Location + "\n" +
                    "Cake: " + CakeType + "\n" +
                    "Kids at Wedding: " + (kids ? "Yes" : "No"));
        }
    }

    public static void main(String[] args) {
        new TestWedding();
    }
}
