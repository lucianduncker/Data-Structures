public enum BloodGroup {
    A("+", "-"), B("+", "-"), O("+", "-");

    private final String positive;
    private final String negative;

    BloodGroup(String positive, String negative) {
        this.positive = positive;
        this.negative = negative;
    }

    public String getPositive() {
        return positive;
    }

    public String getNegative() {
        return negative;
    }


}
