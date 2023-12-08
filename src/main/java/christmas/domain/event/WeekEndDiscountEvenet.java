package christmas.domain.event;

import christmas.domain.Order;
import christmas.domain.benefit.Benefit;
import christmas.domain.benefit.DiscountBenefit;
import christmas.domain.menu.Menu;
import christmas.domain.menu.MenuType;
import java.util.Calendar;
import java.util.Date;

public class WeekEndDiscountEvenet extends Event {

    public WeekEndDiscountEvenet(int startDate, int endDate) {
        super(startDate, endDate);
    }

    @Override
    public boolean isEvent(Order order) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(new Date(2023, 12, order.getVisitDate()));

        int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);

        return super.isEvent(order) && dayOfWeek >= 6 && dayOfWeek <= 7;
    }

    @Override
    public Benefit doEvent(Order order) {
        //특별 할인 = 메인 1개당 2023 할인
        int count = 0;
        for (Menu menu : order.getMenus().keySet()) {
            if (menu.getMenuType() == MenuType.MAIN) {
                count += order.getMenus().get(menu);//개수 누적
            }
        }
        return new DiscountBenefit("주말 할인", count * 2023);
    }
}
