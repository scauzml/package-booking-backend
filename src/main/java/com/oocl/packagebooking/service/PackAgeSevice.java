package com.oocl.packagebooking.service;

import com.oocl.packagebooking.dao.PackAgeResponsity;
import com.oocl.packagebooking.entity.PackAge;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PackAgeSevice {

    @Autowired
    PackAgeResponsity packAgeResponsity;


    public PackAge save(PackAge packAge) {
        PackAge packAge1 = packAgeResponsity.save(packAge);
        return packAge1;
    }
}
