package com.nsbm.ebookstore.user.courier_service.Service;

import com.nsbm.ebookstore.user.courier_service.Model.Courier;

import java.util.List;
import java.util.Optional;

public interface CourierService {

    List<Courier> getAllCouriers();

    Optional<Courier> getCourierById(Long id);

    Courier createCourier(Courier courier);

    Courier updateCourier(Long id, Courier updatedCourier);

    void deleteCourier(Long id);
}