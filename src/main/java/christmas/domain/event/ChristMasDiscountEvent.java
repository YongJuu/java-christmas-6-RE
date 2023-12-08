package christmas.domain.event;

import christmas.domain.Order;
import christmas.domain.benefit.Benefit;
import christmas.domain.benefit.DiscountBenefit;

public class ChristMasDiscountEvent extends Event {

    public ChristMasDiscountEvent(int startDate, int endDate) {
        super(startDate, endDate);
    }

    @Override
    public boolean isEvent(Order order) {
        return super.isEvent(order);
    }

    @Override
    public Benefit doEvent(Order order) {
        int visitDate = order.getVisitDate();

        int discountPrice = (visitDate - startDate) * 100 + 1000;
        return new DiscountBenefit("크리스마스 디데이 할인", discountPrice);
    }
}
