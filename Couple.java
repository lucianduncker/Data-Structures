public class Couple {
    private Person Bride;
    private Person Groom;
//creates variables of bride and groom that is a person of first and last name
    public Couple(Person Bride, Person Groom) {
        this.Bride = Bride;
        this.Groom = Groom;
    }
//used to create the object or bride or groom with respect to the person including first and last name
    public Person getBride() {
        return Bride;
    }
//returns bride
    public Person getGroom() {
        return Groom;
        //returns groom
    }
}
