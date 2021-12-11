package com.hipo.interfaces;

import com.hipo.model.User;
import java.util.List;
import java.util.Optional;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 *
 * @author LORENA NAVAS
 */

public interface InterfacesUser extends MongoRepository<User, Integer> {
    public Optional<User> findByEmail(String email);
    public Optional<User> findByEmailAndPassword(String email, String password);
    

    List<User> findByMonthBirthtDay(String monthBirthtDay);
    

    Optional<User> findTopByOrderByIdDesc();
}
