import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TestPatient {
    private JFrame frame;
    private JTextField id, Age, Height, Weight, TypeBlood, RHFactor;
    private JButton submit;

    public TestPatient() {
        frame = new JFrame("Patient Details");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 250);
        frame.setLayout(new GridLayout(7, 2));

        frame.add(new JLabel("ID Number:"));
        id = new JTextField();
        frame.add(id);

        frame.add(new JLabel("Age:"));
        Age = new JTextField();
        frame.add(Age);

        frame.add(new JLabel("Height (cm):"));
        Height = new JTextField();
        frame.add(Height);

        frame.add(new JLabel("Weight (kg):"));
        Weight = new JTextField();
        frame.add(Weight);

        frame.add(new JLabel("Blood Type (A, B, O):"));
        TypeBlood = new JTextField();
        frame.add(TypeBlood);

        frame.add(new JLabel("Rh Factor (+ or -):"));
        RHFactor = new JTextField();
        frame.add(RHFactor);

        submit = new JButton("Submit");
        submit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                createPatient();
            }
        });
        frame.add(submit);

        frame.setVisible(true);
        frame.getContentPane().setBackground(Color.LIGHT_GRAY);
    }

    private void createPatient() {
        try {
            int idNumber = Integer.parseInt(id.getText());
            int age = Integer.parseInt(Age.getText());
            double height = Double.parseDouble(Height.getText());
            double weight = Double.parseDouble(Weight.getText());
            BloodGroup bloodGroup = BloodGroup.valueOf(TypeBlood.getText().toUpperCase());
            String rhFactor = RHFactor.getText().toUpperCase(); // RhFactor is no longer part of BloodGroup enum
            BloodData bloodData = new BloodData(bloodGroup, rhFactor);
            Patient patient = new Patient(idNumber, age, bloodData, height, weight);

            JOptionPane.showMessageDialog(frame,
                    "Patient created:\nID Number: " + patient.getIdNumber() +
                            "\nAge: " + patient.getAge() +
                            "\nHeight: " + patient.getHeight() + " cm" +
                            "\nWeight: " + patient.getWeight() + " lbs" +
                            "\nBlood Type: " + bloodGroup +
                            "\nRh Factor: " + rhFactor);
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(frame, "Invalid input. Please enter valid numbers.");
        } catch (IllegalArgumentException ex) {
            JOptionPane.showMessageDialog(frame, "Invalid input for blood type or Rh factor. Please enter valid values.");
        }
    }

    public static void main(String[] args) {
        new TestPatient();
    }
}
