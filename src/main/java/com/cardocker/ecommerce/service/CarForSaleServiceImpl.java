package com.cardocker.ecommerce.service;

import com.cardocker.ecommerce.dao.CarRepository;
import com.cardocker.ecommerce.dao.ImageUrlRepository;
import com.cardocker.ecommerce.dao.BodyStyleRepository;
import com.cardocker.ecommerce.dao.MakeRepository;
import com.cardocker.ecommerce.dto.CarMake;
import com.cardocker.ecommerce.entity.Car;
import com.cardocker.ecommerce.entity.ImageUrl;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CarForSaleServiceImpl implements CarForSaleService {

    private CarRepository carRepository;
    private BodyStyleRepository bodyStyleRepository;
    private MakeRepository makeRepository;
    private ImageUrlRepository imageUrlRepository;

    public CarForSaleServiceImpl(ImageUrlRepository imageUrlRepository, MakeRepository makeRepository, CarRepository carRepository, BodyStyleRepository bodyStyleRepository) {
        this.imageUrlRepository = imageUrlRepository;
        this.carRepository = carRepository;
        this.bodyStyleRepository = bodyStyleRepository;
        this.makeRepository = makeRepository;
    }

    @Override
    public String save(CarMake carMake) {
        Car car = new Car();
        car.setSeats(carMake.getSeats());
        car.setModelName(carMake.getModelName());
        car.setPrice(carMake.getPrice());
        car.setBodyStyle(bodyStyleRepository.findByBodyStyleName(carMake.getBodyStyle()));
        car.setMake(makeRepository.findByMakeName(carMake.getMakeName()));

        car.setSellerDescription(carMake.getSellerDescription());
        car.setYearOfProduction(carMake.getYearOfProduction());
        System.out.println("printing data from car");
        System.out.println(car);
        System.out.println("end of printing");

     //   System.out.println("myCar.getId(): "+myCar.getId());
        ImageUrl imageUrl = new ImageUrl();
        imageUrl.setImageUrlString(carMake.getImageUrl());
        List<ImageUrl> imageUrlList = new ArrayList<ImageUrl>();
        imageUrl.setCar(car);
        imageUrlList.add(imageUrl);
        car.setImageUrl(imageUrlList);
        Car myCar = carRepository.save(car);
        List<ImageUrl> imageUrlList1 = myCar.getImageUrl();

        //this.imageUrlRepository.save(imageUrl);
        return "this is string back";
    }
}
