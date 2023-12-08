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

        //4) 증정 해당되는지 여부 판단 및 출력
        Benefits benefits = new Benefits();
        List<Benefit> list = applyAllEvent(order);
        benefits.setBenefits(list);

        OutputView.printGiftBenefit(benefits.getGift());

        //5) 모든 이벤트 적용 후 총 혜택 내역 출력해야 함
        OutputView.printBenefitDetails(benefits);

        //6) 총혜택 금액 출력
        OutputView.printTotalBenefitPrice(benefits.getTotalBenefitPrice());

        //7) 할인 후 예상 결제 금액
        OutputView.printAfterDiscountTotalPrice(totalPrice - benefits.getTotalDiscountPrice());

        //8) 뱃지

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