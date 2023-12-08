package christmas.view;

import christmas.domain.Menu;
import christmas.domain.benefit.Benefits;
import java.text.DecimalFormat;
import java.util.Map;
import java.util.stream.Collectors;

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
        System.out.println();
    }

    public static void printGiftBenefit(Menu gift) {
        System.out.println("<증정 메뉴>");
        if (gift == null) {
            System.out.println("없음");
            return;
        }
        System.out.println(gift.getName() + " 1개" + System.lineSeparator());
    }

    public static void printBenefitDetails(Benefits benefits) {
        System.out.println("<혜택 내역>");

        if (benefits.getBenefitDetails().size() == 0) {
            System.out.println("없음");
            return;
        }

        String str = benefits.getBenefitDetails().stream()
                .collect(Collectors.joining(System.lineSeparator()));
        System.out.println(str);
        System.out.println();
    }
}
