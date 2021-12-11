package com.hipo.repository;

import com.hipo.model.Supplements;
import com.hipo.model.User;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.hipo.interfaces.InterfacesSupplements;

/**
 *
 * @author LORENA NAVAS
 */

@Repository

public class SupplementsRepository {

    @Autowired
    private InterfacesSupplements crudInterface;

    public List<Supplements> listAll() {
        return crudInterface.findAll();
    }

    public Optional<Supplements> getSupplement(String reference) {
        return crudInterface.findById(reference);
    }

    public Supplements create(Supplements clothe) {
        return crudInterface.save(clothe);
    }

    public void update(Supplements clothe) {
        crudInterface.save(clothe);
    }

    public void delete(Supplements clothe) {
        crudInterface.delete(clothe);
    }

    public List<Supplements> gadgetsByPrice(double precio) {
        return crudInterface.findByPriceLessThanEqual(precio);
    }

    public List<Supplements> findByDescriptionLike(String description) {
        return crudInterface.findByDescriptionLike(description);
    }
}
