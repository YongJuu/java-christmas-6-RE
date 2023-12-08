package christmas.domain;

import java.util.Arrays;

public enum Badge {

    SANTA("산타", 20000),
    TREE("트리", 10000),
    STAR("별", 5000);

    //필드
    private String name;
    private Integer price;

    //생성자
    Badge(String name, Integer price) {
        this.name = name;
        this.price = price;
    }

    public static Badge getBadge(Integer totalBenefitPrice) {
        return Arrays.stream(Badge.values())
                .filter(badge -> badge.price <= totalBenefitPrice)
                .findFirst()
                .orElse(null);
    }

    public String getName() {
        return name;
    }
}
