package christmas.domain;

public enum Menu {
    //에피타이저
    MUSHROOM_SOUP("양송이수프", 6000, MenuType.APPETIZER),
    TAPAS("타파스", 5500, MenuType.APPETIZER),
    CAESAR_SALAD("시저샐러드", 8000, MenuType.APPETIZER),

    //메인
    T_BONE_STEAK("티본스테이크", 55000, MenuType.MAIN),
    BBQ_RIB("바비큐립", 54000, MenuType.MAIN),
    SEAFOOD_PASTA("해산물파스타", 35000, MenuType.MAIN),

    //디저트
    CHOCO_CAKE("초코케이크", 15000, MenuType.DESSERT),
    ICE_CREAM("아이스크림", 5000, MenuType.DESSERT),

    //음료
    ZERO_COLA("제로콜라", 3000, MenuType.DRINK),
    RED_WINE("레드와인", 60000, MenuType.DRINK),
    GHAMPAGNE("샴페인", 25000, MenuType.DRINK);

    //필드
    private final String name;
    private final int price;
    private final MenuType menuType;

    //생성자
    Menu(String name, int price, MenuType menuType) {
        this.name = name;
        this.price = price;
        this.menuType = menuType;
    }

    // String name을 받아 해당하는 Menu를 반환하는 함수
    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public static Menu getMenuByName(String name) {
        for (Menu menu : Menu.values()) {
            if (menu.getName().equalsIgnoreCase(name)) {
                return menu;
            }
        }
        // 이름과 일치하는 메뉴가 없는 경우 null 반환
        return null;
    }
}
