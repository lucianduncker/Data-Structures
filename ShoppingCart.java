import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ShoppingCart extends JFrame {
    private ArrayList<ItemOrder> items;
    private JTextArea cartTextArea;
    private JTextField itemNameField;
    private JTextField itemPriceField;
    private JTextField itemQuantityField;

    public ShoppingCart() {
        items = new ArrayList<>();
        initialize();
    }

    private void initialize() {
        setTitle("Shopping List");
        setSize(700, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        getContentPane().setBackground(Color.RED);

        setLayout(new BorderLayout());

        JPanel logoPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                ImageIcon icon = new ImageIcon("BigYLogo.jpg");
                g.drawImage(icon.getImage(), 0, 0, 256, 137, null);
            }
        };
        logoPanel.setPreferredSize(new Dimension(256, 137));
        logoPanel.setBackground(Color.RED);
        add(logoPanel, BorderLayout.NORTH);

        JPanel inputPanel = new JPanel(new GridLayout(3, 2));
        itemNameField = new JTextField();
        itemPriceField = new JTextField();
        itemQuantityField = new JTextField();
        inputPanel.add(new JLabel("Item Name:"));
        inputPanel.add(itemNameField);
        inputPanel.add(new JLabel("Item Price:"));
        inputPanel.add(itemPriceField);
        inputPanel.add(new JLabel("Item Quantity:"));
        inputPanel.add(itemQuantityField);
        inputPanel.setBackground(Color.RED);

        JButton addButton = new JButton("Add Item");
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = itemNameField.getText();
                double price = Double.parseDouble(itemPriceField.getText());
                int quantity = Integer.parseInt(itemQuantityField.getText());
                Item item = new Item(name, price);
                ItemOrder itemOrder = new ItemOrder(item, quantity);
                addItem(itemOrder);
                updateCartTextArea();
            }
        });

        JPanel buttonPanel = new JPanel(new GridLayout(1, 1));
        buttonPanel.add(addButton);
        buttonPanel.setBackground(Color.RED);

        add(inputPanel, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);

        cartTextArea = new JTextArea(10, 30);
        cartTextArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(cartTextArea);
        add(scrollPane, BorderLayout.EAST);

        setVisible(true);
    }

    private void addItem(ItemOrder itemOrder) {
        items.add(itemOrder);
    }

    private void updateCartTextArea() {
        StringBuilder sb = new StringBuilder();
        for (ItemOrder itemOrder : items) {
            sb.append(itemOrder.getItem().getName()).append(" - Quantity: ")
                    .append(itemOrder.getQuantity()).append(", Price: $")
                    .append(itemOrder.getTotalPrice()).append("\n");
        }
        sb.append("\nTotal Price: $").append(getTotalPrice());
        cartTextArea.setText(sb.toString());
    }

    private double getTotalPrice() {
        double total = 0;
        for (ItemOrder itemOrder : items) {
            total += itemOrder.getTotalPrice();
        }
        return total;
    }

    public static void main(String[] args) {
        new ShoppingCart();
    }
}
