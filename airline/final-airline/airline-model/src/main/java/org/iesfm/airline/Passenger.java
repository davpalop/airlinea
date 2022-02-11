package org.iesfm.airline;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;
import java.util.Objects;

@Document(collection = "passengers")
public class Passenger {

    @Id
    private PassengerId passengerId;
    private Email email;
    private String name;
    private String surname;
    private int seat;
    private List<Case> cases;

    @JsonCreator
    public Passenger (
            @JsonProperty("passenger_id") PassengerId passengerId,
            @JsonProperty("email") Email email,
            @JsonProperty("name") String name,
            @JsonProperty("surname") String surname,
            @JsonProperty("seat") int seat,
            @JsonProperty("cases") List<Case> cases) {
        this.passengerId = passengerId;
        this.email = email;
        this.name = name;
        this.surname = surname;
        this.seat = seat;
        this.cases = cases;
    }


    public PassengerId getPassengerId() {
        return passengerId;
    }

    public void setPassengerId(PassengerId passengerId) {
        this.passengerId = passengerId;
    }

    public Email getEmail() {
        return email;
    }

    public void setEmail(Email email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getSeat() {
        return seat;
    }

    public void setSeat(int seat) {
        this.seat = seat;
    }

    public List<Case> getCases() {
        return cases;
    }

    public void setCases(List<Case> cases) {
        this.cases = cases;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Passenger passenger = (Passenger) o;
        return seat == passenger.seat && Objects.equals(passengerId, passenger.passengerId) && Objects.equals(email, passenger.email) && Objects.equals(name, passenger.name) && Objects.equals(surname, passenger.surname) && Objects.equals(cases, passenger.cases);
    }

    @Override
    public int hashCode() {
        return Objects.hash(passengerId, email, name, surname, seat, cases);
    }

    @Override
    public String toString() {
        return "Passenger{" +
                "passengerId=" + passengerId +
                ", email=" + email +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", seat=" + seat +
                ", cases=" + cases +
                '}';
    }
}
