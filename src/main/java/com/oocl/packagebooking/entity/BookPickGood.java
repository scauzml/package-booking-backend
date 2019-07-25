package com.oocl.packagebooking.entity;


import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "book_pick_good")
public class BookPickGood {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private  int id;
    @Column(name = "good_id")
    private String goodId;
    @Column(name = "local_date_time")
    private LocalDateTime loaclDateTime;

    public BookPickGood() {
    }

    public BookPickGood(int id, String goodId, LocalDateTime loaclDateTime) {
        this.id = id;
        this.goodId = goodId;
        this.loaclDateTime = loaclDateTime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getGoodId() {
        return goodId;
    }

    public void setGoodId(String goodId) {
        this.goodId = goodId;
    }

    public LocalDateTime getLoaclDateTime() {
        return loaclDateTime;
    }

    public void setLoaclDateTime(LocalDateTime loaclDateTime) {
        this.loaclDateTime = loaclDateTime;
    }
}
