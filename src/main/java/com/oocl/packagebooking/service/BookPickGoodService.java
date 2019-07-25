package com.oocl.packagebooking.service;

import com.oocl.packagebooking.dao.BookPickGoodResponsity;
import com.oocl.packagebooking.entity.BookPickGood;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookPickGoodService {

    @Autowired
    BookPickGoodResponsity bookPickGoodResponsity;


    public BookPickGood save(BookPickGood bookPickGood) {
        BookPickGood bookPickGood1 = bookPickGoodResponsity.save(bookPickGood);
        return bookPickGood1;

    }
}
