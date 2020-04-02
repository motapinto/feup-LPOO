package com.aor.refactoring.example4;

import java.util.Objects;

public abstract class Person {

    protected final String name;
    protected final String phone;
    protected final String username;
    protected final String password;

    public Person(String name, String phone, String username, String password) {
        this.name = name;
        this.phone = phone;
        this.username = username;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return  Objects.equals(name, person.name) &&
                Objects.equals(phone, person.phone) &&
                Objects.equals(username, person.username) &&
                Objects.equals(password, person.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, phone, username, password);
    }
}