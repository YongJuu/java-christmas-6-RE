package christmas.view;

import camp.nextstep.edu.missionutils.Console;
import christmas.domain.menu.Menu;
import java.util.HashMap;
import java.util.Map;

public class InputView {

    public static int readVisitDate() {
        System.out.println("안녕하세요! 우테코 식당 12월 이벤트 플래너입니다.");
        System.out.println("12월 중 식당 예상 방문 날짜는 언제인가요? (숫자만 입력해 주세요!)");

        int visiteDate = Integer.parseInt(Console.readLine());

        return visiteDate;
    }

    public static Map<Menu, Integer> readMenus() {
        ///주문 메뉴-개수 타입
        System.out.println("주문하실 메뉴를 메뉴와 개수를 알려 주세요. (e.g. 해산물파스타-2,레드와인-1,초코케이크-1)");
        String order = Console.readLine();

        //처리
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
