package christmas.domain.benefit;

import java.text.DecimalFormat;

public abstract class Benefit {
    String benefitName;//이름
    int benefitPrice; //가격

    Benefit(String benefitName, int benefitPrice) {
        this.benefitName = benefitName;
        this.benefitPrice = benefitPrice;
    }

    public String toString() {
        DecimalFormat fomatter = new DecimalFormat("###,###");
        return benefitName + ": -" + fomatter.format(benefitPrice) + "원";
    }

    public int getBenefitPrice() {
        return benefitPrice;
    }
}
