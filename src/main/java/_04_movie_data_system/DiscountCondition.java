package _04_movie_data_system;

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

    public boolean isDiscountable(int sequence) throws IllegalAccessException {
        if (type != DiscountConditionType.SEQUENCE){
            throw new IllegalAccessException();
        }

        return this.sequence == sequence;
    }
}
