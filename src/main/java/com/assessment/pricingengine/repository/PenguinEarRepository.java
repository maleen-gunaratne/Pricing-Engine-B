package com.assessment.pricingengine.repository;

import com.assessment.pricingengine.model.PenguinEar;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PenguinEarRepository extends JpaRepository<PenguinEar, Integer> {



}
