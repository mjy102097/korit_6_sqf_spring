package com.study.rest.controller;

import com.study.rest.entity.Car;
import com.study.rest.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class CarController {

    @Autowired
    private CarService carService;


    @ResponseBody // @ResponseBody 가 JSON 형식으로 웹페이지에 출력
    @GetMapping("/car")
    public Car getCar(@RequestParam String model) {
        return carService.getCar(model);
    }
}

/**
 *  요청 GET - /car?model=K5 or 쏘나타
 *  Car (Entity)       -> model, color
 *
 *  CarRepository   -> Car findCarByMode(String model)
 *      -> List<Car>
 *          -> index0 : Car(model: "쏘나타", color: "화이트")
 *          -> index1 : Car(model: "K5", color: "블랙")
 *
 *  CarService      -> Car getCar(String model)
 *
 *  CarController   -> Car getCar(@RequestParam String model)
 *
 *  의존관계 (의존성 없는것 부터 만들면 됨)
 *  CarController > CarService > CarRepository
 */