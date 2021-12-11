package com.hipo.interfaces;

import com.hipo.model.Supplements;
import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

/**
 *
 * @author LORENA NAVAS
 */

public interface InterfacesSupplements extends MongoRepository<Supplements, String> {
    public List<Supplements> findByPriceLessThanEqual(double precio);

    @Query("{'description':{'$regex':'?0','$options':'i'}}")
    public List<Supplements> findByDescriptionLike(String description);
}
