package com.oocl.packagebooking.controller;

import com.oocl.packagebooking.entity.BookPickGood;
import com.oocl.packagebooking.entity.PackAge;
import com.oocl.packagebooking.service.PackAgeSevice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/packages")
public class PackAgeController {

     @Autowired
    PackAgeSevice packAgeSevice;
    @PostMapping("/addPackage")
    public ResponseEntity addParkingLot(@RequestBody PackAge packAge) {

        PackAge packAge1=packAgeSevice.save(packAge);
        return packAge1!=null? ResponseEntity.status(HttpStatus.CREATED).body(packAge1):ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }
}
