import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

// Represents a grocery item
class Item {
    private String name;
    private double price;

    public Item(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }
}

// Represents a shopper's desire to purchase a given item in a given quantity
class ItemOrder {
    private Item item;
    private int quantity;

    public ItemOrder(Item item, int quantity) {
        this.item = item;
        this.quantity = quantity;
    }

    public Item getItem() {
        return item;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getTotalPrice() {
        return item.getPrice() * quantity;
    }
}

// Represents a shopping list that stores ItemOrders
class ShoppingList {
    private ArrayList<ItemOrder> items;

    public ShoppingList() {
        items = new ArrayList<>();
    }

    public void addItem(ItemOrder itemOrder) {
        items.add(itemOrder);
    }

    public void removeItem(ItemOrder itemOrder) {
        items.remove(itemOrder);
    }

    public double getTotalPrice() {
        double total = 0;
        for (ItemOrder itemOrder : items) {
            total += itemOrder.getTotalPrice();
        }
        return total;
    }

    public ArrayList<ItemOrder> getItems() {
        return items;
    }
}

// GUI for the shopping list
public class ShoppingCartGUI {
    private JFrame frame;
    private JTextArea cartTextArea;
    private JTextField itemNameField;
    private JTextField itemPriceField;
    private JTextField itemQuantityField;
    private ShoppingList list;

    public ShoppingCartGUI() {
        list = new ShoppingList();
        initialize();
    }

    private void initialize() {
        frame = new JFrame();
        frame.setTitle("Shopping List");
        frame.setSize(700, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Set the background color of the content pane to red
        frame.getContentPane().setBackground(Color.RED);

        frame.setLayout(new BorderLayout());

        // Create a panel for the logo
        JPanel logoPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                ImageIcon icon = new ImageIcon("BigYLogo.jpg");
                g.drawImage(icon.getImage(), 0, 0, 256, 137, null);
            }
        };
        logoPanel.setPreferredSize(new Dimension(256, 137));
        logoPanel.setBackground(Color.RED); // Set background color
        frame.add(logoPanel, BorderLayout.NORTH);

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
        inputPanel.setBackground(Color.RED); // Set background color

        JButton addButton = new JButton("Add Item");
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = itemNameField.getText();
                double price = Double.parseDouble(itemPriceField.getText());
                int quantity = Integer.parseInt(itemQuantityField.getText());
                Item item = new Item(name, price);
                ItemOrder itemOrder = new ItemOrder(item, quantity);
                list.addItem(itemOrder);
                updateCartTextArea();
            }
        });

        JButton removeButton = new JButton("Remove Item");
        removeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedText = cartTextArea.getSelectedText();
                if (selectedText == null || selectedText.isEmpty()) {
                    return; // No item selected, do nothing
                }

                // Find the item in the list based on the selected text
                for (ItemOrder itemOrder : list.getItems()) {
                    String itemString = itemOrder.getItem().getName() + " - Quantity: " + itemOrder.getQuantity() + ", Price: $" + itemOrder.getTotalPrice();
                    if (itemString.equals(selectedText)) {
                        list.removeItem(itemOrder);
                        updateCartTextArea();
                        break;
                    }
                }
            }
        });



        JPanel buttonPanel = new JPanel(new GridLayout(1, 2));
        buttonPanel.add(addButton);
        buttonPanel.add(removeButton);
        buttonPanel.setBackground(Color.RED); // Set background color

        frame.add(inputPanel, BorderLayout.CENTER);
        frame.add(buttonPanel, BorderLayout.SOUTH);

        // Add cartTextArea to a JScrollPane
        cartTextArea = new JTextArea(10, 30);
        cartTextArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(cartTextArea);
        frame.add(scrollPane, BorderLayout.EAST);

        frame.setVisible(true);
    }

    private void updateCartTextArea() {
        StringBuilder sb = new StringBuilder();
        for (ItemOrder itemOrder : list.getItems()) {
            sb.append(itemOrder.getItem().getName()).append(" - Quantity: ")
                    .append(itemOrder.getQuantity()).append(", Price: $")
                    .append(itemOrder.getTotalPrice()).append("\n");
        }
        sb.append("\nTotal Price: $").append(list.getTotalPrice());
        cartTextArea.setText(sb.toString());
    }

    public static void main(String[] args) {
        new ShoppingCartGUI();
    }
}
