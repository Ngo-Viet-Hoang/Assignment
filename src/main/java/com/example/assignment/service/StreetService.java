package com.example.assignment.service;

import com.example.assignment.entity.District;
import com.example.assignment.entity.Street;
import com.example.assignment.reponsitory.StreetReponsitory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StreetService {
    @Autowired
    StreetReponsitory streetReponsitory;

    public List<Street> findAll() {
        return streetReponsitory.findAll();
    }

    public Optional<Street> findById(Integer id) {
        return streetReponsitory.findById(id);
    }

    public Street save(Street stock) {
        return streetReponsitory.save(stock);
    }

    public void deleteById(Integer id) {
        streetReponsitory.deleteById(id);
    }
}
