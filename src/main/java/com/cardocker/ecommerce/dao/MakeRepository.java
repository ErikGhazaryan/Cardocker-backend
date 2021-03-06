package com.cardocker.ecommerce.dao;

import com.cardocker.ecommerce.entity.Make;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin
@RepositoryRestResource(collectionResourceRel = "makes", path="makes")
public interface MakeRepository extends JpaRepository<Make, Long> {
    public Make findByMakeName(String makeName);
}
