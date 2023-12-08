package christmas.view;

import christmas.domain.Menu;
import java.util.Map;

public class OutputView {

    public static void printOrderMenu(Map<Menu, Integer> menus) {
        System.out.println("<주문 메뉴>");

        for (Menu menu : menus.keySet()) {
            System.out.println(menu.getName() + " " + menus.get(menu) + "개");
        }
    }
}
