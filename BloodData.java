public class BloodData {
    private BloodGroup bloodGroup;
    private String rhFactor;

    public BloodData() {
        this.bloodGroup = BloodGroup.O;
        this.rhFactor = "+";
    }

    public BloodData(BloodGroup bloodGroup, String rhFactor) {
        this.bloodGroup = bloodGroup;
        this.rhFactor = rhFactor;
    }

    public BloodGroup getBloodGroup() {
        return bloodGroup;
    }

    public void setBloodGroup(BloodGroup bloodGroup) {
        this.bloodGroup = bloodGroup;
    }

    public String getRhFactor() {
        return rhFactor;
    }

    public void setRhFactor(String rhFactor) {
        this.rhFactor = rhFactor;
    }
}
