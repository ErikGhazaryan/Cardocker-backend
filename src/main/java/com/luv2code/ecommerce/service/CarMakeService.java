package com.luv2code.ecommerce.service;

import com.luv2code.ecommerce.dto.CarMake;
import org.springframework.data.domain.Page;

import java.math.BigDecimal;

public interface CarMakeService {

    public Page<CarMake> getCars(int pageNumber, int pageSize);

    public CarMake getCar(long id);

    Page<CarMake> carMakesWithCriteria(
                                       Integer pageNumber,
                                       Integer pageSize,
                                       Long carMakeIdMin,
                                       Long carMakeIdMax,
                                       Long carBodyStyleMin,
                                       Long carBodyStyleMax,
                                       BigDecimal carPriceMin,
                                       BigDecimal carPriceMax,
                                       Integer carYearOfProductionFrom,
                                       Integer carYearOfProductionTil);
}
