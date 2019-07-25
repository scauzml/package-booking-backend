package com.oocl.packagebooking.controller;

import com.oocl.packagebooking.entity.BookPickGood;
import com.oocl.packagebooking.service.BookPickGoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Goods")
public class GoodController {

    @Autowired
    BookPickGoodService bookPickGoodService;
    @PostMapping("/addBookPickGood")
    public ResponseEntity addParkingLot(@RequestBody BookPickGood bookPickGood) {

        BookPickGood bookPickGood1=bookPickGoodService.save(bookPickGood);
        return bookPickGood1!=null? ResponseEntity.status(HttpStatus.CREATED).body(bookPickGood1):ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }
}
