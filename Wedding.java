import java.time.LocalDate;

public class Wedding {
    private Couple couple;
    private LocalDate date;
    private String location;
    private String cake;
    private boolean kids;

    public Wedding(Couple couple, LocalDate date, String location, String cake, boolean kids) {
        this.couple = couple;
        this.date = date;
        this.location = location;
        this.cake = cake;
        this.kids = kids;
    }

    // Getter methods
    public Couple getCouple() {
        return couple;
    }

    public LocalDate getDate() {
        return date;
    }

    public String getLocation() {
        return location;
    }

    public String getCake() {
        return cake;
    }

    public boolean isKids() {
        return kids;
    }
}
