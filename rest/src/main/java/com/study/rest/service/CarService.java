package com.study.rest.service;

import com.study.rest.entity.Car;
import com.study.rest.repository.CarRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CarService {

    // final -> 상수: 무조건 한번은 초기화를 해줘야 한다.
    // carRepository의 주소값이 변하면 안돼서 상수로 만들어줌.
    private final CarRepository carRepository;

    // 만약 @Autowired 를 쓰지 않는다면 생성자를 만들어서 매개변수로 값을 받아 초기화 해줘야 한다.
    // 생성자
    public CarService(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    public Car getCar(String model) {
        return carRepository.findCarByModel(model);
    }
}
