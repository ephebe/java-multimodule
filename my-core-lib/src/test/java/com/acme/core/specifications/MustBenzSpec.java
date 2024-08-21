package com.acme.core.specifications;

public class MustBenzSpec extends AbstractSpecification<Car> {
    @Override
    public boolean test(Car car) {
        return car.getTitle().equals("Benz");
    }
}
