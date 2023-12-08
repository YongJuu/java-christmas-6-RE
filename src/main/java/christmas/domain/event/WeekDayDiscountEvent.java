package christmas.domain.event;

import christmas.domain.Menu;
import christmas.domain.MenuType;
import christmas.domain.Order;
import christmas.domain.benefit.Benefit;
import christmas.domain.benefit.DiscountBenefit;
import java.util.Calendar;
import java.util.Date;

public class WeekDayDiscountEvent extends Event {

    public WeekDayDiscountEvent(int startDate, int endDate) {
        super(startDate, endDate);
    }

    @Override
    public boolean isEvent(Order order) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(new Date(2023, 12, order.getVisitDate()));

        int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);

        return super.isEvent(order) && dayOfWeek >= 1 && dayOfWeek <= 5;
    }

    @Override
    public Benefit doEvent(Order order) {
        //평일할인 =디저트1개당 2023 할인
        int count = 0;
        for (Menu menu : order.getMenus().keySet()) {
            if (menu.getMenuType() == MenuType.DESSERT) {
                count += order.getMenus().get(menu);//개수 누적
            }
        }
        return new DiscountBenefit("평일 할인", count * 2023);
    }
}
