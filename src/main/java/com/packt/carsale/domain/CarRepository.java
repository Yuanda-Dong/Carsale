package com.packt.carsale.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

// import org.springframework.data.jpa.repository.Query;

// @RepositoryRestResource(path = "vehicles")
@RepositoryRestResource
public interface CarRepository extends CrudRepository<Car,Long>{

    List<Car> findByBrand(@Param("brand") String brand);

    List<Car> findByColor(@Param("brand") String color);

    List<Car> findByModelYear(int modelYear);

    List<Car> findByBrandAndModel(String brand, String model);

    List<Car> findByBrandOrColor(String brand, String color);

    List<Car> findByBrandOrderByModelYearAsc(String brand);


    // @Query("select c from Car c where c.brand = ?1")
    // List<Car> findByBrand(String brand);
    
}
