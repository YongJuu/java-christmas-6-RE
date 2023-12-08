package christmas.controller;

import christmas.domain.Menu;
import christmas.domain.Order;
import christmas.view.InputView;
import christmas.view.OutputView;
import java.util.Map;

public class EventPlanner {

    public void start() {
        //1) 사용자 입력값 읽기
        int visitDate = InputView.readVisitDate();
        Map<Menu, Integer> menus = InputView.readMenus();

        Order order = new Order(visitDate, menus); //생성함

        //2) 주문 메뉴 형식 맞춰 출력 기능
        OutputView.printOrderMenu(menus);

        //3) 할인 전 총주문 금액 계산하기

    }

}
