public class Person {
    private String FirstName;
    private String LastName;

    //First and last name of the person
    public Person(String FirstName, String LastName) {
        this.FirstName = FirstName;
        this.LastName = LastName;
    }
    //Allows to create the object of person so they have a first and last name
    public String getFirstName() {
        return FirstName;
    }

    //returns firstname

    public String getLastName() {
        return LastName;
        //returns last name
    }
}

