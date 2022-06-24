package com.example.assignment.service;

import com.example.assignment.entity.District;
import com.example.assignment.reponsitory.DistrictReponsitory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class DistrictService {
    @Autowired
    DistrictReponsitory districtReponsitory;

    public List<District> findAll() {
        return districtReponsitory.findAll();
    }

    public Optional<District> findById(Integer id) {
        return districtReponsitory.findById(id);
    }

    public District save(District stock) {
        return districtReponsitory.save(stock);
    }

    public void deleteById(Integer id) {
        districtReponsitory.deleteById(id);
    }
}
