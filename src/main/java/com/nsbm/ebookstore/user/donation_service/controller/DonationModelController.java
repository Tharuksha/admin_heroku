package com.nsbm.ebookstore.user.donation_service.controller;

import com.nsbm.ebookstore.user.donation_service.model.DonationModel;
import com.nsbm.ebookstore.user.donation_service.service.DonationModelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
@RequestMapping(DonationModelController.BASE_PATH)
public class DonationModelController {

    // Base path for all donation endpoints
    public static final String BASE_PATH = "/donations";

    // Endpoints as constants
    public static final String GET_ALL_DONATIONS = "";
    public static final String GET_DONATION_BY_ID = "/{id}";
    public static final String ADD_DONATION = "";
    public static final String UPDATE_DONATION = "/{id}";
    public static final String DELETE_DONATION = "/{id}";

    @Autowired
    private DonationModelService donationModelService;

    @GetMapping(GET_ALL_DONATIONS)
    public ResponseEntity<List<DonationModel>> getAllDonations() {
        List<DonationModel> donations = donationModelService.getAllDonations();
        return new ResponseEntity<>(donations, HttpStatus.OK);
    }

    @GetMapping(GET_DONATION_BY_ID)
    public ResponseEntity<DonationModel> getDonationById(@PathVariable("id") Long id) {
        Optional<DonationModel> donation = donationModelService.getDonationById(id);
        return donation.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping(ADD_DONATION)
    public ResponseEntity<DonationModel> addDonation(@RequestBody DonationModel donation) {
        DonationModel newDonation = donationModelService.addDonation(donation);
        return new ResponseEntity<>(newDonation, HttpStatus.CREATED);
    }

    @PutMapping(UPDATE_DONATION)
    public ResponseEntity<DonationModel> updateDonation(@PathVariable("id") Long id, @RequestBody DonationModel donation) {
        DonationModel updatedDonation = donationModelService.updateDonation(id, donation);
        return new ResponseEntity<>(updatedDonation, HttpStatus.OK);
    }

    @DeleteMapping(DELETE_DONATION)
    public ResponseEntity<String> deleteDonation(@PathVariable("id") Long id) {
        donationModelService.deleteDonation(id);
        return new ResponseEntity<>("Donation deleted successfully", HttpStatus.OK);
    }
}
