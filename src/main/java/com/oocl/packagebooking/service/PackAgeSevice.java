package com.oocl.packagebooking.service;

import com.oocl.packagebooking.dao.PackAgeResponsity;
import com.oocl.packagebooking.entity.PackAge;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PackAgeSevice {

    @Autowired
    PackAgeResponsity packAgeResponsity;


    public PackAge save(PackAge packAge) {
        PackAge packAge1 = packAgeResponsity.save(packAge);
        return packAge1;
    }

    public List<PackAge> findAll() {
        List<PackAge> all = packAgeResponsity.findAll();
        return all;

    }

    public List<PackAge> findByState(String state) {
        List<PackAge> byState = packAgeResponsity.findByState(state);
        return byState;
    }

    public PackAge changeState(PackAge packAge, String id) {
        Optional<PackAge> packAgeOptional = packAgeResponsity.findById(Integer.valueOf(id));
        PackAge packAge1=null;
        if (packAgeOptional.isPresent()) {

             packAge1 = packAgeOptional.get();
            packAge1.setState(packAge.getState());
            packAgeResponsity.save(packAge1);
        }
      return packAge1;
    }
}
