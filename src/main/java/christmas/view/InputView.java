package christmas.view;

import camp.nextstep.edu.missionutils.Console;
import christmas.domain.menu.Menu;
import christmas.domain.valiator.InputValidator;
import java.util.HashMap;
import java.util.Map;

public class InputView {
    //입력값 검증하는 거 작성해야 함
    public static int readVisitDate() {
        System.out.println("안녕하세요! 우테코 식당 12월 이벤트 플래너입니다.");
        System.out.println("12월 중 식당 예상 방문 날짜는 언제인가요? (숫자만 입력해 주세요!)");

        String visitDate = Console.readLine();
        //여기서 1-31에 해당하는 숫자인지 검증 필요
        InputValidator.visitDateValidate(visitDate);

        return Integer.parseInt(visitDate);
    }

    public static Map<Menu, Integer> readMenus() {
        ///주문 메뉴-개수 타입
        System.out.println("주문하실 메뉴를 메뉴와 개수를 알려 주세요. (e.g. 해산물파스타-2,레드와인-1,초코케이크-1)");
        String order = Console.readLine();

        //여기서 입력 메뉴 [형식] 일치하는지 검증 먼저 필요
        InputValidator.orderMenuFormatValidate(order);
        //없는 메뉴인지, 중복 메뉴인지 검증

        //후 처리
        return parseToMenu(order);
    }

    public static Map<Menu, Integer> parseToMenu(String order) {
        String[] oneOrder = order.split(",");
        Map<Menu, Integer> menus = new HashMap<>();

        for (String x : oneOrder) {
            String name = x.split("-")[0];
            int count = Integer.parseInt(x.split("-")[1]);
            Menu menu = Menu.getMenuByName(name);
            if (menu != null) {
                menus.put(menu, count);
            }
        }
        return menus;
    }
}
