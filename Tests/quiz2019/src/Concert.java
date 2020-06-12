import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Concert {
    private List<Act> acts = new ArrayList<>();
    private String city, country, date;

    public Concert(String city, String country, String date) {
        this.city = city;
        this.country = country;
        this.date = date;
    }

    public List<Act> getActs() {
        return acts;
    }

    public void addAct(Act act) {
        acts.add(act);
    }

    public String getCity() {
        return city;
    }

    public String getCountry() {
        return country;
    }

    public String getDate() {
        return date;
    }

    public boolean isValid(Ticket ticket) {
        return ticket.getConcert().equals(this);
    }

    public boolean participates(Artist artist) {
        for(Act act : acts) {
            if(act instanceof Artist && act.equals(artist)) return true;
            if(act instanceof Band && ((Band) act).containsArtist(artist)) return true;
        }
        return false;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;                         // are the references equal
        if (o == null) return false;                        // is the other object null
        if (getClass() != o.getClass()) return false;       // both objects the same class
        Concert c = (Concert) o;                            // cast the other object
        return this.city.equals(c.city) && this.country.equals(c.country)
                && this.date.equals(c.date);                // actual comparison
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.date, this.country, this.city);
    }
}
