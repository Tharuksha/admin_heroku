package com.nsbm.ebookstore.user.courier_service.Repository;
import com.nsbm.ebookstore.user.courier_service.Model.Courier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourierRepository extends JpaRepository<Courier, Long> {

}
