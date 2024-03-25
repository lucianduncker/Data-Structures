import java.util.Scanner;

public class TestBloodData {
    public static void main(String[] args) {
        BloodData defaultBloodData = new BloodData();
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter blood group (A, B, O): ");
        BloodGroup bloodGroup = BloodGroup.valueOf(scanner.nextLine().toUpperCase());

        System.out.print("Enter Rh factor (+ or -): ");
        String rhFactor = scanner.nextLine().toUpperCase();

        BloodData userBloodData = new BloodData(bloodGroup, rhFactor);

        System.out.println("\nDefault BloodData:");
        displayBloodData(defaultBloodData);

        System.out.println("\nUser BloodData:");
        displayBloodData(userBloodData);

        defaultBloodData.setBloodGroup(bloodGroup);
        defaultBloodData.setRhFactor(rhFactor);

        System.out.println("\nUpdated Default BloodData:");
        displayBloodData(defaultBloodData);
    }

    private static void displayBloodData(BloodData bloodData) {
        System.out.println("Blood Group: " + bloodData.getBloodGroup());
        System.out.println("Rh Factor: " + bloodData.getRhFactor());
    }
}
