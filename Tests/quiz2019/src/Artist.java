public class Artist extends Act {
    public Artist(String name, String country) {
        super(name, country);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;                                         // are the references equal
        if (o == null) return false;                                        // is the other object null
        if (getClass() != o.getClass()) return false;                       // both objects the same class
        Artist a = (Artist) o;                                              // cast the other object
        return this.name.equals(a.name) && this.country.equals(a.country);  // actual comparison
    }
}
