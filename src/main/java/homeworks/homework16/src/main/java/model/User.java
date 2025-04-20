package model;

import java.time.LocalDateTime;
import java.util.Objects;

public class User {
    private String id;
    private LocalDateTime dateAdded;
    private String login;
    private String password;
    private String surname;
    private String name;
    private String patronymic;
    private Integer age;
    private boolean isWorker;

    public User() { }

    public User(String id, LocalDateTime dateAdded, String login, String password, String surname, String name, String patronymic, Integer age, boolean isWorker) {
        this.id = id;
        this.dateAdded = dateAdded;
        this.login = login;
        this.password = password;
        this.surname = surname;
        this.name = name;
        this.patronymic = patronymic;
        this.age = age;
        this.isWorker = isWorker;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public LocalDateTime getDateAdded() {
        return dateAdded;
    }

    public void setDateAdded(LocalDateTime dateAdded) {
        this.dateAdded = dateAdded;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public boolean isWorker() {
        return isWorker;
    }

    public void setWorker(boolean worker) {
        isWorker = worker;
    }

    // Методы для работы с объектом
    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", dateAdded=" + dateAdded +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", surname='" + surname + '\'' +
                ", name='" + name + '\'' +
                ", patronymic='" + patronymic + '\'' +
                ", age=" + age +
                ", isWorker=" + isWorker +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        User user = (User) o;
        return isWorker == user.isWorker &&
                Objects.equals(id, user.id) &&
                Objects.equals(dateAdded, user.dateAdded) &&
                Objects.equals(login, user.login) &&
                Objects.equals(password, user.password) &&
                Objects.equals(surname, user.surname) &&
                Objects.equals(name, user.name) &&
                Objects.equals(patronymic, user.patronymic) &&
                Objects.equals(age, user.age);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, dateAdded, login, password, surname, name, patronymic, age, isWorker);
    }
}
