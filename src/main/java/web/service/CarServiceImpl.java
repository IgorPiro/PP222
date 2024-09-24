package web.service;

import org.springframework.stereotype.Component;
import web.model.Car;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class CarServiceImpl implements CarService {

    private List<Car> cars;

    public CarServiceImpl() {

        cars = new ArrayList<Car>();
        cars.add(new Car(1989, "Volkswagen", "Golf"));
        cars.add(new Car(1986, "Mercedes-Benz", "W123"));
        cars.add(new Car(1986, "Audi", "s1"));
        cars.add(new Car(1971, "Fiat", "127"));
        cars.add(new Car(1980, "Lancia", "Delta"));

    }

    @Override
    public List<Car> getCars(Integer count) {
        if (count == null || count < 0) {
            throw new IllegalArgumentException("Count cannot be null or negative.");
        } else if (count >= 5) {
            return cars;
        } else {
            return cars.stream()
                    .limit(count)
                    .collect(Collectors.toList());
        }
    }
}