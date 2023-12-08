package christmas.domain.benefit;

public abstract class Benefit {
    String benefitName;//이름
    int benefitPrice; //가격

    Benefit(String benefitName, int benefitPrice) {
        this.benefitName = benefitName;
        this.benefitPrice = benefitPrice;
    }
}
