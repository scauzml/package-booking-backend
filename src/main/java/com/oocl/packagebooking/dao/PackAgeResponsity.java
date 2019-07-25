package com.oocl.packagebooking.dao;

import com.oocl.packagebooking.entity.PackAge;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PackAgeResponsity extends JpaRepository<PackAge,Integer> {

    List<PackAge> findByState(String state);
}
