package com.oocl.packagebooking.controller;

import com.oocl.packagebooking.entity.BookPickGood;
import com.oocl.packagebooking.entity.PackAge;
import com.oocl.packagebooking.service.PackAgeSevice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping()
    public ResponseEntity getParkingLotByPage() {
         List<PackAge> packAgeList=packAgeSevice.findAll();
        return ResponseEntity.ok().body(packAgeList);
    }

    @GetMapping(params = {"state"})
    public ResponseEntity getParkingLotByPage(@RequestParam("state")String state) {
        List<PackAge> packAgeList=packAgeSevice.findByState(state);
        return ResponseEntity.ok().body(packAgeList);
    }

    @PutMapping("/{id}")
    public ResponseEntity changeParkingLot(@RequestBody PackAge packAge,@PathVariable("id")String id) {

        return ResponseEntity.ok().body(packAgeSevice.changeState(packAge,id));
    }
}
