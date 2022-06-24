package com.example.assignment.reponsitory;

import com.example.assignment.entity.Street;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StreetReponsitory extends JpaRepository<Street,Integer> {
}
