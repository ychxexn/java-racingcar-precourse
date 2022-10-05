package racingcar.util;

public enum Message {
    ERROR_LENGTH_OF_CAR_NAME("자동차 이름은 5자 이하로만 설정 가능합니다.");

    private final String message;

    Message(String message) {
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }
}
