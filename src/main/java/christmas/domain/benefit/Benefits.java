package christmas.domain.benefit;

import christmas.domain.Menu;
import java.util.List;

public class Benefits { //총 혜택 관리용

    private List<Benefit> benefits;

    //증정품 혜택이 존재하는지 확인
    private boolean hasGiftBenefit() {
        for (Benefit benefit : benefits) {
            if (benefit instanceof GiftBenefit) {
                //형변환 되는 경우
                return true;
            }
        }
        return false;
    }

    public Menu getGift() {
        if (!hasGiftBenefit()) {
            return null;
        }

        return benefits.stream()
                .filter(benefit -> benefit instanceof GiftBenefit)
                .map(benefit -> ((GiftBenefit) benefit).getGift())
                .findFirst()
                .orElseThrow(() -> new IllegalStateException());
    }

    public void setBenefits(List<Benefit> benefits) {
        this.benefits = benefits;
    }
}
