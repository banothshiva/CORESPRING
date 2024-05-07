package com.web.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.web.entity.Electricity;
@Repository
public interface ElectricityRepo extends JpaRepository<Electricity, Integer> {

}
