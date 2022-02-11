package org.iesfm.airline;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.Objects;

@Document(collection = "flights")
public class Flight {

    @Id
    private int id;
    private String origin;
    private String destiny;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date date;
    
    @JsonCreator
    public Flight (
            @JsonProperty("flight_id") int id,
            @JsonProperty("origin") String origin,
            @JsonProperty("destiny") String destiny,
            @JsonProperty("date") Date date) {
        this.id = id;
        this.origin = origin;
        this.destiny = destiny;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getDestiny() {
        return destiny;
    }

    public void setDestiny(String destiny) {
        this.destiny = destiny;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Flight flight = (Flight) o;
        return id == flight.id && Objects.equals(origin, flight.origin) && Objects.equals(destiny, flight.destiny) && Objects.equals(date, flight.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, origin, destiny, date);
    }

    @Override
    public String toString() {
        return "Flight{" +
                "id=" + id +
                ", origin='" + origin + '\'' +
                ", destiny='" + destiny + '\'' +
                ", date=" + date +
                '}';
    }
}
