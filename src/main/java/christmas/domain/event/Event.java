package christmas.domain.event;

import christmas.domain.Order;
import christmas.domain.benefit.Benefit;

public abstract class Event { //추상 클래스
    int startDate;
    int endDate;

    protected Event(int startDate, int endDate) {
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public boolean isEvent(Order order) {
        if (order.calculateTotalOrderMenusPrice() < 10000) {
            return false;
        }
        return order.getVisitDate() >= startDate
                && order.getVisitDate() <= endDate;
    }

    public abstract Benefit doEvent(Order order);

}
