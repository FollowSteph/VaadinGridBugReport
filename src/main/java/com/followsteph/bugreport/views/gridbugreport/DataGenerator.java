package com.followsteph.bugreport.views.gridbugreport;

import java.util.List;

public class DataGenerator {

    public static List<Car> getListOfCars() {
        return List.of(
                new Car("Yellow Car", "This is a yellow car", 1000),
                new Car("Red Car", "This is a red car", 2000),
                new Car("Blue Car", "This is a blue car", 3000),
                new Car("Green Car", "This is a green car", 4000),
                new Car("Purple Car", "This is a purple car", 5000));
    }
}
