import java.util.Scanner;
public class MoneyConvertor {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a dollar ammount you want to convert into change:");
        
        try {
            double change = sc.nextDouble();

            int amount = (int)(Math.round(change * 100));
        
        if (amount == 0) {
            System.out.println("no change");
        }

        if (amount > 1) {
            System.out.println("Your change is: " + amount + " cents");
        }
        if (amount == 1) {
            System.out.println("Your change is: 1 cent");
        }

        int quarters = amount / 25;
        int dimes = (amount - (quarters * 25)) / 10;
        int nickels = (amount - (quarters * 25) - (dimes * 10)) / 5;
        int pennies = (amount - (quarters * 25) - (dimes * 10) - (nickels * 5));

        if (quarters > 1) {
            System.out.println(quarters + " quarters");
        } else if (quarters == 1) {
            System.out.println(quarters + " quarter");
        }
        if (dimes > 1) {
            System.out.println(dimes + " dimes");
        } else if (dimes == 1) {
            System.out.println(dimes + " dime");
        }
        if (nickels > 1) {
            System.out.println(nickels + " nickels");
        } else if (nickels == 1) {
            System.out.println(nickels + " nickel");
        }
        if (pennies > 1) {
            System.out.println(pennies + " pennies");
        } else if (pennies == 1) {
            System.out.println(pennies + " penny");
        }
        
        } catch (Exception NumberFormatException){
            System.out.println("Please Enter a Number");
        }

        
    }
}