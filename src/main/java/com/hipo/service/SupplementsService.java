package com.hipo.service;

import com.hipo.model.Supplements;
import com.hipo.repository.SupplementsRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author LORENA NAVAS
 */

@Service

public class SupplementsService {

    @Autowired
    private SupplementsRepository repositorio;

    public List<Supplements> listAll() {
        return repositorio.listAll();
    }

    public Optional<Supplements> getSupplement(String reference) {
        return repositorio.getSupplement(reference);
    }

    public Supplements create(Supplements supplement) {
        if (supplement.getReference() == null) {
            return supplement;
        } else {
            return repositorio.create(supplement);
        }
    }

    public Supplements update(Supplements supplement) {

        if (supplement.getReference() != null) {
            Optional<Supplements> supplementDb = repositorio.getSupplement(supplement.getReference());
            if (!supplementDb.isEmpty()) {
                if (supplement.getBrand() != null) {
                    supplementDb.get().setBrand(supplement.getBrand());
                }
                if (supplement.getCategory() != null) {
                    supplementDb.get().setCategory(supplement.getCategory());
                }

                if (supplement.getDescription() != null) {
                    supplementDb.get().setDescription(supplement.getDescription());
                }
                if (supplement.getPrice() != 0.0) {
                    supplementDb.get().setPrice(supplement.getPrice());
                }
                if (supplement.getQuantity() != 0) {
                    supplementDb.get().setQuantity(supplement.getQuantity());
                }
                if (supplement.getPhotography() != null) {
                    supplementDb.get().setPhotography(supplement.getPhotography());
                }
                supplementDb.get().setAvailability(supplement.isAvailability());
                repositorio.update(supplementDb.get());
                return supplementDb.get();
            } else {
                return supplement;
            }
        } else {
            return supplement;
        }
    }

    public boolean delete(String reference) {
        Boolean aBoolean = getSupplement(reference).map(supplement -> {
            repositorio.delete(supplement);
            return true;
        }).orElse(false);
        return aBoolean;
    }

    public List<Supplements> gadgetsByPrice(double price) {
        return repositorio.gadgetsByPrice(price);
    }

    public List<Supplements> findByDescriptionLike(String description) {
        return repositorio.findByDescriptionLike(description);
    }
}
