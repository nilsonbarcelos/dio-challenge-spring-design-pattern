package com.study.newcar.controller;

import com.study.newcar.model.Car;
import com.study.newcar.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/car")
public class CarRestController {

    @Autowired
    private CarService carService;

    @PostMapping
    public ResponseEntity<Car> save(@RequestBody Car car) {
        return ResponseEntity.ok(carService.save(car));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Car> update(@PathVariable Long id, @RequestBody Car car) {
        return ResponseEntity.ok(carService.update(id, car));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        carService.delete(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Car> findById(@PathVariable Long id) {
        return ResponseEntity.ok(carService.findById(id));
    }

    @GetMapping
    public ResponseEntity<Iterable<Car>> findAll() {
        return ResponseEntity.ok(carService.findAll());
    }
}
