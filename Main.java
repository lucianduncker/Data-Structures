//Allow a user to enter any number of double values up to 20. Display each entered value.
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {

        double[] values = new double[20];
        int count = 0;

        Scanner scanner = new Scanner(System.in);
        while (count < 20) {
                System.out.println("Enter a new Double Value: ");
                double value = scanner.nextDouble();
                values[count] = value;
                count++;
//                if (scanner.hasNextDouble()) {
//                    values[count] = value;
//                } else if (!scanner.hasNextDouble()){
//                    System.out.println("Invalid Input");
//                }

        }

        System.out.println("Enter Values:");
        for(int i=0; i<count; i++){
            System.out.println(values[i]);
        }
        }
    }
