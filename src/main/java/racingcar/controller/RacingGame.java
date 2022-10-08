package racingcar.controller;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.model.RacingCar;
import racingcar.model.RacingCarNames;
import racingcar.model.RacingCars;
import racingcar.model.Round;
import racingcar.util.Message;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingGame {

    private final RacingCars racingCars;
    private RacingCars winners;
    private Round round;

    public RacingGame() {
        this.racingCars = new RacingCars();
        this.winners = new RacingCars();
    }

    public void play() {
        inputRacingCarName();
        inputRound();
        OutputView.print(Message.RESULT.getMessage());
        for(int i=0; i<round.getRound(); i++) {
            playRound();
            printRound();
            OutputView.printLine();
        }
        calculateResult();
        printResult();
    }

    private void inputRacingCarName() {
        try {
            RacingCarNames racingCarNames = new RacingCarNames(InputView.getCarNames());
            racingCars.add(racingCarNames.getNames());
        }catch (IllegalArgumentException e) {
            OutputView.print(e.getMessage());
            inputRacingCarName();
        }
    }

    private void inputRound() {
        try {
            this.round = new Round(InputView.getRound());
        }catch (IllegalArgumentException e) {
            OutputView.print(e.getMessage());
            inputRound();
        }
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

        for(int i=0; i<racingCars.size(); i++) {
            RacingCar racingCar = racingCars.get(i);
            maxPosition = getMaxPositionAndInitWinnerList(racingCar, maxPosition);
            addWinner(racingCar, maxPosition);
        }
    }

    private int getMaxPositionAndInitWinnerList(RacingCar racingCar, int maxPosition) {
        if(racingCar.getPosition() > maxPosition) {
            winners = new RacingCars();
            return racingCar.getPosition();
        }

        return maxPosition;
    }

    private void addWinner(RacingCar racingCar, int maxPosition) {
        if(racingCar.getPosition() == maxPosition) {
            winners.add(racingCar);
        }
    }

    private void printResult() {
        OutputView.print(String.format(Message.WINNER.getMessage(), winners.toString()));
    }
}
