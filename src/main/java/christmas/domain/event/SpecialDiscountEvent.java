package christmas.domain.event;

import christmas.domain.Order;
import christmas.domain.benefit.Benefit;
import christmas.domain.benefit.DiscountBenefit;
import java.util.List;

public class SpecialDiscountEvent extends Event {
    List<Integer> specialDate = List.of(3, 10, 17, 24, 25, 31);

    public SpecialDiscountEvent(int startDate, int endDate) {
        super(startDate, endDate);
    }

    @Override
    public boolean isEvent(Order order) {
        return super.isEvent(order) && specialDate.contains(order.getVisitDate());
    }

    @Override
    public Benefit doEvent(Order order) {
        return new DiscountBenefit("특별 할인", 1000);
    }
}
