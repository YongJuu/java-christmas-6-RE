package christmas.view;

import christmas.domain.Menu;
import java.text.DecimalFormat;
import java.util.Map;

public class OutputView {

    //주문 메뉴 출력하기
    public static void printOrderMenu(Map<Menu, Integer> menus) {
        System.out.println("12월 3일에 우테코 식당에서 받을 이벤트 혜택 미리 보기!");
        System.out.println();
        System.out.println("<주문 메뉴>");

        for (Menu menu : menus.keySet()) {
            System.out.println(menu.getName() + " " + menus.get(menu) + "개");
        }
    }

    //총주문 금액 출력하기
    public static void printTotalPrice(int price) {
        System.out.println("할인 전 총주문 금액");

        //형식 맞추기
        DecimalFormat df = new DecimalFormat("###,###");
        String totalPrice = df.format(price);

        System.out.println(totalPrice + "원");
    }
}
