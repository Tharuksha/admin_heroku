package com.nsbm.ebookstore.user.donation_service.model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
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
}


