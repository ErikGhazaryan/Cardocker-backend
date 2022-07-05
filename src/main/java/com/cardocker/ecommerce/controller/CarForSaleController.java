package com.cardocker.ecommerce.controller;

import com.cardocker.ecommerce.service.CarForSaleService;
import com.cardocker.ecommerce.dto.CarMake;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CarForSaleController {

    private CarForSaleService carForSaleService;


    public CarForSaleController(CarForSaleService carForSaleService) {
        this.carForSaleService = carForSaleService;
    }

    @PostMapping("/api/carforsale")
    public String addCarForSale(@RequestBody CarMake carMake){
        System.out.println("in carForSaleController");
        System.out.println("carPost.getMake(): "+ carMake.getMakeName());
        System.out.println("carPost.getPrice(): "+carMake.getPrice());
        System.out.println("carMake.getSeats(): "+carMake.getSeats());
        System.out.println("carMake.getYearofProduction: "+carMake.getYearOfProduction());
        System.out.println("carMake.getBodyStyle: "+carMake.getBodyStyle());
        System.out.println("carMake.getSellerDescription()"+carMake.getSellerDescription());
        System.out.println(carMake.getSellerDescription());
        System.out.println("carMake.getImageUrl: "+carMake.getImageUrl());


        String idString = this.carForSaleService.save(carMake);
        return null;
    }


/*
    @GetMapping("/api/carforsale")
    public String getfunction(){

        return "hopla";
    }


 */


}
