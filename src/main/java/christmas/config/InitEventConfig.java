package christmas.config;

import christmas.domain.event.ChristMasDiscountEvent;
import christmas.domain.event.Event;
import christmas.domain.event.GiftEvent;
import christmas.domain.event.SpecialDiscountEvent;
import christmas.domain.event.WeekDayDiscountEvent;
import christmas.domain.event.WeekEndDiscountEvenet;
import christmas.domain.menu.Menu;
import java.util.List;

public class InitEventConfig {
    //여기서 초기화

    public static List<Event> initEvents() {
        Menu gift = Menu.getMenuByName("샴페인");

        List<Event> events = List.of(
                //모든 이벤트 초기화
                new GiftEvent(1, 31, 120000, gift),
                new ChristMasDiscountEvent(1, 25),
                new SpecialDiscountEvent(1, 31),
                new WeekDayDiscountEvent(1, 31),
                new WeekEndDiscountEvenet(1, 31)
        );
        return events;
    }
}