package com.acme.core.specifications;

public class LessThan1000KgSpec extends AbstractSpecification<Car> {
    @Override
    public boolean test(Car car) {
        return car.getWeight() <= 1000;
    }
}
