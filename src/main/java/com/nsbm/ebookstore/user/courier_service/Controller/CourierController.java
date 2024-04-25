package com.nsbm.ebookstore.user.courier_service.Controller;

import com.nsbm.ebookstore.user.courier_service.Model.Courier;
import com.nsbm.ebookstore.user.courier_service.Service.CourierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
@RequestMapping(CourierController.Constants.API_BASE)
public class CourierController {

    private final CourierService courierService;

    // Constants for this controller
    public static class Constants {
        public static final String API_BASE = "/api/couriers";
        public static final String ID_PATH_VARIABLE = "id";
        public static final String GET_ALL_COURIERS = "/";
        public static final String GET_COURIER_BY_ID = "/{id}";
        public static final String CREATE_COURIER = "/";
        public static final String UPDATE_COURIER = "/{id}";
        public static final String DELETE_COURIER = "/{id}";
        public static final String COURIER_DELETED_MESSAGE = "Courier deleted successfully";
    }

    @Autowired
    public CourierController(CourierService courierService) {
        this.courierService = courierService;
    }

    // Get all couriers
    @GetMapping(Constants.GET_ALL_COURIERS)
    public ResponseEntity<List<Courier>> getAllCouriers() {
        List<Courier> couriers = courierService.getAllCouriers();
        return new ResponseEntity<>(couriers, HttpStatus.OK);
    }

    // Get courier by ID
    @GetMapping(Constants.GET_COURIER_BY_ID)
    public ResponseEntity<Courier> getCourierById(@PathVariable(Constants.ID_PATH_VARIABLE) Long id) {
        Optional<Courier> courier = courierService.getCourierById(id);
        return courier.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // Create a new courier
    @PostMapping(Constants.CREATE_COURIER)
    public ResponseEntity<Courier> createCourier(@RequestBody Courier courier) {
        Courier createdCourier = courierService.createCourier(courier);
        return new ResponseEntity<>(createdCourier, HttpStatus.CREATED);
    }

    // Update an existing courier
    @PutMapping(Constants.UPDATE_COURIER)
    public ResponseEntity<Courier> updateCourier(@PathVariable(Constants.ID_PATH_VARIABLE) Long id, @RequestBody Courier updatedCourier) {
        Courier updated = courierService.updateCourier(id, updatedCourier);
        return updated != null ? new ResponseEntity<>(updated, HttpStatus.OK) :
                new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    // Delete a courier by ID
    @DeleteMapping(Constants.DELETE_COURIER)
    public ResponseEntity<String> deleteCourier(@PathVariable(Constants.ID_PATH_VARIABLE) Long id) {
        courierService.deleteCourier(id);
        return new ResponseEntity<>(Constants.COURIER_DELETED_MESSAGE, HttpStatus.OK);
    }
}
