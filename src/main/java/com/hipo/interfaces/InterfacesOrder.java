package com.hipo.interfaces;

import com.hipo.model.Order;
import java.util.List;
import java.util.Optional;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

/**
 *
 * @author LORENA NAVAS
 */

public interface InterfacesOrder extends MongoRepository<Order, Integer> {
    

    @Query("{'salesMan.zone': ?0}")
    List<Order> findByZone(String zone);
    

    Optional<Order> findTopByOrderByIdDesc();
}
