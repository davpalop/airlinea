package org.iesfm.airline;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

public class Case {

    private int code;
    private String description;

    @JsonCreator
    public Case (
            @JsonProperty("code") int code,
            @JsonProperty("description") String description) {
        this.code = code;
        this.description = description;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Case aCase = (Case) o;
        return code == aCase.code && Objects.equals(description, aCase.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(code, description);
    }

    @Override
    public String toString() {
        return "Case{" +
                "code=" + code +
                ", description='" + description + '\'' +
                '}';
    }
}
