import java.util.Scanner;

public class BadSubscriptCaught {
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            String[] names = {"Bob", "John", "Max", "Tristan", "Noel", "Kadin", "Lucian", "Syd", "Josh", "Daniel"};

            System.out.println("Enter a digit for the index you'd like to print: ");
            int index = scanner.nextInt();

            try {
                System.out.println("The index at " + index + " is " + names[index]);

            } catch (ArrayIndexOutOfBoundsException e){
                System.out.println("You have entered an integer that is bigger than the array size");
            }

        }
    }

