package _06_refactoring_01;

import lombok.Getter;

import java.time.DayOfWeek;
import java.time.Duration;
import java.time.LocalTime;

/** 반복 일정 */
@Getter
public class RecurringSchedule {
    /** 주제 */
    private String subject;
    /** 반복될 요일 */
    private DayOfWeek dayOfWeek;
    /** 시작 시간 */
    private LocalTime from;
    /** 기간 */
    private Duration duration;

}
