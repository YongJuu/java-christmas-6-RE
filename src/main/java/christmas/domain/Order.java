package christmas.domain;

import java.util.Map;

public class Order {
    int visitDate;
    Map<Menu, Integer> menus;

    public Order(int visitDate, Map<Menu, Integer> menus) {
        this.visitDate = visitDate;
        this.menus = menus;
    }
}
