import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PizzaOrderGUI extends JFrame {
    private static final int MAX_TOPPINGS = 10;
    private static final String QUIT = "QUIT";

    private JTextField[] toppingFields;
    private JTextField deliveryAddressField;
    private JTextArea resultArea;
    private JCheckBox deliveryCheckbox;

    public PizzaOrderGUI() {
        super("Pizza Order");

        // Set light blue background
        getContentPane().setBackground(new Color(173, 216, 230));

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));

        // Create logo panel
        JPanel logoPanel = new JPanel();
        logoPanel.setBackground(new Color(173, 216, 230));  // Set background color same as the main panel

        // Load and scale down the logo image
        ImageIcon logoIcon = new ImageIcon("Dominos-logo.png");
        Image logoImage = logoIcon.getImage().getScaledInstance(400, 225, Image.SCALE_SMOOTH);
        ImageIcon scaledLogoIcon = new ImageIcon(logoImage);
        JLabel logoLabel = new JLabel(scaledLogoIcon);
        logoPanel.add(logoLabel);

        JPanel toppingPanel = new JPanel(new GridLayout(MAX_TOPPINGS, 1));
        toppingFields = new JTextField[MAX_TOPPINGS];
        for (int i = 0; i < MAX_TOPPINGS; i++) {
            toppingFields[i] = new JTextField();
            toppingPanel.add(new JLabel("Topping " + (i + 1) + ":"));
            toppingPanel.add(toppingFields[i]);
        }

        JPanel deliveryPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        deliveryCheckbox = new JCheckBox("Delivery");
        deliveryAddressField = new JTextField(20);
        deliveryAddressField.setEnabled(false);
        deliveryCheckbox.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                deliveryAddressField.setEnabled(deliveryCheckbox.isSelected());
            }
        });
        deliveryPanel.add(deliveryCheckbox);
        deliveryPanel.add(new JLabel("Delivery Address:"));
        deliveryPanel.add(deliveryAddressField);

        JButton orderButton = new JButton("Place Order");
        resultArea = new JTextArea(10, 30);
        resultArea.setEditable(false);

        orderButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Handle the order button click event
                placeOrder();
            }
        });

        mainPanel.add(logoPanel); // Add the logo panel to the main panel
        mainPanel.add(toppingPanel);
        mainPanel.add(deliveryPanel);
        mainPanel.add(orderButton);
        mainPanel.add(new JScrollPane(resultArea));

        add(mainPanel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    // Method to handle placing the order
    private void placeOrder() {
        String[] toppings = new String[MAX_TOPPINGS];
        int numToppings = 0;
        for (int i = 0; i < MAX_TOPPINGS; i++) {
            if (!toppingFields[i].getText().isEmpty()) {
                toppings[numToppings++] = toppingFields[i].getText();
            }
        }

        if (numToppings == 0) {
            JOptionPane.showMessageDialog(this,
                    "Please enter at least one topping.",
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }

        String deliveryAddress = "";
        if (deliveryCheckbox.isSelected()) {
            deliveryAddress = deliveryAddressField.getText().trim();
            if (deliveryAddress.isEmpty()) {
                JOptionPane.showMessageDialog(this,
                        "Please enter a delivery address.",
                        "Error",
                        JOptionPane.ERROR_MESSAGE);
                return;
            }
        }

        StringBuilder orderDetails = new StringBuilder();
        orderDetails.append("Pizza Toppings: ");
        for (int i = 0; i < numToppings; i++) {
            orderDetails.append(toppings[i]);
            if (i < numToppings - 1) {
                orderDetails.append(", ");
            }
        }

        double price = 14 + (2 * numToppings);
        orderDetails.append("\nPrice: $").append(price);

        if (deliveryCheckbox.isSelected()) {
            double deliveryFee = price > 18 ? 3 : 5;
            orderDetails.append("\nDelivery Address: ").append(deliveryAddress);
            orderDetails.append("\nDelivery Fee: $").append(deliveryFee);
            price += deliveryFee;
        }

        resultArea.setText(orderDetails.toString());
        JOptionPane.showMessageDialog(this,
                "Order Placed!\nTotal Price: $" + price,
                "Success",
                JOptionPane.INFORMATION_MESSAGE);
    }

    public static void main(String[] args) {
        // Create and display the pizza order GUI
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new PizzaOrderGUI();
            }
        });
    }
}
