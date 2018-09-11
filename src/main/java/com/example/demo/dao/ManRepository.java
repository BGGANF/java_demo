package com.example.demo.dao;
import com.example.demo.domain.*;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ManRepository extends JpaRepository<ManEntity,Integer> {
}
