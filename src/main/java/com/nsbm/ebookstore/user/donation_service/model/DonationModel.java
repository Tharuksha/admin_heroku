package com.nsbm.ebookstore.user.donation_service.model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class DonationModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long donationId;
    private String isbn;
    private String bookName;
    private String author;
    private String donationType;

    // Constructors
    public DonationModel() {
    }

    public DonationModel(String isbn, String bookName, String author, String donationType) {
        this.isbn = isbn;
        this.bookName = bookName;
        this.author = author;
        this.donationType = donationType;
    }

    // Getters and Setters for id
    public Long getId() {
        return donationId;
    }

    public void setId(Long id) {
        this.donationId = id;
    }

    // Getters and Setters for isbn
    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    // Getters and Setters for bookName
    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    // Getters and Setters for author
    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    // Getters and Setters for donationType
    public String getDonationType() {
        return donationType;
    }

    public void setDonationType(String donationType) {
        this.donationType = donationType;
    }

    // toString method for easy debugging
    @Override
    public String toString() {
        return "DonationModel{" +
                "id=" + donationId +
                ", isbn='" + isbn + '\'' +
                ", bookName='" + bookName + '\'' +
                ", author='" + author + '\'' +
                ", donationType='" + donationType + '\'' +
                '}';
    }
}
