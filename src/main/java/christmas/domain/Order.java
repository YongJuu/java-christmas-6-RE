package christmas.domain;

import java.util.Map;

public class Order {
    int visitDate;
    Map<Menu, Integer> menus;

    public Order(int visitDate, Map<Menu, Integer> menus) {
        this.visitDate = visitDate;
        this.menus = menus;
    }

    //총주문 금액 계산하기
    public int calculateTotalOrderMenusPrice() {
        int totalPrice = 0;
        Map<Menu, Integer> menus = this.menus;

        for (Menu menu : menus.keySet()) {
            int price = menu.getPrice();
            int count = menus.get(menu);//개수
            totalPrice += (price * count);
        }
        return totalPrice;
    }
}
