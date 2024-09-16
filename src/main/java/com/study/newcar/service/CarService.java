package com.study.newcar.service;

import com.study.newcar.model.Car;

public interface CarService {

    Iterable<Car> findAll();
    Car save(Car car);
    void delete(Long id);
    Car findById(Long id);
    Car update(Long id, Car car);

}
