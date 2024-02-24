public class Party {
    private int guests;

    public void setGuests(int numGuests){
        guests = numGuests;
    }

    public int getGuests(){
        return guests;
    }

    public void displayInvitation(){
        //make this gui?
        System.out.println("Please come to my party!");
    }
}
