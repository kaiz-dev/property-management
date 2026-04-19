package com.property.poc.service.repository;

import com.property.poc.service.entity.PropertyEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface PropertyRepository extends JpaRepository<PropertyEntity, String> {
    boolean existsById(String id);
}
