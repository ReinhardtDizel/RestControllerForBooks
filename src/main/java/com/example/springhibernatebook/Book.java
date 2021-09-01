package com.example.springhibernatebook;

import org.springframework.data.jpa.repository.Modifying;

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

    //title=======================================================
    @Column(name = "title", length = 300, nullable = false)
    private String title;

    //authorName=======================================================
    @Column(name = "Author", length = 100, nullable = false)
    private String authorName;

    //publishingHouse=======================================================
    @Column(name = "Publishing_House", length = 100, nullable = false)
    private String publishingHouse;

    //publishingDate=======================================================
    @Column(name = "Publishing_Date", length = 30, nullable = false)
    private String publishingDate;

    //productImageUrl=======================================================
    @Column(name = "Image_Url", length = 300, nullable = false)
    private String productImageUrl;

    public Book(String id,
                String title,
                String authorName,
                String publishingHouse,
                String publishingDate,
                String productImageUrl) {
        this.id = id;
        this.title = title;
        this.authorName = authorName;
        this.publishingHouse = publishingHouse;
        this.publishingDate = publishingDate;
        this.productImageUrl = productImageUrl;
    }

    public Book(String title,
                String authorName,
                String publishingHouse,
                String publishingDate,
                String productImageUrl) {
        this(UUID.randomUUID().toString(), title, authorName, publishingHouse, publishingDate, productImageUrl);
    }

    public Book() {
    }

    //================GET=========================================
    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthorName() {
        return authorName;
    }

    public String getPublishingHouse() {
        return publishingHouse;
    }

    public String getPublishingDate() {
        return publishingDate;
    }

    public String getProductImageUrl() {
        return productImageUrl;
    }

    //================SET=========================================
    public void setTitle(String title) {
        this.title = title;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setAuthorName() { this.authorName = authorName; }

    public void setPublishingHouse() {
        this.publishingHouse = publishingHouse;
    }

    public void setPublishingDate() {
        this.publishingDate = publishingDate;
    }

    public void setProductImageUrl() {
        this.productImageUrl = productImageUrl;
    }

}
