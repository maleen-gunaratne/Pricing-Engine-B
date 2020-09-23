package com.assessment.pricingengine.controller;

import com.assessment.pricingengine.exception.RecordNotFoundException;
import com.assessment.pricingengine.model.HorseShore;
import com.assessment.pricingengine.model.PenguinEar;
import com.assessment.pricingengine.services.PricingService;
//import net.minidev.json.JSONArray;
//import net.minidev.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.json.JSONArray;

@RestController      //
@RequestMapping("/api")
public class PricingController {

    @Autowired
    private PricingService pricingService;


    @GetMapping("/getTableData")
    public String getTableData() throws RecordNotFoundException {

        JSONObject penguine_obj = new JSONObject();
        JSONObject horseShore_obj = new JSONObject();
        JSONArray jsonArrayouter = new JSONArray();
        JSONArray penguinPriceArray = new JSONArray();
        JSONArray penguinNumberOfUnitsArray = new JSONArray();
        JSONArray horseShorepriceArray = new JSONArray();
        JSONArray horseShoreNumberOfUnitsArray = new JSONArray();

        for(int i=0;i<50;i++){
            penguinNumberOfUnitsArray .put(new String(String.valueOf(i+1)));
            penguinPriceArray.put( new Double(CalculatePenguinEarsPrice(i+1)));

        }

        for(int i=0;i<50;i++){
            horseShoreNumberOfUnitsArray .put(new String(String.valueOf(i+1)));
            horseShorepriceArray.put( new Double(CalculateHourseShorePrice(i+1)));
        }

        try {
            penguine_obj.put("productName", "penguine-ears");
            penguine_obj.put("units", penguinNumberOfUnitsArray);
            penguine_obj.put("price", penguinPriceArray);

            horseShore_obj.put("productName", "Horse-shoe");
            horseShore_obj.put("units", horseShoreNumberOfUnitsArray);
            horseShore_obj.put("price", horseShorepriceArray);

        } catch (JSONException e) {
            e.printStackTrace();
        }

        jsonArrayouter.put(penguine_obj);
        jsonArrayouter.put(horseShore_obj);

        return jsonArrayouter.toString();

    }

    @GetMapping("/getPenguinEarsPrice/{noOfUnits}")
    public double get_penguin_ears_price(@PathVariable Integer noOfUnits) throws RecordNotFoundException {

        return CalculatePenguinEarsPrice(noOfUnits);

    }

    @GetMapping("/getHorseShoresPrice/{noOfUnits}")
    public double get_horse_shore_price(@PathVariable Integer noOfUnits) throws RecordNotFoundException {

        return CalculateHourseShorePrice(noOfUnits);

    }

    int numofPenguinEarsCartoons=0;
    int numofHorseShoreCartoons=0;
    int numofUnitsPenguinEars=0;
    int numofUnitsHorseShore=0;
    int cartoonPrice =0;
    double unitPrice =0;

    private double CalculateHourseShorePrice(int noOfUnits)throws RecordNotFoundException {

        HorseShore horseShore = pricingService.getHorseShore();

        cartoonPrice =horseShore.getCartoonPrice();
        unitPrice = horseShore.getUnitPrice();

        if(noOfUnits%5==0){

            numofHorseShoreCartoons  =  noOfUnits/5 ;

            if(numofHorseShoreCartoons>=3){
                return (cartoonPrice*0.9*numofHorseShoreCartoons);
            }

            return (cartoonPrice*numofHorseShoreCartoons);

        }else if(noOfUnits>5){
            numofHorseShoreCartoons = (Integer)noOfUnits/5;
            numofUnitsHorseShore =noOfUnits%5;

            if(numofHorseShoreCartoons>=3){
                return (0.9*(cartoonPrice*numofHorseShoreCartoons )+(numofUnitsHorseShore*unitPrice));
            }
            return (cartoonPrice*numofHorseShoreCartoons )+(numofUnitsHorseShore*unitPrice);

        }else{

            return noOfUnits *unitPrice;
        }
    }


    private double CalculatePenguinEarsPrice(int noOfUnits) throws RecordNotFoundException {

        PenguinEar  penguinEar = pricingService.getPenguinEar();

        cartoonPrice =penguinEar.getCartoonPrice();
        unitPrice = penguinEar.getUnitPrice();


        if(noOfUnits%20==0){

            numofPenguinEarsCartoons  =  noOfUnits/20 ;

            if(numofPenguinEarsCartoons>=3){
                return (cartoonPrice*0.9*numofPenguinEarsCartoons);
            }
            return (cartoonPrice*numofPenguinEarsCartoons);

        }else if(noOfUnits>20){

            numofPenguinEarsCartoons = (Integer)noOfUnits/20;
            numofUnitsPenguinEars = noOfUnits % 20;

            if(numofPenguinEarsCartoons>=3){
                return 0.9*((cartoonPrice*numofPenguinEarsCartoons )+(numofUnitsPenguinEars*unitPrice));
            }
            return ((cartoonPrice*numofPenguinEarsCartoons )+(numofUnitsPenguinEars*unitPrice));

        }else{

            return noOfUnits *unitPrice;
        }

    }
}
