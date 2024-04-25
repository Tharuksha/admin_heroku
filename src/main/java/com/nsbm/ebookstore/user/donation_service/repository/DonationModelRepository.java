package com.nsbm.ebookstore.donation.repository;
import com.nsbm.ebookstore.donation.model.DonationModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DonationModelRepository extends JpaRepository<DonationModel, Long> {
}
