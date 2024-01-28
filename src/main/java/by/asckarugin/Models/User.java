package by.asckarugin.Models;

import by.asckarugin.In.Enums.Role;

import java.util.List;
import java.util.Objects;

public class User {
    private int id;
    private String name;
    private int personalCode;
    private Role role;
    private List<Measurements> measurements;

    public User(){}

    public User(int id, String name, int personalCode, Role role) {
        this.id = id;
        this.name = name;
        this.personalCode = personalCode;
        this.role = role;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPersonalCode() {
        return personalCode;
    }

    public void setPersonalCode(int personalCode) {
        this.personalCode = personalCode;
    }

    public List<Measurements> getMeasurement() {
        return measurements;
    }

    public void setMeasurement(List<Measurements> measurement) {
        this.measurements = measurement;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", Имя='" + name + '\'' +
                ", Лицевой счет=" + personalCode +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (id != user.id) return false;
        if (personalCode != user.personalCode) return false;
        return Objects.equals(name, user.name);
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (personalCode ^ (personalCode >>> 32));
        return result;
    }
}
