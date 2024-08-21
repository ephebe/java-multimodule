package com.acme.core.specifications;

import org.junit.jupiter.api.Test;
import org.springframework.util.Assert;

public class SpecificationTest {
    @Test
    public void SimpleTitleTest() {
        Car car = new Car();
        car.setTitle("Benz");

        MustBenzSpec mustBenzSpec =  new MustBenzSpec();
        Assert.isTrue(mustBenzSpec.test(car),"Must Benz");
    }

    @Test
    public void SimpleWeightTest() {
        Car car = new Car();
        car.setWeight(960);

        LessThan1000KgSpec lessThan1000KgSpec =  new LessThan1000KgSpec();
        Assert.isTrue(lessThan1000KgSpec.test(car),"少於1000公斤");
    }

    @Test
    public void SimplePowerTest() {
        Car car = new Car();
        car.setPower(2001);

        GreateThan2000Spec greateThan2000Spec =  new GreateThan2000Spec();
        Assert.isTrue(greateThan2000Spec.test(car),"大於2000馬力");
    }

    @Test
    public void ConjunctionTest() {
        Car car = new Car();
        car.setTitle("Benz");
        car.setWeight(990);

        AbstractSpecification<Car> spec = new MustBenzSpec().and(new LessThan1000KgSpec());
        Assert.isTrue(spec.test(car),"是Benz且少於1000Kg");
    }

    @Test
    public void DisjunctionTest() {
        Car car = new Car();
        car.setTitle("BMW");
        car.setWeight(990);

        AbstractSpecification<Car> spec = new MustBenzSpec().or(new LessThan1000KgSpec());
        Assert.isTrue(spec.test(car),"是Benz或少於1000Kg");
    }

    @Test
    public void NegationTest() {
        Car car = new Car();
        car.setTitle("BMW");

        AbstractSpecification<Car> spec = new MustBenzSpec().not();
        Assert.isTrue(spec.test(car),"不是Benz");
    }

    @Test
    public void AndTest() {
        Car car = new Car();
        car.setTitle("Benz");
        car.setPower(2600);

        AbstractSpecification<Car> spec = new MustBenzSpec().and(new GreateThan2000Spec());
        Assert.isTrue(spec.test(car),"是Benz且馬力大於2000");

        car.setTitle("BMW");
        Assert.isTrue(spec.test(car),"要是Benz且馬力大於2000");
    }
}
