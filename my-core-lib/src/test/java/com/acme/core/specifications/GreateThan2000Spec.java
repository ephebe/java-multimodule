package com.acme.core.specifications;

public class GreateThan2000Spec extends AbstractSpecification<Car> {
    @Override
    public boolean test(Car car) {
        return car.getPower() > 2000;
    }
}
