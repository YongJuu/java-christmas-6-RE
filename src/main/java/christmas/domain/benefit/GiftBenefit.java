package christmas.domain.benefit;

import christmas.domain.Menu;

public class GiftBenefit extends Benefit {
    private final Menu gift;

    public GiftBenefit(String benefitName, int benefitPrice, Menu gift) {
        super(benefitName, benefitPrice);
        this.gift = gift;
    }

    public Menu getGift() {
        return gift;
    }
}
