import java.util.Scanner;
public class useDinnerParty {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        DinnerParty dinnerParty = new DinnerParty();

        System.out.print("Enter number of guests for the party:");
        int numGuests = scanner.nextInt();
        dinnerParty.setGuests(numGuests);

        System.out.println("The party has " + dinnerParty.getGuests() + " guests.");
        dinnerParty.displayInvitation();

        System.out.print("Enter number of guests for the dinner party;");
        int numDinnerGuests = scanner.nextInt();
        dinnerParty.setGuests(numDinnerGuests);

        System.out.print("Enter the menu option -- 1 for chicken or 2 for Veggie.");
        int dinnerChoice = scanner.nextInt();
        dinnerParty.setDinnerChoice(dinnerChoice);

        System.out.println("The dinner party has " + dinnerParty.getGuests() + " guests.");
        System.out.println("Menu option " + dinnerParty.getDinnerChoice() + " will be served.");
        dinnerParty.displayInvitation();

    }
}
