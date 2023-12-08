package christmas.controller;

import christmas.config.InitEventConfig;
import christmas.domain.Menu;
import christmas.domain.Order;
import christmas.domain.benefit.Benefit;
import christmas.domain.benefit.Benefits;
import christmas.domain.event.Event;
import christmas.view.InputView;
import christmas.view.OutputView;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class EventPlanner {
    private static List<Event> events = InitEventConfig.initEvents();

    public void start() {
        //1) 사용자 입력값 읽기
        int visitDate = InputView.readVisitDate();
        Map<Menu, Integer> menus = InputView.readMenus();

        Order order = new Order(visitDate, menus); //생성함

        //2) 주문 메뉴 형식 맞춰 출력 기능
        OutputView.printOrderMenu(menus);

        //3) 할인 전 총주문 금액 계산하기
        int totalPrice = order.calculateTotalOrderMenusPrice();
        //출력
        OutputView.printTotalPrice(totalPrice);

        /**
         * 이벤트는 모두 적용해야 출력도 가능하다
         */
        Benefits benefits = new Benefits();
        List<Benefit> list = applyAllEvent(order);
        benefits.setBenefits(list);

        //4) 증정 해당되는지 여부 판단 및 출력
        OutputView.printGiftBenefit(benefits.getGift());
        

    }

    private static List<Benefit> applyAllEvent(Order order) {
        List<Benefit> benefits = new ArrayList<>();
        for (Event event : events) {
            if (event.isEvent(order)) {
                //만약 해당되면 담기
                benefits.add(event.doEvent(order));
            }
        }
        return benefits;
    }
}