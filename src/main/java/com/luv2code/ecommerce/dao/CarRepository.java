package com.luv2code.ecommerce.dao;


import com.luv2code.ecommerce.entity.BodyStyle;
import com.luv2code.ecommerce.entity.Car;
import com.luv2code.ecommerce.entity.Make;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@CrossOrigin
@RepositoryRestResource(collectionResourceRel = "cars", path="cars")
public interface CarRepository extends JpaRepository<Car, Long> {

    Page<Car> findByMakeId(Long carMakeId, Pageable pageable);

    List<Car> findByMakeIdAndPriceBetween(Long carMakeId, BigDecimal carPriceMin, BigDecimal carPriceMax);

    Page<Car> findByMakeIdBetweenAndBodyStyleIdBetweenAndPriceBetweenAndYearOfProductionBetween(Long carMakeIdMin,
                                                                                                Long carMakeIdMax,
                                                                                                Long carBodyStyleMin,
                                                                                                Long carBodyStyleMax,
                                                                                                BigDecimal carPriceMin,
                                                                                                BigDecimal carPriceMax,
                                                                                                LocalDate carYearOfProductionFrom,
                                                                                                LocalDate carYearOfProductionTill,
                                                                                                Pageable pageable);

    Page<Car> findAll(Pageable pageable);

    BodyStyle findByBodyStyleBodyStyleName(String bodyStyleName);

    Make findByMakeMakeName(String makeName);
}
