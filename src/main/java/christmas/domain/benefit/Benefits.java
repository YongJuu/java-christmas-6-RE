package christmas.domain.benefit;

import christmas.domain.menu.Menu;
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

    public List<String> getBenefitDetails() {
        return benefits.stream()
                .map(Benefit::toString)
                .toList();
    }

    //총 혜택금액 계산하기
    public Integer getTotalBenefitPrice() {
        return benefits.stream()
                .map(Benefit::getBenefitPrice)
                .reduce(0, Integer::sum);
    }

    //총 할인금액만 계산
    public Integer getTotalDiscountPrice() {
        return benefits.stream()
                .filter(benefit -> benefit instanceof DiscountBenefit)
                .map(Benefit::getBenefitPrice)
                .reduce(0, Integer::sum);
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
