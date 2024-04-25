package com.nsbm.ebookstore.user.book_service.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

import java.sql.Date;

@Data
@Entity
public class BookModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bookId;
    private String isbn;
    private String bookName;
    private String bookAuthor;
    private String publisher;
    private Date addedOn;
    private int quantity;
    private String imgName;
}
