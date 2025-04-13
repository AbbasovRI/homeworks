package homeworks.homework012;

import java.time.LocalDate;
import java.util.Objects;

public class Person {
    private String surname;
    private String name;
    private String patronymic;
    private LocalDate dateOfBirth;
    private long phoneNumber;
    private char gender;
    private int age;

    public Person(String surname, String name, String patronymic, LocalDate dateOfBirth, long phoneNumber, char gender, int age) {
        this.surname = surname;
        this.name = name;
        this.patronymic = patronymic;
        this.dateOfBirth = dateOfBirth;
        this.phoneNumber = phoneNumber;
        this.gender = gender;
        this.age = age;
    }

    public String getSurname() {
        return surname;
    }

    public String getName() {
        return name;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public long getPhoneNumber() {
        return phoneNumber;
    }

    public char getGender() {
        return gender;
    }

    public int getAge() {
        return age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return phoneNumber == person.phoneNumber && gender == person.gender && age == person.age && Objects.equals(surname, person.surname) && Objects.equals(name, person.name) && Objects.equals(patronymic, person.patronymic) && Objects.equals(dateOfBirth, person.dateOfBirth);
    }

    @Override
    public int hashCode() {
        return Objects.hash(surname, name, patronymic, dateOfBirth, phoneNumber, gender, age);
    }
}
