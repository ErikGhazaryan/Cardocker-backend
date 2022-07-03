package com.luv2code.ecommerce.dao;

import com.luv2code.ecommerce.entity.BodyStyle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin
@RepositoryRestResource(collectionResourceRel = "bodystyles", path="bodystyles")
public interface  BodyStyleRepository extends JpaRepository<BodyStyle,Long> {

public BodyStyle findByBodyStyleName(String bodyStyleName);

}
