package com.nsbm.ebookstore.user.courier_service.Service;

import com.nsbm.ebookstore.user.courier_service.Model.Courier;
import com.nsbm.ebookstore.user.courier_service.Repository.CourierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourierServiceImpl implements CourierService {

    private final CourierRepository courierRepository;

    @Autowired
    public CourierServiceImpl(CourierRepository courierRepository) {
        this.courierRepository = courierRepository;
    }

    @Override
    public List<Courier> getAllCouriers() {
        return courierRepository.findAll();
    }

    @Override
    public Optional<Courier> getCourierById(Long id) {
        return courierRepository.findById(id);
    }

    @Override
    public Courier createCourier(Courier courier) {
        return courierRepository.save(courier);
    }

    @Override
    public Courier updateCourier(Long id, Courier updatedCourier) {
        Optional<Courier> optionalCourier = courierRepository.findById(id);
        if (optionalCourier.isPresent()) {
            Courier existingCourier = optionalCourier.get();
            existingCourier.setName(updatedCourier.getName());
            existingCourier.setContactNumber(updatedCourier.getContactNumber());
            existingCourier.setDeliveryArea(updatedCourier.getDeliveryArea());
            return courierRepository.save(existingCourier);
        }
        return null; 
    }

    @Override
    public void deleteCourier(Long id) {
        courierRepository.deleteById(id);
    }
}