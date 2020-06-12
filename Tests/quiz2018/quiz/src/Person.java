import java.util.Comparator;
import java.util.Objects;
import java.util.Set;

public abstract class Person extends User implements Comparable{
    protected String name;
    protected int age;

    private Set<Integer> a;

    public Person(String name) {
        super(name);
        this.name = name;
    }

    public Person(String name, int age) {
        super(name + age);
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;                   // are the references equal
        if (o == null) return false;                  // is the other object null
        Person p = (Person) o;                          // cast the other object
        return this.name.equals(p.name);        // actual comparison
    }

    @Override
     public int compareTo(Object o) {
        return this.name.compareTo(((Person) o).name);
        //return Objects.compare(this.name, ((Person) o).name, Comparator.naturalOrder());
     }
}
