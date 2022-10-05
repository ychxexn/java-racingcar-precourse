package racingcar.controller;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.model.RacingCar;
import racingcar.model.RacingCars;
import racingcar.util.Message;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingGame {

    private final RacingCars racingCars;
    private int repeatCount;

    public RacingGame() {
        this.racingCars = new RacingCars();
    }

    public void play() {
        inputRacingCarName();
        inputRepeatCount();
        OutputView.print(Message.RESULT.getMessage());
        for(int i=0; i<repeatCount; i++) {
            playRound();
            printRound();
            OutputView.printLine();
        }
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

    private void inputRepeatCount() {
        this.repeatCount = InputView.getRepeatCount();
    }

    private void playRound() {
        for(int i=0; i<racingCars.size(); i++) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            racingCars.get(i).moveOrNot(randomNumber);
        }
    }

    private void printRound() {
        for(int i=0; i< racingCars.size(); i++) {
            racingCars.get(i).printPosition();
        }
    }
}
