package racingcar.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatNoException;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class RacingCarTest {
    @DisplayName(value = "다섯자 이하 이름으로 자동차 생성")
    @ParameterizedTest
    @ValueSource(strings = {"car", "자동차", "람보르기니"})
    void 다섯자_이하_이름으로_자동차_생성(String carName) {
        assertThatNoException().isThrownBy(() -> new RacingCar(carName));
    }

    @DisplayName(value = "다섯자 초과 이름으로 자동차 생성")
    @ParameterizedTest
    @ValueSource(strings = {"아주긴이름의자동차", "6글자자동차", "메르세데스벤츠GLE클래스"})
    void 다섯자_초과_이름으로_자동차_생성(String carName) {
        assertThatThrownBy(() -> new RacingCar(carName)).isInstanceOf(IllegalArgumentException.class);
    }
}
