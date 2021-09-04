package second_reading._04_movie_data_system;

import first_reading._04_movie_data_system.DiscountConditionType;
import lombok.Getter;
import lombok.Setter;

import java.time.DayOfWeek;
import java.time.LocalTime;

@Getter
@Setter
/** 할인 조건 */
public class DiscountCondition {
    /**
     * 할인 조건 타입
     */
    private DiscountConditionType type;
    /**
     * 순번
     */
    private int sequence;

    /**
     * 요일
     */
    private DayOfWeek dayOfWeek;
    /**
     * 시작 시간
     */
    private LocalTime startTime;
    /**
     * 종료 시간
     */
    private LocalTime endTime;

    public boolean isDiscountable(DayOfWeek dayOfWeek, LocalTime time) throws IllegalAccessException {
        if (type != DiscountConditionType.PERIOD) {
            throw new IllegalAccessException();
        }

        return this.dayOfWeek.equals(dayOfWeek) &&
                this.startTime.compareTo(time) <= 0 &&
                this.endTime.compareTo(time) >= 0;
    }

    public boolean isDiscountable(int sequence) throws IllegalAccessException {
        if (type != DiscountConditionType.SEQUENCE) {
            throw new IllegalAccessException();
        }
        return this.sequence == sequence;
    }
}
