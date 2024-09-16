package com.study.newcar.service;

import com.study.newcar.model.FipeBrand;
import com.study.newcar.model.FipeCar;
import com.study.newcar.model.FipeModeloResponse;
import com.study.newcar.model.FipeYear;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "fipe", url = "https://parallelum.com.br/fipe/api/v1/carros")
public interface FipeService {

    @GetMapping("/marcas")
    List<FipeBrand> getBrands();

    @GetMapping("/marcas/{codigo}/modelos")
    FipeModeloResponse getModels(@PathVariable("codigo") String codigo);

    @GetMapping("/marcas/{codigo}/modelos/{anoModelo}/anos")
    List<FipeYear> getCarYears(@PathVariable("codigo") String codigo,
                           @PathVariable("anoModelo") String anoModelo);

    @GetMapping("/marcas/{codigo}/modelos/{anoModelo}/anos/{ano}")
    FipeCar getFipeCar(@PathVariable("codigo") String codigo,
                        @PathVariable("anoModelo") String anoModelo,
                        @PathVariable("ano") String ano);
}
