package com.revature.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.revature.model.BatchAnnotation;

public interface BatchRepository extends CrudRepository<BatchAnnotation, Integer> {
//	@Query
//	List<BatchAnnotation> findById (@Param(value = "batchId") int batchId);
}
