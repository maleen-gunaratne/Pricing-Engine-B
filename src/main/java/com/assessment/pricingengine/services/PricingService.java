package com.assessment.pricingengine.services;

import com.assessment.pricingengine.exception.RecordNotFoundException;
import com.assessment.pricingengine.model.HorseShore;
import com.assessment.pricingengine.model.PenguinEar;
import com.assessment.pricingengine.repository.HorseShoreRepository;
import com.assessment.pricingengine.repository.PenguinEarRepository;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class PricingService {

    @Autowired
    HorseShoreRepository  horseShoreRepository;

    @Autowired
    PenguinEarRepository  penguinEarRepository;


    public PenguinEar getPenguinEar() throws RecordNotFoundException {

            Optional<PenguinEar> penguinEar = penguinEarRepository.findById(1);

            if(penguinEar.isPresent()) {
                return penguinEar.get();
            } else {
                throw new RecordNotFoundException("No employee record exist for given id");
            }
    }


    public HorseShore getHorseShore() throws RecordNotFoundException {

        Optional<HorseShore> horseShore = horseShoreRepository.findById(1);

        if(horseShore.isPresent()) {
            return horseShore.get();
        } else {
            throw new RecordNotFoundException("No employee record exist for given id");
        }
    }










}
