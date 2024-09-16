package com.study.newcar.service.impl;

import com.study.newcar.exception.CarNotFoundException;
import com.study.newcar.model.*;
import com.study.newcar.service.CarService;
import com.study.newcar.service.FipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.List;

@Service
public class CarServiceImpl implements CarService {

    @Autowired
    private CarRepository carRepository;

    @Autowired
    private FipeService fipeService;

    @Override
    public Iterable<Car> findAll() {
        return carRepository.findAll();
    }

    private String getBrandCodeByName(String name) {
        List<FipeBrand> fipeBrands = fipeService.getBrands();
        for (FipeBrand fipeBrand : fipeBrands) {
            if (fipeBrand.getNome().equals(name)) {
                return fipeBrand.getCodigo();
            }
        }
        return null;
    }

    private String getModelCodeByName(String codigo, String name) {
        FipeModeloResponse fipeModels = fipeService.getModels(codigo);
        for (FipeModelo fipeModelo : fipeModels.getModelos()) {
            if (fipeModelo.getNome().contains(name)) {
                return fipeModelo.getCodigo();
            }
        }
        return null;
    }

    private String getYearByBrandAndModelCode(String brandCode, String modelCode, Integer year) {
        List<FipeYear> fipeYears = fipeService.getCarYears(brandCode, modelCode);
        for (FipeYear fipeYear : fipeYears) {
            if (fipeYear.getNome().contains(String.valueOf(year))) {
                return fipeYear.getCodigo();
            }
        }
        return null;
    }

    @Override
    public Car save(Car car) {
        String brandCode = getBrandCodeByName(car.getBrand());
        String modelCode = getModelCodeByName(brandCode, car.getName());
        String yearCode = getYearByBrandAndModelCode(brandCode, modelCode, car.getMadeYear());
        FipeCar fipeCar = fipeService.getFipeCar(brandCode, modelCode, yearCode);

        if (fipeCar != null) {
            car.setName(fipeCar.getModelo());
            car.setBrand(fipeCar.getMarca());
            car.setMadeYear(fipeCar.getAnoModelo());
            car.setGasType(fipeCar.getCombustivel());
            car.setPrice(fipeCar.getValor());
            return carRepository.save(car);
        }

        return null;
    }

    @Override
    public void delete(Long id) {
        carRepository.deleteById(id);
    }

    @Override
    public Car findById(Long id) {
        Optional<Car> carDb = carRepository.findById(id);
        return carDb.get();
    }


    @Override
    public Car update(Long id, Car car) {
        Car existingCar = carRepository.findById(id).orElseThrow(() ->
                new CarNotFoundException("Car not found"));
        existingCar.setBrand(car.getBrand());
        existingCar.setName(car.getName());
        existingCar.setMadeYear(car.getMadeYear());
        existingCar.setGasType(car.getGasType());
        existingCar.setPrice(car.getPrice());
        return carRepository.save(existingCar);
    }
}
