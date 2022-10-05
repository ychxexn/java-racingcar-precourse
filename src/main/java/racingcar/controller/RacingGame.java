package racingcar.controller;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.model.RacingCar;
import racingcar.model.RacingCarNames;
import racingcar.model.RacingCars;
import racingcar.util.Message;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.ArrayList;
import java.util.List;

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
        calculateResult();
    }

    private void inputRacingCarName() {
        try {
            RacingCarNames racingCarNames = new RacingCarNames(InputView.getCarNames());
            saveRacingCarName(racingCarNames.getNames());
        }catch (IllegalArgumentException e) {
            OutputView.print(e.getMessage());
            inputRacingCarName();
        }
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

    private void calculateResult() {
        int maxPosition = 0;
        List<String> winnerList = new ArrayList<>();

        for(int i=0; i<racingCars.size(); i++) {
            RacingCar racingCar = racingCars.get(i);
            maxPosition = getMaxPositionAndInitWinnerList(winnerList, racingCar, maxPosition);
            addWinner(winnerList, racingCar, maxPosition);
        }

        printResult(winnerList);
    }

    private int getMaxPositionAndInitWinnerList(List<String> winnerList, RacingCar racingCar, int maxPosition) {
        if(racingCar.getPosition() > maxPosition) {
            winnerList.clear();
            return racingCar.getPosition();
        }

        return maxPosition;
    }

    private void addWinner(List<String> winnerList, RacingCar racingCar, int maxPosition) {
        if(racingCar.getPosition() == maxPosition) {
            winnerList.add(racingCar.getName());
        }
    }

    private void printResult(List<String> winnerList) {
        String winners = winnerList.toString();
        OutputView.print(String.format(Message.WINNER.getMessage(), winners.substring(1, winners.length()-1)));
    }
}
