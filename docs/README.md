# 자동차 경주 게임
## 기능 목록
### 입력
- [x] 사용자는 경주를 할 자동차의 이름과 이동 횟수를 입력한다.
- [x] 자동차의 이름은 쉼표(,)로 구분하여 입력한다.
- [x] 자동차의 이름이 빈 칸이거나 5자 초과일 경우 오류가 발생한다.
- [x] 입력한 자동차 이름이 2개 미만일 경우 오류가 발생한다.
- [x] 자동차 이름에 공백이 포함될 경우 오류가 발생한다.
- [x] 이동 횟수에 숫자가 아닌 문자가 포함될 경우 오류가 발생한다.
- [x] 이동 횟수가 1보다 작을 경우 오류가 발생한다.
### 게임
- [x] 0과 9 사이에서 랜덤 값을 구하여 4 이상인 경우에만 전진한다.
- [x] 매 횟수마다 자동차의 이동 현황을 출력한다.
- [x] 이동 횟수만큼 이동이 끝나면 자동차 경주 게임이 종료된다.
- [x] 게임이 종료되면 누가 우승했는지 출력한다.
- [x] 우승자가 한 명 이상일 경우 쉼표(,)로 구분하여 출력한다.
### 오류 처리
- [x] 에러 발생 시 `[ERROR]`로 시작하는 에러 메시지를 출력한다.
- [x] 입력에서 오류가 발생할 경우 에러 메시지 출력 후 그 부분부터 다시 입력받는다.
