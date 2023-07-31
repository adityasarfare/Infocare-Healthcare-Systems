package com.javaguides.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.javaguides.model.CalculatedResult;

@Repository
public interface CalculatedResultRepository extends JpaRepository<CalculatedResult, Long> {
}
