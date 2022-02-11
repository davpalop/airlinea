package org.iesfm.airline;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

public class Email {

    private String to;
    private String title;
    private String body;

    @JsonCreator
    public Email(
            @JsonProperty("to") String to,
            @JsonProperty("title") String title,
            @JsonProperty("body") String body) {
        this.to = to;
        this.title = title;
        this.body = body;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Email email = (Email) o;
        return Objects.equals(to, email.to) && Objects.equals(title, email.title) && Objects.equals(body, email.body);
    }

    @Override
    public int hashCode() {
        return Objects.hash(to, title, body);
    }

    @Override
    public String toString() {
        return "org.iesfm.shop.Email{" +
                "to='" + to + '\'' +
                ", title='" + title + '\'' +
                ", body='" + body + '\'' +
                '}';
    }
}
