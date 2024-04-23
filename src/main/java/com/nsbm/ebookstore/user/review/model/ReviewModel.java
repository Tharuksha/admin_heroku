package com.nsbm.ebookstore.user.review.model;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigInteger;

@Data
@Entity

public class ReviewModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long reviewid;

    private  long book_id;

    private long  userid;

    private String comments;

    public int rating;
}
