package com.oocl.packagebooking.entity;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "pack_age")
public class PackAge {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private  int id;
   @Column(name = "customer_name")
    private String customerName;
    private String phone;
    private String state;
    @Column(name = "local_date_time")
    private LocalDateTime loaclDateTime;

    public PackAge() {

    }

    public PackAge(int id, String customerName, String phone, String state, LocalDateTime loaclDateTime) {
        this.id = id;
        this.customerName = customerName;
        this.phone = phone;
        this.state = state;
        this.loaclDateTime = loaclDateTime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public LocalDateTime getLoaclDateTime() {
        return loaclDateTime;
    }

    public void setLoaclDateTime(LocalDateTime loaclDateTime) {
        this.loaclDateTime = loaclDateTime;
    }
}
