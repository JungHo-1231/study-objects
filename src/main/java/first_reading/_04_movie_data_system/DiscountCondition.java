package first_reading._04_movie_data_system;

import lombok.Getter;
import lombok.Setter;

import java.time.DayOfWeek;
import java.time.LocalTime;

@Getter @Setter
public class DiscountCondition {

    private DiscountConditionType type;
    private int sequence;
    private DayOfWeek dayOfWeek;
    private LocalTime startTime;
    private LocalTime endTime;

    public boolean isDiscountable(DayOfWeek dayOfWeek, LocalTime time) throws IllegalAccessException {
        if (type != DiscountConditionType.PERIOD){
            throw new IllegalAccessException();
        }

        return dayOfWeek.equals(dayOfWeek) &&
                startTime.compareTo(time) <=0 &&
                endTime.compareTo(time) >= 0;
    }

    public boolean isDiscountable(Screening screening)  {
        if (type == DiscountConditionType.PERIOD) {
            return isSatisfiedByPeriod(screening);
        }
        return isSatisfiedBySequence(screening);
    }

    private boolean isDiscountable(DiscountCondition condition, Screening screening) {
        if (condition.getType() == DiscountConditionType.PERIOD){
            return  isSatisfiedByPeriod(screening);
        }
        return isSatisfiedBySequence(screening);
    }

    private boolean isSatisfiedByPeriod(Screening screening) {
        return screening.getWhenScreened().getDayOfWeek().equals(dayOfWeek)
                && startTime.isBefore(screening.getWhenScreened().toLocalTime())
                && endTime.isAfter(screening.getWhenScreened().toLocalTime());
    }
    private boolean isSatisfiedBySequence(Screening screening) {
        return sequence == screening.getSequence();
    }

    public boolean isDiscountable(int sequence) {
        return false;
    }
}
