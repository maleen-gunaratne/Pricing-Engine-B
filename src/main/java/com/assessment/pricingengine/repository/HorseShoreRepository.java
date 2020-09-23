package com.assessment.pricingengine.repository;

import com.assessment.pricingengine.model.HorseShore;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface HorseShoreRepository  extends JpaRepository<HorseShore, Integer> {




}
