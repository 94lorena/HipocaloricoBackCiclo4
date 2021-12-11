package com.hipo.controller;

import com.hipo.model.Supplements;
import com.hipo.service.SupplementsService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author LORENA NAVAS
 */

@RestController
@RequestMapping("/api/supplements")
@CrossOrigin("*")

public class SupplementsController {

    @Autowired
    private SupplementsService servicio;

    @GetMapping("/all")
    public List<Supplements> listAll() {
        return servicio.listAll();
    }

    @GetMapping("/{reference}")
    public Optional<Supplements> getSupplement(@PathVariable("reference") String reference) {
        return servicio.getSupplement(reference);
    }

    @PostMapping("/new")
    @ResponseStatus(HttpStatus.CREATED)
    public Supplements create(@RequestBody Supplements gadget) {
        return servicio.create(gadget);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Supplements update(@RequestBody Supplements gadget) {
        return servicio.update(gadget);
    }

    @DeleteMapping("/{reference}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("reference") String reference) {
        return servicio.delete(reference);
    }

    @GetMapping("/price/{price}")
    public List<Supplements> gadgetsByPrice(@PathVariable("price") double precio) {
        return servicio.gadgetsByPrice(precio);
    }

    @GetMapping("/description/{description}")
    public List<Supplements> findByDescriptionLike(@PathVariable("description") String description) {
        return servicio.findByDescriptionLike(description);
    }
}
