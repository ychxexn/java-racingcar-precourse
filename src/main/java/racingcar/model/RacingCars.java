package racingcar.model;

import java.util.ArrayList;
import java.util.List;

public class RacingCars {
    private final List<RacingCar> racingCars;

    public RacingCars() {
        this.racingCars = new ArrayList<>();
    }

    public void add(String[] carNames) {
        for(String carName : carNames) {
            racingCars.add(new RacingCar(carName));
        }
    }

    public RacingCar get(int index) {
        return racingCars.get(index);
    }

    public int size() {
        return racingCars.size();
    }
}
