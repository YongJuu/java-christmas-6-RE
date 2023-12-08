package christmas.controller;

import christmas.domain.Menu;
import christmas.domain.Order;
import christmas.view.InputView;
import java.util.Map;

public class EventPlanner {

    public void start() {
        //1) 사용자 입력값 읽기
        int visitDate = InputView.readVisitDate();
        Map<Menu, Integer> menus = InputView.readMenus();
        
        Order order = new Order(visitDate, menus); //생성함


    }

}
