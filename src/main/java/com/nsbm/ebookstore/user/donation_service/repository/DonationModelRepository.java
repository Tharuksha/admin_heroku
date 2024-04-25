package com.nsbm.ebookstore.user.donation_service.repository;
import com.nsbm.ebookstore.user.donation_service.model.DonationModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DonationModelRepository extends JpaRepository<DonationModel, Long> {
}
