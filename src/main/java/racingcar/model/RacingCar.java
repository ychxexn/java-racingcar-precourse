package racingcar.model;

import racingcar.util.Message;
import racingcar.util.RacingGameUtil;
import racingcar.view.OutputView;

public class RacingCar {

    private final String name;

    private int position;

    public RacingCar(String name) {
        if(!isValidLengthOfName(name)){
            throw new IllegalArgumentException(Message.ERROR_LENGTH_OF_CAR_NAME.getMessage());
        }

        this.name = name;
        this.position = 0;
    }
    private boolean isValidLengthOfName(String name) {
        return name.length() <= RacingGameUtil.MAX_LENGTH_OF_CAR_NAME;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public void moveOrNot(int number) {
        if(number >= RacingGameUtil.MOVABLE_NUMBER) {
            position++;
        }
    }

    public void printPosition() {
        StringBuilder sb = new StringBuilder();

        sb.append(getName());
        sb.append(" : ");
        for(int i=0; i<getPosition(); i++) {
            sb.append("-");
        }

        OutputView.print(sb.toString());
    }
}
