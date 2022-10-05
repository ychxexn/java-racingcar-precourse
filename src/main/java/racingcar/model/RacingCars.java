package racingcar.model;

import java.util.ArrayList;
import java.util.List;

public class RacingCars {
    private final List<RacingCar> racingCars;

    public RacingCars() {
        this.racingCars = new ArrayList<>();
    }

    public void add(RacingCar racingCar) {
        racingCars.add(racingCar);
    }
}
