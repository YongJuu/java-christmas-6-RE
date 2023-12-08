package christmas.config;

import christmas.domain.Menu;
import christmas.domain.event.Event;
import christmas.domain.event.GiftEvent;
import java.util.List;

public class InitEventConfig {
    //여기서 초기화

    public static List<Event> initEvents() {
        Menu gift = Menu.getMenuByName("샴페인");

        List<Event> events = List.of(
                new GiftEvent(1, 31, 120000, gift)
                //모든 이벤트 조건 초기화 여기서 이행하기

        );
        return events;
    }
}