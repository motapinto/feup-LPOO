import java.util.ArrayList;
import java.util.List;

public class Event {
    private String title, date = "", description = "";
    private List<Person> people = new ArrayList<>();

    public Event(Event e) {
        this(e.title, e.date, e.description);
    }

    public Event(String title) {
        this.title = title;
    }

    public Event(String title, String date) {
        this.title = title;
        this.date = date;
    }

    public Event(String title, String date, String description) {
        this.title = title;
        this.date = date;
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public String getDate() {
        return date;
    }

    public String getDescription() {
        return description;
    }

    public List<Person> getPeople() {
        return people;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void addPerson(Person person) {
        if(!this.people.contains(person)) this.people.add(person);
    }

    public int getAudienceCount() {
        return this.people.size();
    }

    public void addEvent(Event e) {
        this.people.addAll(e.getPeople());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;                   // are the references equal
        if (o == null) return false;                  // is the other object null
        if (getClass() != o.getClass()) return false; // both objects the same class
        Event e = (Event) o;                          // cast the other object
        return this.date.equals(e.date) && this.description.equals(e.description) && this.title.equals(e.title);        // actual comparison
    }

    @Override
    public String toString() {
        return this.title + " is a " + this.description + " and will be held at " + this.date + ".";
    }
}
