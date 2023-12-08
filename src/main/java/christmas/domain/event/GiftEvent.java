package christmas.domain.event;

import christmas.domain.Menu;
import christmas.domain.Order;
import christmas.domain.benefit.Benefit;
import christmas.domain.benefit.GiftBenefit;

public class GiftEvent extends Event {
    private final Integer priceForGift;
    private final Menu gift;

    public GiftEvent(int startDate, int endDate, int priceForGift, Menu gift) {
        super(startDate, endDate);

        this.priceForGift = priceForGift;
        this.gift = gift;
    }

    @Override
    public boolean isEvent(Order order) {
        return super.isEvent(order) && order.calculateTotalOrderMenusPrice() >= priceForGift;
    }

    @Override
    public Benefit doEvent(Order order) {
        return new GiftBenefit("증정 이벤트", gift.getPrice(), gift);
    }
}