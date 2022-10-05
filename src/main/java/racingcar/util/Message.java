package racingcar.util;

public enum Message {
    INPUT_CAR("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)"),
    INPUT_REPEAT_COUNT("시도할 회수는 몇회인가요?"),
    ERROR_LENGTH_OF_CAR_NAME("자동차 이름은 5자 이하로만 설정 가능합니다.");

    private final String message;

    Message(String message) {
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }
}
