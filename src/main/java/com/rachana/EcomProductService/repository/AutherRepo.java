package com.rachana.EcomProductService.repository;

import com.rachana.EcomProductService.demo.Auther;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AutherRepo extends JpaRepository<Auther,Integer> {
}