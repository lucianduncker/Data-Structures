public class Patient {
    private int idNumber;
    private int age;
    private BloodData bloodData;
    private double height;
    private double weight;
    //gives default values
    public Patient() {
        this.idNumber = 0;
        this.age = 0;
        this.bloodData = new BloodData();
        this.height = 0.0;
        this.weight = 0.0;
    }

    public Patient(int idNumber, int age, BloodData bloodData, double height, double weight) {
        this.idNumber = idNumber;
        this.age = age;
        this.bloodData = bloodData;
        this.height = height;
        this.weight = weight;
    }

    public int getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(int idNumber) {
        this.idNumber = idNumber;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public BloodData getBloodData() {
        return bloodData;
    }

    public void setBloodData(BloodData bloodData) {
        this.bloodData = bloodData;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }
}


