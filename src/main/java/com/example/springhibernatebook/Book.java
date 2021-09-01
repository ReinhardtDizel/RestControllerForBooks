package com.example.springhibernatebook;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.UUID;

@Entity
@Table(name = "book")
public class Book {

    @Id
    @Column(name = "id")
    private String id;

    @Column(name = "title", length = 300, nullable = false)
    private String title;

    public Book(String id, String title) {
        this.id = id;
        this.title = title;
    }

    public Book(String title) {
        this(UUID.randomUUID().toString(), title);
    }

    public Book() {
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setId(String id) {
        this.id = id;
    }

}
