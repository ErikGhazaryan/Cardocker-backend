package com.luv2code.ecommerce.service;

import com.luv2code.ecommerce.dao.CarRepository;
import com.luv2code.ecommerce.dao.ImageUrlRepository;
import com.luv2code.ecommerce.dao.MakeRepository;
import com.luv2code.ecommerce.dto.CarMake;
import com.luv2code.ecommerce.entity.Car;
import com.luv2code.ecommerce.entity.ImageUrl;
import com.luv2code.ecommerce.entity.Make;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class CarMakeServiceImpl implements CarMakeService {

    @Autowired
    CarRepository carRepository;

    @Autowired

    MakeRepository makeRepository;

    @Autowired
    ImageUrlRepository imageUrlRepository;


    @Override
    public Page<CarMake> getCars(int pageNumber, int pageSize) {

        // List<Car> myCars = carRepository.findAll();

        Pageable pageable = PageRequest.of(pageNumber, pageSize);
        Page<Car> myCarsPage = carRepository.findAll(pageable);
        long totalSize = myCarsPage.getTotalElements();
        List<Car> myCars = myCarsPage.getContent();


        List<Make> myMakes = makeRepository.findAll();

        List<CarMake> carMakes = new ArrayList<>();

        for (int i = 0; i < myCars.size(); i++) {
            CarMake carMake = new CarMake();
            carMake.setPrice(myCars.get(i).getPrice());
            carMake.setSeats(myCars.get(i).getSeats());
            carMake.setId(myCars.get(i).getId());
            carMake.setYearOfProduction(myCars.get(i).getYearOfProduction());
            carMake.setMakeName(myCars.get(i).getMake().getMakeName());
            carMake.setImageUrl(myCars.get(i).getImageUrl().get(0).getImageUrlString());
            carMake.setBodyStyle(myCars.get(i).getBodyStyle().getBodyStyleName());
            carMake.setModelName(myCars.get(i).getModelName());
            carMakes.add(carMake);

        }
        Pageable pageableCarMake = PageRequest.of(pageNumber, pageSize);
        System.out.println("pageNumber: " + pageNumber);
        System.out.println("pageSize: " + pageSize);
        Page<CarMake> carMakePages = new PageImpl<>(carMakes, pageableCarMake, totalSize);

        return carMakePages;
    }

    @Override
    public CarMake getCar(long id) {

        Car car = carRepository.findById(id).get();
        List<ImageUrl> urlLists = imageUrlRepository.findByCarId(id);
        CarMake carMake = new CarMake();

        carMake.setMakeName(car.getMake().getMakeName());
        carMake.setSeats(car.getSeats());
        carMake.setPrice(car.getPrice());
        carMake.setId(car.getId());
        carMake.setYearOfProduction(car.getYearOfProduction());
        carMake.setSellerDescription(car.getSellerDescription());
        carMake.setBodyStyle(car.getBodyStyle().getBodyStyleName());
        carMake.setModelName(car.getModelName());
        return carMake;
    }

    @Override
    public Page<CarMake> carMakesWithCriteria(Integer pageNumber,
                                              Integer pageSize,
                                              Long carMakeIdMin,
                                              Long carMakeIdMax,
                                              Long carBodyStyleMin,
                                              Long carBodyStyleMax,
                                              BigDecimal carPriceMin,
                                              BigDecimal carPriceMax,
                                              Integer carYearOfProductionFrom,
                                              Integer carYearOfProductionTill) {


        LocalDate localCarYearOfProductionFrom = LocalDate.of(carYearOfProductionFrom, 1, 1);
        LocalDate localCarYearOfProductionTill = LocalDate.of(carYearOfProductionTill, 12, 31);
        Pageable pageable = PageRequest.of(pageNumber, pageSize);

        Page<Car> myCarsPage = carRepository.findByMakeIdBetweenAndBodyStyleIdBetweenAndPriceBetweenAndYearOfProductionBetween(
                carMakeIdMin,
                carMakeIdMax,
                carBodyStyleMin,
                carBodyStyleMax,
                carPriceMin,
                carPriceMax,
                localCarYearOfProductionFrom,
                localCarYearOfProductionTill,
                pageable);

        List<Car> myCars = myCarsPage.getContent();

        myCars.forEach(x -> System.out.println(x.getMake().getMakeName()));
        List<CarMake> carMakes = new ArrayList<>();

        for (int i = 0; i < myCars.size(); i++) {
            CarMake carMake = new CarMake();
            carMake.setPrice(myCars.get(i).getPrice());
            carMake.setSeats(myCars.get(i).getSeats());
            carMake.setId(myCars.get(i).getId());
            carMake.setYearOfProduction(myCars.get(i).getYearOfProduction());
            carMake.setMakeName(myCars.get(i).getMake().getMakeName());
            carMake.setImageUrl(myCars.get(i).getImageUrl().get(0).getImageUrlString());
            carMake.setBodyStyle(myCars.get(i).getBodyStyle().getBodyStyleName());
            carMake.setModelName(myCars.get(i).getModelName());
            carMakes.add(carMake);

        }
        Pageable pageableCarMake = PageRequest.of(pageNumber, pageSize);
        System.out.println("pageNumber: " + pageNumber);
        System.out.println("pageSize: " + pageSize);
        long totalSize = myCarsPage.getTotalElements();
        System.out.println("printing the cars");
        Page<CarMake> carMakePages = new PageImpl<>(carMakes, pageableCarMake, totalSize);
        System.out.println("End of printing the cars");

        return carMakePages;
    }


}
