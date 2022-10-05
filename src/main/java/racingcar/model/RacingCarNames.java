package racingcar.model;

import racingcar.util.Message;
import racingcar.util.RacingGameUtil;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class RacingCarNames {
    private final String[] names;

    public RacingCarNames(String names) {
        this.names = names.split(",");
        checkEmpty();
        checkBlank();
        checkDuplicate();
    }

    private void checkEmpty() {
        if(names.length < 2) {
            throw new IllegalArgumentException(Message.ERROR_MORE_THAN_TWO.getMessage());
        }
    }

    private void checkBlank() {
        for(String name : names) {
            checkBlankOrEmpty(name);
            checkLength(name);
        }
    }

    private void checkBlankOrEmpty(String name) {
        if(!name.equals(name.trim()) || name.length() == 0) {
            throw new IllegalArgumentException(Message.ERROR_CANNOT_INCLUDE_BLANK.getMessage());
        }
    }

    private void checkLength(String name) {
        if(name.length() > RacingGameUtil.MAX_LENGTH_OF_CAR_NAME) {
            throw new IllegalArgumentException(Message.ERROR_LENGTH_OF_CAR_NAME.getMessage());
        }
    }

    private void checkDuplicate() {
        Set<String> set = new HashSet<>();
        Collections.addAll(set, names);
        if(set.size() != names.length) {
            throw new IllegalArgumentException(Message.ERROR_DUPLICATE_OF_CAR_NAME.getMessage());
        }
    }

    public String[] getNames() {
        return names;
    }
}
