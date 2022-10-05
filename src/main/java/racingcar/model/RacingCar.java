package racingcar.model;

import racingcar.util.Message;
import racingcar.util.RacingGameUtil;

public class RacingCar {

    private final String name;

    public RacingCar(String name) {
        if(!isValidLengthOfName(name)){
            throw new IllegalArgumentException(Message.ERROR_LENGTH_OF_CAR_NAME.getMessage());
        }

        this.name = name;
    }
    private boolean isValidLengthOfName(String name) {
        return name.length() <= RacingGameUtil.MAX_LENGTH_OF_CAR_NAME;
    }
}
