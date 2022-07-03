package com.luv2code.ecommerce.controller;

import com.luv2code.ecommerce.dto.CarMake;
import com.luv2code.ecommerce.service.CarMakeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@RestController
public class CarMakeController {

    @Autowired
    CarMakeService carMakeService;



    @GetMapping("/api/carsmakes")
    public Page<CarMake> carMake(@Param("pageNumber") int pageNumber, @Param("pageSize") int pageSize){
        return carMakeService.getCars(pageNumber, pageSize);
    }

    @GetMapping("/api/carsmakes/{id}")
    public CarMake carMakeProduct(@PathVariable("id") long id){

        return carMakeService.getCar(id);

    }

    @GetMapping("/api/carforsale")
    public String getfunction(){
        return "hopla";
    }



    @GetMapping("/api/carsmakes/findByPriceAndMakeId")
    public Page<CarMake> carMakesWithCriteria(
                                              @Param("pageNumber") Integer pageNumber,
                                              @Param("pageSize") Integer pageSize,
                                              @Param("carMakeIdMin") Long carMakeIdMin,
                                              @Param("carMakeIdMax") Long carMakeIdMax,
                                              @Param("carBodyStyleMin") Long carBodyStyleMin,
                                              @Param("carBodyStyleMax") Long carBodyStyleMax,
                                              @Param("carPriceMin") BigDecimal carPriceMin,
                                              @Param("carPriceMax") BigDecimal carPriceMax,
                                              @Param("carYearOfProductionFrom") Integer carYearOfProductionFrom,
                                              @Param("carYearOfProductionTill") Integer carYearOfProductionTill
                                              ){
        System.out.println();
        System.out.println("Writing the data");
        System.out.println("pageNumber: "+pageNumber);
        System.out.println("pageSize: "+pageSize);
        System.out.println("carMakeIdMin: "+carMakeIdMin);
        System.out.println("carMakeIdMax: "+carMakeIdMax);
        System.out.println("carBodyStyleMin: "+carBodyStyleMin);
        System.out.println("carBodyStyleMax: "+carBodyStyleMax);
        System.out.println("carPriceMin: "+carPriceMin);
        System.out.println("carPriceMax: "+carPriceMax);
        System.out.println("carPriceMax: "+carYearOfProductionFrom);
        System.out.println("carPriceMax: "+carYearOfProductionTill);
        System.out.println();


        return carMakeService.carMakesWithCriteria(
                                                    pageNumber,
                                                    pageSize,
                                                    carMakeIdMin,
                                                    carMakeIdMax,
                                                    carBodyStyleMin,
                                                    carBodyStyleMax,
                                                    carPriceMin,
                                                    carPriceMax,
                                                    carYearOfProductionFrom,
                                                    carYearOfProductionTill);
    }

}
