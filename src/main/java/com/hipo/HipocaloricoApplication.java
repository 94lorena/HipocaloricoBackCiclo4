package com.hipo;

import com.hipo.model.Order;
import com.hipo.model.Supplements;
import com.hipo.model.User;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.hipo.interfaces.InterfacesOrder;
import com.hipo.interfaces.InterfacesSupplements;
import com.hipo.interfaces.InterfacesUser;

/**
 *
 * @author LORENA NAVAS
 */

@SpringBootApplication

public class HipocaloricoApplication implements CommandLineRunner {

    @Autowired
    private InterfacesUser userRepo;

    @Autowired
    private InterfacesSupplements supRepo;
    
    @Autowired
    private InterfacesOrder orderRepo;

    public static void main(String[] args) {
        SpringApplication.run(HipocaloricoApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        userRepo.deleteAll();
        supRepo.deleteAll();
        orderRepo.deleteAll();
  
    }

}
