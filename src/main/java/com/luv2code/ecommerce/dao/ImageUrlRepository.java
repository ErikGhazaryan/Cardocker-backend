package com.luv2code.ecommerce.dao;

import com.luv2code.ecommerce.entity.ImageUrl;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
@CrossOrigin
@RepositoryRestResource(collectionResourceRel = "imageUrls", path="imageUrls")
public interface ImageUrlRepository extends JpaRepository<ImageUrl, Long> {
    List<ImageUrl> findByCarId(@RequestParam("id") Long id);
}
