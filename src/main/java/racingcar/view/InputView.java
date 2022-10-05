package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.util.Message;

public class InputView {
    public static String getCarNames() {
        System.out.println(Message.INPUT_CAR.getMessage());
        return Console.readLine();
    }

    public static int getRepeatCount() {
        System.out.println(Message.INPUT_REPEAT_COUNT.getMessage());
        String input = Console.readLine();

        return Integer.parseInt(input);
    }
}
