package _02_movie;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

/** 상영 기간 기준 할인 조건 */
public class PeriodCondition implements DiscountCondition{

    private DayOfWeek dayOfWeek;
    private LocalTime startTime;
    private LocalTime endTime;

    public PeriodCondition(DayOfWeek dayOfWeek, LocalTime startTime, LocalTime endTime) {
        this.dayOfWeek = dayOfWeek;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    @Override
    public boolean isSatisfiedBy(Screening screening) {
        return screening.
                getStartTime().
                getDayOfWeek().
                equals(dayOfWeek)
                &&
                startTime. compareTo(screening.getStartTime().toLocalTime())
                        <= 0
                &&
                endTime.compareTo(screening.getStartTime().toLocalTime())
                >= 0;
    }
}
