package com.lewickiy.products.repository;

import com.lewickiy.products.model.Sex;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SexRepository extends JpaRepository<Sex, Integer> {
}
