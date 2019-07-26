package com.oocl.packagebooking.service;

import com.oocl.packagebooking.dao.BookPickGoodResponsity;
import com.oocl.packagebooking.dao.PackAgeResponsity;
import com.oocl.packagebooking.entity.BookPickGood;
import com.oocl.packagebooking.entity.PackAge;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BookPickGoodService {

    @Autowired
    BookPickGoodResponsity bookPickGoodResponsity;

    @Autowired
    PackAgeResponsity packAgeResponsity;
    public BookPickGood save(BookPickGood bookPickGood) {
        BookPickGood bookPickGood1 = bookPickGoodResponsity.save(bookPickGood);
        Optional<PackAge> packAgeOptional = packAgeResponsity.findById(bookPickGood.getId());
        if (packAgeOptional.isPresent()) {
            PackAge packAge = packAgeOptional.get();
            packAge.setState("已预约");
            packAgeResponsity.save(packAge);
        }
        return bookPickGood1;

    }
}
