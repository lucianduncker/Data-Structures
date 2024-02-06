import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class BigYStoreApp extends JFrame implements ActionListener {
    private JComboBox<String> sizeList;
    private JCheckBox topping1, topping2, topping3, extraCheese, mixedPeppers, mozzarella;
    private JLabel topping1Label, topping2Label, topping3Label, extraCheeseLabel, mixedPeppersLabel, mozzarellaLabel;
    private JButton calculateButton;
    private JLabel resultLabel;
    private JRadioButton Margherita;
    private JRadioButton Pepperoni;
    private JRadioButton Vegetarian;
    private JRadioButton BBQChicken;
    private ButtonGroup G1;
    private ImageIcon margheritaImage, pepperoniImage, vegetarianImage, bbqChickenImage;
    private JLabel margheritaImageLabel, pepperoniImageLabel, vegetarianImageLabel, bbqChickenImageLabel;
    private JLabel pizzaImageLabel;

    public BigYStoreApp() {
        setTitle("BigY Store Pizza Order");
        setSize(700, 700);  // Increased height to accommodate additional toppings
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        // Pizza Selection
        Margherita = new JRadioButton();
        Pepperoni = new JRadioButton();
        Vegetarian = new JRadioButton();
        BBQChicken = new JRadioButton();

        G1 = new ButtonGroup();
        Margherita.setText("Margherita");
        Pepperoni.setText("Pepperoni");
        Vegetarian.setText("Vegetarian");
        BBQChicken.setText("BBQ Chicken");

        Margherita.setBounds(50, 20, 120, 30);
        Pepperoni.setBounds(180, 20, 120, 30);
        Vegetarian.setBounds(310, 20, 120, 30);
        BBQChicken.setBounds(440, 20, 120, 30);
        add(Margherita);
        add(Pepperoni);
        add(Vegetarian);
        add(BBQChicken);

        Margherita.addItemListener(null);
        Pepperoni.addItemListener(null);
        Vegetarian.addItemListener(null);
        BBQChicken.addItemListener(null);
        
        G1.add(Margherita);
        G1.add(Pepperoni);
        G1.add(Vegetarian);
        G1.add(BBQChicken);

        // Load pizza images
        margheritaImage = new ImageIcon("margarita.jpg");
        pepperoniImage = new ImageIcon("pepperoni.jpg");
        vegetarianImage = new ImageIcon("Veggie.jpg");
        bbqChickenImage = new ImageIcon("BBQchicken.jpg");
    
        margheritaImageLabel = new JLabel(margheritaImage);
        margheritaImageLabel.setBounds(50, 45, 120, 120);
        add(margheritaImageLabel);
    
        pepperoniImageLabel = new JLabel(pepperoniImage);
        pepperoniImageLabel.setBounds(180, 45, 120, 120);
        add(pepperoniImageLabel);
    
        vegetarianImageLabel = new JLabel(vegetarianImage);
        vegetarianImageLabel.setBounds(310, 45, 120, 120);
        add(vegetarianImageLabel);
    
        bbqChickenImageLabel = new JLabel(bbqChickenImage);
        bbqChickenImageLabel.setBounds(440, 45, 120, 120);
        add(bbqChickenImageLabel);

        

        String[] sizeOptions = {"Small ($5)", "Medium ($10)", "Large ($15)", "Super ($20)"};
        sizeList = new JComboBox<>(sizeOptions);
        sizeList.setBounds(50, 170, 150, 30);
        add(sizeList);

        // Toppings Selection
        topping1 = new JCheckBox("Mushrooms");
        topping1.setBounds(50, 200, 100, 30);
        add(topping1);

        topping1Label = new JLabel("+$0.50");
        topping1Label.setBounds(160, 200, 50, 30);
        add(topping1Label);

        topping2 = new JCheckBox("Olives");
        topping2.setBounds(50, 240, 100, 30);
        add(topping2);

        topping2Label = new JLabel("+$0.50");
        topping2Label.setBounds(160, 240, 50, 30);
        add(topping2Label);

        topping3 = new JCheckBox("Sausage");
        topping3.setBounds(50, 280, 100, 30);
        add(topping3);

        topping3Label = new JLabel("+$0.50");
        topping3Label.setBounds(160, 280, 50, 30);
        add(topping3Label);

        extraCheese = new JCheckBox("Extra Cheese");
        extraCheese.setBounds(50, 320, 150, 30);
        add(extraCheese);

        extraCheeseLabel = new JLabel("No extra cost");
        extraCheeseLabel.setBounds(200, 320, 100, 30);
        add(extraCheeseLabel);

        mixedPeppers = new JCheckBox("Mixed Peppers");
        mixedPeppers.setBounds(50, 360, 150, 30);
        add(mixedPeppers);

        mixedPeppersLabel = new JLabel("+$0.50");
        mixedPeppersLabel.setBounds(200, 360, 50, 30);
        add(mixedPeppersLabel);

        mozzarella = new JCheckBox("Mozzarella");
        mozzarella.setBounds(50, 400, 150, 30);
        add(mozzarella);

        mozzarellaLabel = new JLabel("+$0.50");
        mozzarellaLabel.setBounds(200, 400, 50, 30);
        add(mozzarellaLabel);

        // Calculate Button
        calculateButton = new JButton("Calculate Price");
        calculateButton.setBounds(50, 440, 150, 30);
        calculateButton.addActionListener(this);
        add(calculateButton);

        // Result Label
        resultLabel = new JLabel("Total Price: ");
        resultLabel.setBounds(50, 480, 400, 30);
        add(resultLabel);
        
        
        
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            BigYStoreApp app = new BigYStoreApp();
            app.setVisible(true);
        });
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == calculateButton) {
            calculatePrice();
        }
    }
   
    private String getSelectedPizza() {
    if (Margherita.isSelected()) {
        return "Margherita";
    } else if (Pepperoni.isSelected()) {
        return "Pepperoni";
    } else if (Vegetarian.isSelected()) {
        return "Vegetarian";
    } else if (BBQChicken.isSelected()) {
        return "BBQ Chicken";
    } else {
        return "Unknown Pizza";
    }
}

    private void calculatePrice() {
        // Get selected pizza, size, and toppings
        String selectedPizza = getSelectedPizza();
        String selectedSize = (String) sizeList.getSelectedItem();
        boolean hasTopping1 = topping1.isSelected();
        boolean hasTopping2 = topping2.isSelected();
        boolean hasTopping3 = topping3.isSelected();
        boolean hasExtraCheese = extraCheese.isSelected();
        boolean hasMixedPeppers = mixedPeppers.isSelected();
        boolean hasMozzarella = mozzarella.isSelected();

        
        // Calculate base price based on size
        double basePrice;
        switch (selectedSize) {
            case "Small ($5)":
                basePrice = 5.0;
                break;
            case "Medium ($10)":
                basePrice = 10.0;
                break;
            case "Large ($15)":
                basePrice = 15.0;
                break;
            case "Super ($20)":
                basePrice = 20.0;
                break;
            default:
                basePrice = 0.0;
        }
        

        // Calculate additional toppings cost
        int selectedToppingsCount = (hasTopping1 ? 1 : 0) + (hasTopping2 ? 1 : 0) + (hasTopping3 ? 1 : 0) +
        (hasExtraCheese ? 1 : 0) + (hasMixedPeppers ? 1 : 0) + (hasMozzarella ? 1 : 0);

        // Ensure that no more than three toppings are selected
        if (selectedToppingsCount > 3) {
            JOptionPane.showMessageDialog(this, "You can only select up to three toppings.", "Invalid Toppings", JOptionPane.WARNING_MESSAGE);
            return; // close
        }

        
        double toppingsCost;
        if (selectedToppingsCount <= 2) {
            toppingsCost = selectedToppingsCount * 0.50;
        } else if (selectedToppingsCount == 3) {
            if (hasExtraCheese) {
                toppingsCost = 1.0; // 1.25 for three toppings and $1 extra for extra cheese
            } else {
                toppingsCost = 1.25; // 1.25 for three toppings without extra cheese
            }
        } else {
            toppingsCost = 0.0; // No toppings selected
        }
        
         // Display the result
        double totalCost = basePrice + toppingsCost;
        String resultText = "Total Price for " + selectedSize + " " + selectedPizza + " with toppings: $" + totalCost;
        resultLabel.setText(resultText);

        // Update pizza image based on selected pizza type
        updatePizzaImage(selectedPizza);
    }
    private void updatePizzaImage(String pizzaType) {
    // Update pizza image based on the selected pizza type
        switch (pizzaType) {
            case "Margherita":
                pizzaImageLabel.setIcon(margheritaImage);
                break;
            case "Pepperoni":
                pizzaImageLabel.setIcon(pepperoniImage);
                break;
            case "Vegetarian":
                pizzaImageLabel.setIcon(vegetarianImage);
                break;
            case "BBQ Chicken":
                pizzaImageLabel.setIcon(bbqChickenImage);
                break;
        }
    }
}
