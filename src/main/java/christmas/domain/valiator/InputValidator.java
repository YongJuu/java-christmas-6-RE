package christmas.domain.valiator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputValidator {
    private static final String REGEX_PATTERN = "^(?:[a-zA-Z가-힣]+-[1-9][0-9]*,)*[a-zA-Z가-힣]+-[1-9][0-9]*$";

    //입력값 검증용
    public static void visitDateValidate(String visitDate) throws IllegalArgumentException {
        //1) 숫자인지 검증
        for (char x : visitDate.toCharArray()) {
            if (!Character.isDigit(x)) {
                throw new IllegalArgumentException("[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요.");
            }
        }

        //2) 1-31 내의 범위에 있는지 검증
        for (char x : visitDate.toCharArray()) {
            int date = Character.getNumericValue(x);
            if (date < 1 || date > 31) {
                throw new IllegalArgumentException("[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요.");
            }
        }
    }

    //주문 메뉴 입력 형식 검증
    public static void orderMenuFormatValidate(String orderMenu) {
        // 메뉴 형식이 다를 경우 -> 얘를 먼저 해야 함
        Pattern pattern = Pattern.compile(REGEX_PATTERN);
        Matcher matcher = pattern.matcher(orderMenu);
        if (!matcher.matches()) {
            throw new IllegalArgumentException("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
        }
    }

}
