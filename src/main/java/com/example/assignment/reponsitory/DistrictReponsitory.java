package com.example.assignment.reponsitory;

import com.example.assignment.entity.District;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DistrictReponsitory extends JpaRepository<District, Integer> {
}
