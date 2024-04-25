package com.nsbm.ebookstore.donation.service;
import com.nsbm.ebookstore.donation.model.DonationModel;
import com.nsbm.ebookstore.donation.repository.DonationModelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class DonationModelService {

    @Autowired
    private DonationModelRepository donationModelRepository;

    public List<DonationModel> getAllDonations() {
        return donationModelRepository.findAll();
    }

    public Optional<DonationModel> getDonationById(Long id) {
        return donationModelRepository.findById(id);
    }

    public DonationModel addDonation(DonationModel donation) {
        return donationModelRepository.save(donation);
    }

    public DonationModel updateDonation(Long id, DonationModel donation) {
        donation.setId(id);
        return donationModelRepository.save(donation);
    }

    public void deleteDonation(Long id) {
        donationModelRepository.deleteById(id);
    }
}
