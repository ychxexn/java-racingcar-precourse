package racingcar.controller;

import racingcar.model.RacingCar;
import racingcar.model.RacingCars;
import racingcar.view.InputView;

public class RacingGame {

    private final RacingCars racingCars;

    public RacingGame() {
        this.racingCars = new RacingCars();
    }

    public void play() {
        inputRacingCarName();
    }

    private void inputRacingCarName() {
        String input = InputView.getCarNames();
        saveRacingCarName(input.split(","));
    }

    private void saveRacingCarName(String[] arrCarName) {
        for(String carName : arrCarName) {
            RacingCar newRacingCar = new RacingCar(carName);
            racingCars.add(newRacingCar);
        }
    }
}
